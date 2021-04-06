package com.codeworld.fc.controller;

import com.codeworld.fc.lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName TestController
 * Author Lenovo
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private RedisLock redisLock;
    /**
     * 超时时间 5s
     */
    private static final int TIMEOUT = 5 * 1000;

    private static int count = 1000;

    @PostMapping("test-create")
    public String testCreate() {
        long time = System.currentTimeMillis() + TIMEOUT;
        // 加锁
        if (!this.redisLock.lock("test", String.valueOf(time))) {
            log.error("接口请求异常，加锁中");
            return "请稍后再试";
        }
        try {
            try {
                //为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            // 执行业务代码
            log.info("业务代码执行完成");
            log.info("count：{}",count);
            return "请求成功";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            this.redisLock.release("test", String.valueOf(time));
        }
        return "请稍后再试";
    }
}
