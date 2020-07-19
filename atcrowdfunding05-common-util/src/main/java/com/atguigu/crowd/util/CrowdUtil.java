package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUtil {

    public static String md5(String source){
        if (source==null || source.length()==0){
            new RuntimeException("字符串不合法！请不要传入空字符串！");
        }
        try {
            // 获取MessageDigest对象
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            // 获取明文字符串的字节数组
            byte[] input = source.getBytes();
            // 执行加密
            byte[] output = messageDigest.digest(input);
            // 创建BigInteger对象
            BigInteger bigInteger = new BigInteger(1, output);
            // 按照16进制将bigInteger转换为字符串
            String encoded = bigInteger.toString(16).toUpperCase();
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
