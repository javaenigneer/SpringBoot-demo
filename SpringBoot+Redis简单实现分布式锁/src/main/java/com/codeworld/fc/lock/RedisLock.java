package com.codeworld.fc.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * ClassName RedisLock
 * Author Lenovo
**/
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param lockKey
     * @param timeStamp
     * @return
     */
    public boolean lock(String lockKey, String timeStamp){
        if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey,timeStamp)){
            // 对应setnx命令，可以成功设置,也就是key不存在，获得锁成功
            return true;
        }
        // 设置失败，获取锁失败
        // 判断锁超时 - 防止原来的操作异常，没有运行解锁操作 ，防止死锁
        String currentLock = stringRedisTemplate.opsForValue().get(lockKey);
        if (currentLock != null && Long.parseLong(currentLock) < System.currentTimeMillis()){
            //如果lockKey对应的锁已经存在，获取上一次设置的时间戳之后并重置lockKey对应的锁的时间戳
            String preLock = stringRedisTemplate.opsForValue().getAndSet(lockKey, timeStamp);
            //假设两个线程同时进来这里，因为key被占用了，而且锁过期了。
            //获取的值currentLock=A(get取的旧的值肯定是一样的),两个线程的timeStamp都是B,key都是K.锁时间已经过期了。
            //而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的timeStamp已经变成了B。
            //只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if (preLock != null && preLock.equals(currentLock)){
                return true;
            }
        }
        return false;
    }

    /**
     * 释放锁
     * @param lockKey
     * @param timeStamp
     */
    public void release(String lockKey, String timeStamp){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(lockKey);
            if (timeStamp.equals(currentValue)){
                // 删除锁的状态
                stringRedisTemplate.opsForValue().getOperations().delete(lockKey);
                log.info("释放锁成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("释放锁异常！");
        }
    }
}
