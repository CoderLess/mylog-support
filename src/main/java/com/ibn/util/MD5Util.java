package com.ibn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.util
 * @author： RenBin
 * @createTime：2020/1/20 15:42
 */
public class MD5Util {
    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    /**
     * @description: 对明文进行md5加密
     * @author：RenBin
     * @createTime：2020/1/20 15:43
     */
    public static String getMd5Code(String str) {
        StringBuilder sb = null;
        try {
            //创建加密对象
            //参数1: 算法名字
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //进行加密  返回加密之后结果也是字节
            byte[] digest = messageDigest.digest(str.getBytes());
            sb = new StringBuilder();
            for (byte b : digest) {
                //位运算
                int len = b & 0xff;
                if (len <= 15) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(len));
            }
        } catch (NoSuchAlgorithmException e) {
            String msg = String.format("生成md5失败:%s", str);
            logger.error(msg, e);
        }
        return sb.toString();
    }
}
