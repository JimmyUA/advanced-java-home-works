package com.sergey.prykhodko.homework8.mockito;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityService {


    public String md5(String string) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(string.getBytes());

        byte[] md5String = digest.digest();

        StringBuilder hashedString = new StringBuilder();

        for (byte aMd5String : md5String) {
            hashedString.append(Integer.toHexString(0xFF & aMd5String));
        }

        return hashedString.toString();
    }
}
