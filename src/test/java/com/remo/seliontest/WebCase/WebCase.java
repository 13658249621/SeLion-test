package com.remo.seliontest.WebCase;

import com.remo.seliontest.Utils.JysWebDriver;
import com.remo.Web.ZhipinMainPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import static com.remo.seliontest.Utils.CustomSeLionReporter.logAndCapture;

public class WebCase {
    private static final String URL = "https://boss-m-qa.weizhipin.com/web/boss/login.html";
    @Test
    public void WebCase() throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/SeLion-test/src/test/resources/chromedriver");
        JysWebDriver driver = new JysWebDriver();
        driver.get(URL);
        ZhipinMainPage zhipinMainPage = new ZhipinMainPage();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(zhipinMainPage.getZhanghaoshuruButton()).sendKeys("14000034603");
        driver.findElement(zhipinMainPage.getDengluButton()).click();
        Thread.sleep(4000);
        logAndCapture(driver, "点击登录进入首页");
        driver.findElement(zhipinMainPage.getYixianggoutongButton()).click();
        Thread.sleep(1000);
        logAndCapture(driver, "点击意向沟通");
        Actions actions = new Actions(driver);
        actions.moveByOffset(848, 780).click().perform();
        //换一种方式，不使用actions
//        clickByImage(driver, new File(ZhipinPage.问意向.getImagePath()));
        Thread.sleep(1000);

//        logAndCapture(  driver, "点击发现");
//        clickByImage(driver, new File(ZhipinPage.首页.getImagePath()));
//        Thread.sleep(1000);
//        logAndCapture(  driver, "点击首页");
//        clickByImage(driver, new File(ZhipinPage.推荐.getImagePath()));


    }
}
