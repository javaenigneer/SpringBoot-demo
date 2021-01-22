package com.codeworld.fc.xxl.task;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.xxl.entity.User;
import com.codeworld.fc.xxl.util.JsonUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName UserTask
 * Description TODO
 * Author Lenovo
 * Date 2021/1/22
 * Version 1.0
**/
@Component
@Slf4j
public class UserTask {

    @XxlJob(value = "addUser")
    public ReturnT<String> addUser(String param){
        log.info("开始执行任务,在指定时间添加用户，收到参数{}，当前时间{}",param, DateUtil.date(new Date()));
        return ReturnT.SUCCESS;
    }
}
