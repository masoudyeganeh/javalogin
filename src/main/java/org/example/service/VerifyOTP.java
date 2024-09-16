package org.example.service;

import okhttp3.*;
import org.example.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class VerifyOTP {

    public static Integer sendOTP(User user) {
//        Integer otp = ThreadLocalRandom.current().nextInt(1000, 10000);
//        String phonenumber = user.getCellphone();
//        String url = String.format("https://api.sms-webservice.com/api/V3/Send?ApiKey=268163-698e6b81a5534b2598aff17ecaa8be66&Text=%d&Sender=50004075012039&Recipients=%s", otp, phonenumber);
//        String requestBody = "{\"iban\" : \"" + shebaNo + "\"}";
//
//        Map<String, String> resultMap = new HashMap<>();
//        String status;
//        String bankAccountNumber = "";
//
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setRequestProperty("X-CLIENT-TOKEN", "51befe52-1a38-45c5-af0d-34b75a0fb45e");
//        connection.setDoOutput(true);
//
//        try {
//            OutputStream outputStream = connection.getOutputStream();
//            outputStream.write(requestBody.getBytes());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String response = reader.lines().collect(Collectors.joining());
//            Map<String, Object> jsonMap = objectMapper.readValue(response, Map.class);
//            status = "success";
//            bankAccountNumber = (String) jsonMap.get("response");
//        } catch (Exception e) {
//            status = "error";
//        }
//
//        resultMap.put("status", status);
//        resultMap.put("bankAccountNumber", bankAccountNumber);
//        return resultMap;
//    }
//        Integer otp = ThreadLocalRandom.current().nextInt(1000, 10000);
//        System.out.println(otp);
//        return otp;
        int r = 0;
        Integer otp = ThreadLocalRandom.current().nextInt(1000, 10000);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        String phonenumber = user.getCellphone();
        Request request = new Request.Builder()
                .url(String.format("https://api.sms-webservice.com/api/V3/Send?ApiKey=268163-698e6b81a5534b2598aff17ecaa8be66&Text=%d&Sender=50004075012039&Recipients=%s", otp, phonenumber))
//                .method("GET", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                r = otp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
