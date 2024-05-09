package com.remo.seliontest.Utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.openqa.selenium.OutputType;

import java.awt.*;
import java.io.File;

import java.io.IOException;

public class ImageMatchUtil {
    final static String URL = "http://127.0.0.1:5000/upload";
    final static String template = "/Users/admin/Downloads/模板1.png";
    final static String target = "/Users/admin/Downloads/目标2.png";

    public static void main(String[] args) throws IOException {
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        // 构造MultipartBody对象
        MediaType mediaType = MediaType.parse("image/jpeg");
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file1", "tem.jpg", RequestBody.create(mediaType, new File(template)))
                .addFormDataPart("file2", "tar.png", RequestBody.create(mediaType, new File(target)))
                .build();

        // 构造请求对象
        Request request = new Request.Builder()
                .url(URL)
                .post(requestBody)
                .build();

        // 发起请求并获取响应
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        // 输出响应数据
        System.out.println(response.body().string());
    }

    public static int[] imageMatch(JysAndroidDriver driver, File target) throws IOException, AWTException {
        OkHttpClient client = new OkHttpClient();
        File template = null;
        System.out.println("SeLionAppiumAndroidDriver");
        template = driver.getScreenshotAs(OutputType.FILE);


        MediaType mediaType = MediaType.parse("image/jpeg");
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file1", "tem.jpg", RequestBody.create(mediaType, template))
                .addFormDataPart("file2", "tar.png", RequestBody.create(mediaType, target))
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        JSONObject jsonObject = JSONObject.parseObject(response.body().string());
        JSONArray jsonArray = jsonObject.getJSONArray("pos");
        System.out.println(jsonArray);
        int[] result = new int[2];
        result[0] = jsonArray.getInteger(0);
        result[1] = jsonArray.getInteger(1);
        return result;
    }

    public static Boolean clickByImage(JysAndroidDriver driver, File target) throws IOException, AWTException {
        int[] result = imageMatch(driver, target);
        System.out.println("JysAndroidDriver:");
        ((JysAndroidDriver) driver).tap(1, result[0], result[1], 200);
        return true;
    }

}
