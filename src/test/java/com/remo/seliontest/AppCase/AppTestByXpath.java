package com.remo.seliontest.AppCase;

import com.paypal.selion.annotations.MobileTest;

import com.remo.App.*;
import com.remo.seliontest.PageObjects.WeiboMainPage;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import com.remo.seliontest.Utils.JysAndroidDriver;

import static com.remo.seliontest.Utils.CustomSeLionReporter.logAndCapture;
import static com.remo.seliontest.Utils.ImageMatchUtil.clickByImage;


public class AppTestByXpath {
    @Test
    @MobileTest(appName = "com.sina.weibo", device = "android:10",mobileNodeType="appium")
    public void testLaunchPPHApp_android() throws Exception {
        // 设置 Appium 服务器的 URL
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appName", "com.sina.weibo");
        caps.setCapability("noReset", "true");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "e5f430b");
//        caps.setCapability("appPackage", "org.mozilla.firefox");
        caps.setCapability("appPackage", "com.sina.weibo");
//        caps.setCapability("appActivity", "org.mozilla.fenix.HomeActivity");
        caps.setCapability("appActivity", "com.sina.weibo.MainTabActivity");

        JysAndroidDriver jysAndroidDriver = new JysAndroidDriver(url,caps);

        Thread.sleep(2000);
        WeiboMobile weiboMobile = new WeiboMobile();
        MyMainPage myMainPage = new MyMainPage();
        MyOrderMainPage myOrderMainPage = new MyOrderMainPage();
        MyAddressPage myAddressPage = new MyAddressPage();
        EditAddressPage editAddressPage = new EditAddressPage();
        myAddressPage.getTianjiadizhiUiObject().getLocator();
        clickByImage(jysAndroidDriver,new File(WeiboMainPage.我的.getImagePath()));
        Thread.sleep(1000);
//        jysAndroidDriver.findElement(weiboMobile.getWodeUiObject()).click();
        jysAndroidDriver.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000);
        jysAndroidDriver.findElement(myMainPage.getWodedingdanUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击我的订单");
        Thread.sleep(1000);
        jysAndroidDriver.findElement(myOrderMainPage.getGengduogongjuUiObject()).click();
        logAndCapture(jysAndroidDriver,"点击更多工具");
        Thread.sleep(1000);
        jysAndroidDriver.findElement(myOrderMainPage.getShouhuodizhiUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击收货地址");
        jysAndroidDriver.findElement(myAddressPage.getTianjiadizhiUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击添加地址");
        jysAndroidDriver.findElement(editAddressPage.getShoujianrenUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击添加地址");
        jysAndroidDriver.findElement(editAddressPage.getShoujianrenUiObject()).sendKeys("123124");

    }
}