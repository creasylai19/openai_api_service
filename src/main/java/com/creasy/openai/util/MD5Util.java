package com.creasy.openai.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String calculateMD5(String input) {
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5Digest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : md5Hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateMD5("{\"username\":\"root\",\"password\":\"root\"}"));
    }

}
