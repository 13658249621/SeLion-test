package com.remo.seliontest.AppCase;

import com.paypal.selion.annotations.MobileTest;

import com.remo.App.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import com.remo.seliontest.Utils.JysAndroidDriver;
import org.testng.annotations.Test;

import static com.remo.seliontest.Utils.CustomSeLionReporter.logAndCapture;


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
        caps.setCapability("unicodeKeyboard", "true");
        caps.setCapability("resetKeyboard", "true");
        caps.setCapability("appName", "com.sina.weibo");
        caps.setCapability("noReset", "true");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "e5f430b");
        caps.setCapability("appPackage", "com.sina.weibo");
        caps.setCapability("appActivity", "com.sina.weibo.MainTabActivity");

        JysAndroidDriver jysAndroidDriver = new JysAndroidDriver(url,caps);

        Thread.sleep(2000);
        WeiboMobile weiboMobile = new WeiboMobile();
        MyMainPage myMainPage = new MyMainPage();
        MyOrderMainPage myOrderMainPage = new MyOrderMainPage();
        MyAddressPage myAddressPage = new MyAddressPage();
        EditAddressPage editAddressPage = new EditAddressPage();
        myAddressPage.getTianjiadizhiUiObject().getLocator();
//        clickByImage(jysAndroidDriver,new File(WeiboMainPage.我的.getImagePath()));
        Thread.sleep(1000);
        jysAndroidDriver.findElement(weiboMobile.getWodeUiObject()).click();
        logAndCapture(jysAndroidDriver,"点击我的");
        Thread.sleep(2000);
        jysAndroidDriver.findElement(myMainPage.getWodedingdanUiObject()).click();
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"点击我的订单");
        jysAndroidDriver.findElement(myOrderMainPage.getGengduogongjuUiObject()).click();
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"点击更多工具");
        jysAndroidDriver.findElement(myOrderMainPage.getShouhuodizhiUiObject()).click();
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"点击收获地址");
        jysAndroidDriver.findElement(myAddressPage.getTianjiadizhiUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击添加地址");
        jysAndroidDriver.findElement(editAddressPage.getShoujianrenUiObject()).click();
        jysAndroidDriver.findElement(editAddressPage.getShoujianrenUiObject()).sendKeys("你好啊");
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"输入收件人姓名");
        jysAndroidDriver.findElement(editAddressPage.getShoujihaoUiObject()).click();
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"点击手机号");
        jysAndroidDriver.findElement(editAddressPage.getShoujihaoUiObject()).sendKeys("13658249721");
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"输入手机号");
        jysAndroidDriver.findElement(editAddressPage.getSuozaidiquUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击所在地区");
        jysAndroidDriver.findElement(editAddressPage.getBeijingshengUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击北京市");
        jysAndroidDriver.findElement(editAddressPage.getBeijingshiUiObject()).click();
        jysAndroidDriver.findElement(editAddressPage.getDongchengquUiObject()).click();
        Thread.sleep(1000);
        logAndCapture(jysAndroidDriver,"点击东城区");
        jysAndroidDriver.findElement(editAddressPage.getXiangxidizhiUiObject()).click();
        jysAndroidDriver.findElement(editAddressPage.getXiangxidizhiUiObject()).sendKeys("123124");
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"输入详细地址");
        jysAndroidDriver.findElement(editAddressPage.getBaocunUiObject()).click();
        Thread.sleep(2000);
        logAndCapture(jysAndroidDriver,"点击保存");
        jysAndroidDriver.quit();
    }
}