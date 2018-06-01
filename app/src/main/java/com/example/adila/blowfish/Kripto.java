package com.example.adila.blowfish;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Adila on 01-Jun-18.
 */

public class Kripto {

    public static String enkripsi_blowfish(String plainText, String key) {
        try {
            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(1, KS);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            String blowfish = Base64.encodeToString(encrypted, 1).trim();
            return blowfish;
        } catch (Exception var5) {
            return "ERROR:" + var5.getMessage();
        }
    }

    public static String enkripsi_caesar(String PlainText, int shift) {
        String caesar = "";
        for (int i = 0; i < PlainText.length(); i++) {
            int c = PlainText.charAt(i) + shift;
            if (c > 126) {
                c -= 95;
            } else if (c < 32) {
                c += 95;
            }
            caesar += (char) c;
        }
        return caesar;
    }


    public static String dekripsi_blowfish(String cipherText, String key) {
        try {
            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(2, KS);
            byte[] decrypted = cipher.doFinal(Base64.decode(cipherText, 1));
            return new String(decrypted);
        } catch (Exception var5) {
            return "ERROR";
        }
    }

    public static String dekripsi_caesar(String cipherText, int Shift){
        return enkripsi_caesar(cipherText, -Shift);
    }
}
