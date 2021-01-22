package com.codeworld.fc.xxl.controller;

import com.codeworld.fc.xxl.response.FcResponse;
import com.codeworld.fc.xxl.service.XxlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName XxlController
 * Description TODO
 * Author Lenovo
 * Date 2021/1/22
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-xxl")
public class XxlController {

    @Autowired(required = false)
    private XxlService xxlService;

    /**
     * 添加任务
     * @return
     */
    @PostMapping("add-job")
    public FcResponse<Void> addJob(){
        return this.xxlService.addJob();
    }
}
