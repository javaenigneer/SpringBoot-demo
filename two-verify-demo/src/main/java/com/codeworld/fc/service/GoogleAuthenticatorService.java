package com.codeworld.fc.service;

import com.codeworld.fc.dao.UserDao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.ICredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * ClassName GoogleAuthenticatorService
 * Description TODO
 * Author Lenovo
 * Date 2020/12/10
 * Version 1.0
**/
@Service
@Slf4j
public class GoogleAuthenticatorService {

    private static final GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
    private static final String KEY_FORMAT = "otpauth://totp/%s?secret=%s";
    private static final String IMAGE_EXT = "png";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;


    @Autowired(required = false)
    private UserDao userDao;
    @PostConstruct
    public void init() {
        googleAuthenticator.setCredentialRepository(new ICredentialRepository() {
            @Override
            public String getSecretKey(String userName) {
                return userDao.getSecretKey(userName);
            }

            @Override
            public void saveUserCredentials(String userName, String secretKey, int validationCode, List<Integer> scratchCodes) {
                //secretKey要保存在数据库中
                userDao.saveUserCredentials(userName, secretKey);
            }
        });
        log.info("GoogleAuthenticator初始化成功");
    }

    /**
     * 生成二维码
     * @param username
     * @param stream
     */
    public void genQRImage(String username, ServletOutputStream stream) {

        try {
            String content = getQrUrl(username);
            BitMatrix bm = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
            MatrixToImageWriter.writeToStream(bm, IMAGE_EXT, stream);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码链接
     */
    private String getQrUrl(String username) {
        //每次调用createCredentials都会生成新的secretKey
        GoogleAuthenticatorKey key = googleAuthenticator.createCredentials(username);
        log.info("username={},secretKey={}", username, key.getKey());
        return String.format(KEY_FORMAT, username, key.getKey());
    }

    public boolean validCode(String username, int code) {
        return googleAuthenticator.authorizeUser(username, code);
    }
}
