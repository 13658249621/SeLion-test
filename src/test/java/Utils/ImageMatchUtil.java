package Utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.paypal.selion.platform.grid.SeLionAppiumAndroidDriver;
import okhttp3.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

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

    public static int[] imageMatch(Object driver, File target) throws IOException, AWTException {
        OkHttpClient client = new OkHttpClient();
        File template = null;
        if (driver instanceof SeLionAppiumAndroidDriver) {
            System.out.println("SeLionAppiumAndroidDriver");
            SeLionAppiumAndroidDriver appiumDriver = (SeLionAppiumAndroidDriver) driver;
            long start = System.currentTimeMillis();
            template = appiumDriver.getScreenshotAs(OutputType.FILE);
            long end = System.currentTimeMillis();
        }
        else if (driver instanceof RemoteWebDriver) {
            System.out.println("RemoteWebDriver");
            RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
            Robot robot = new Robot();
            java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("screenSize: " + screenSize);
            screenSize.setSize(screenSize.getWidth(), screenSize.getHeight() - 70);
            Rectangle screenRectangle = new Rectangle(0,25,1440,805);
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            template = new File("screenshot.png");
            ImageIO.write(image, "png", template);
        }  else {
            throw new IllegalArgumentException("Invalid driver type");
        }
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

    public static Boolean clickByImage(Object driver, File target) throws IOException, AWTException {
        int[] result = imageMatch(driver, target);

        if (driver instanceof JysAndroidDriver) {
            System.out.println("JysAndroidDriver:");
            ((JysAndroidDriver) driver).tap(1, result[0], result[1], 200);

        } else if (driver instanceof RemoteWebDriver) {
            System.out.println("RemoteWebDriver:");
            Actions actions = new Actions((RemoteWebDriver) driver);
            actions.moveByOffset(result[0], result[1]-164).click().perform();

        } else {
            throw new IllegalArgumentException("Invalid driver type");
        }
        return true;
    }
}
