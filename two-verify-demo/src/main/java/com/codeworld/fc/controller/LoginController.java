package com.codeworld.fc.controller;

import com.codeworld.fc.service.GoogleAuthenticatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName LoginController
 * Description TODO
 * Author Lenovo
 * Date 2020/12/10
 * Version 1.0
**/
@RestController
public class LoginController {

    @Autowired
    private GoogleAuthenticatorService googleAuthenticatorService;

    /**
     * 二次验证，生成二维码
     */
    @RequestMapping("/qrcode")
    public void qrcode(String username, HttpServletResponse response) {
        try (ServletOutputStream stream = response.getOutputStream()) {
            googleAuthenticatorService.genQRImage(username, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
