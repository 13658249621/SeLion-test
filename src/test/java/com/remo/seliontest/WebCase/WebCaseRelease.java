package com.remo.seliontest.WebCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.remo.Web.ZhipinMainPage;
import com.remo.seliontest.Utils.JysWebDriver;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import static com.remo.seliontest.Utils.CustomSeLionReporter.logAndCapture;

public class WebCaseRelease {
    private static final String URL = "https://pre-www.zhipin.com/web/chat/index";
    @Test
    public void WebCase() throws IOException, InterruptedException, AWTException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pre-www.zhipin.com/wapi/zppassport/test/wt?userId=612757550")
                .build();
        Response response = client.newCall(request).execute();
        String resStr=response.body().string();
        JSONObject jsonObject = JSON.parseObject(resStr);
        String wt2 = jsonObject.getJSONObject("zpData").getString("wt2");
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/SeLion-test/src/test/resources/chromedriver");
        JysWebDriver driver = new JysWebDriver();
        driver.get(URL);
        Cookie cookie = new Cookie.Builder("wt2", wt2)
                .domain("pre-www.zhipin.com")
                .build();
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        ZhipinMainPage zhipinMainPage = new ZhipinMainPage();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(zhipinMainPage.getYixianggoutongButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击意向沟通");
        WebElement iframeElement = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElement);

        driver.findElement(zhipinMainPage.getWodedingdanButton()).click();
        Thread.sleep(3000);
        logAndCapture(driver, "点击我的订单");
        driver.findElement(zhipinMainPage.getGoutongwanchengButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击沟通完成");
        driver.findElement(zhipinMainPage.getGuanbiyindaoyiButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击关闭引导1");
        driver.findElement(zhipinMainPage.getGuanbiyindaoerButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击关闭引导2");
        driver.findElement(zhipinMainPage.getChakanyixiangButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击查看意向");
        driver.findElement(zhipinMainPage.getNiurenjianliButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击牛人简历");



    }
}
