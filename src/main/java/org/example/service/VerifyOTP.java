package org.example.service;

import okhttp3.*;
import org.example.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VerifyOTP {

    public static Integer sendOTP(User user) {
        Integer otp = ThreadLocalRandom.current().nextInt(1000, 10000);
        System.out.println(otp);
        return otp;
//        int r = 0;
//        Integer otp = ThreadLocalRandom.current().nextInt(1000, 10000);
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        String phonenumber = user.getCellphone();
//        Request request = new Request.Builder()
//                .url(String.format("http://api.sms-webservice.com/api/V3/Send?ApiKey=123456&Text=%s&Sender=123654&Recipients=%s", otp, phonenumber))
//                .method("GET", body)
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            if (response.isSuccessful()) {
//                r = otp;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return r;
    }
}
