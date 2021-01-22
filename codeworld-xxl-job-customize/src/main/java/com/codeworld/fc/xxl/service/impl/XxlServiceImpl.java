package com.codeworld.fc.xxl.service.impl;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.xxl.domain.XxlJobInfo;
import com.codeworld.fc.xxl.entity.User;
import com.codeworld.fc.xxl.response.FcResponse;
import com.codeworld.fc.xxl.service.XxlService;
import com.codeworld.fc.xxl.util.DateUtils;
import com.codeworld.fc.xxl.util.JsonUtils;
import com.codeworld.fc.xxl.util.XxlUtil;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName XxlServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/22
 * Version 1.0
**/
@Service
@Slf4j
public class XxlServiceImpl implements XxlService {

    @Autowired(required = false)
    private XxlUtil xxlUtil;

    /**
     * 添加任务
     *
     * @return
     */
    @Override
    public FcResponse<Void> addJob() {
        User user = new User();
        user.setId(1000L);
        user.setUserName("code");
        user.setCreateTime(new Date());
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setJobDesc("测试用户定时添加");
        xxlJobInfo.setAuthor("admin");
        xxlJobInfo.setScheduleType("CRON");
        Date startTime = new Date(user.getCreateTime().getTime() + 60000);
        xxlJobInfo.setScheduleConf(DateUtils.getCron(startTime));
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setExecutorHandler("addUser");
        xxlJobInfo.setExecutorParam(JsonUtils.serialize(user));
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setMisfireStrategy("DO_NOTHING");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setTriggerStatus(1);
        xxlUtil.addJob(xxlJobInfo, "xxl-job-test");
        log.info("任务已添加，将在{}开始执行任务",DateUtil.date(startTime));
        return new FcResponse<>(1,"任务添加成功",null);
    }
}
