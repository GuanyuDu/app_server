package com.guanyu.app.util;

import java.security.MessageDigest;

public class MD5 {

    /**
     * 生成 MD5 摘要
     **/
    public static String digest(String str) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] barr = md.digest(str.getBytes());
            StringBuilder buffer = new StringBuilder();
            for (byte b : barr) {
                buffer.append(byte2Hex(b));
            }
            String hex = buffer.toString();
            md5 = hex.toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }

    public static String byte2Hex(byte b) {
        String[] h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int i = b;
        if (i < 0) {
            i += 256;
        }
        return h[i / 16] + h[i % 16];
    }
}
