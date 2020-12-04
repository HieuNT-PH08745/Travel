package vn.nuce;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static String formatDate(String date) {
        String[] dates = date.split(" ");
        date = dates[0];
        String[] datetime = date.split("-");
        date = datetime[2] + "/" + datetime[1] + "/" + datetime[0];
        return date;
    }

    public static String encodePasswordMD5(String password) {
        String encodedPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            encodedPassword = sb.toString();
            return encodedPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodedPassword;
    }
}
