package com.example.nativeqry.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.jasypt.salt.RandomSaltGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Base64;

@Service
public class DataSecurityService {
    private StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    /**
     * PASSWORD.ENCRYPTION.ALGORITHM=PBEWithMD5AndDES
     * PASSWORD.ENCRYPTION.PASSCODE=U1VQRVJfU0VDVVJFX1BBU1NDT0RF
     */
    @Value("${PASSWORD.ENCRYPTION.ALGORITHM:PBEWithMD5AndDES}")
    String algorithm;

    @Value("${PASSWORD.ENCRYPTION.PASSCODE:U1VQRVJfU0VDVVJFX1BBU1NDT0RF}")
    String key;

    @PostConstruct
    public void init() {
        encryptor.setAlgorithm(algorithm);
        encryptor.setPassword(new String(Base64.getDecoder().decode(key)));
        encryptor.setSaltGenerator(new RandomSaltGenerator());
        encryptor.setIvGenerator(new RandomIvGenerator());
    }

    public String encryption(String text) {
        return encryptor.encrypt(text);
    }

    public String decryption(String code) {

        return encryptor.decrypt(code);
    }

}
