package com.remo.seliontest.AppCase;
import com.remo.seliontest.Utils.JysAndroidDriver;
import com.remo.seliontest.PageObjects.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.remo.seliontest.Utils.CustomSeLionReporter.logAndCapture;
import static com.remo.seliontest.Utils.ImageMatchUtil.clickByImage;


public class AppTestByImage {
    @Test
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
        caps.setCapability("noReset", "true");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "e5f430b");
        caps.setCapability("appPackage", "com.sina.weibo");
        caps.setCapability("appActivity", "com.sina.weibo.MainTabActivity");

        JysAndroidDriver driver=new JysAndroidDriver(url,caps);
        Thread.sleep(2000);
        clickByImage(driver,new File(WeiboMainPO.我的.getImagePath()));
        Thread.sleep(1000);
        logAndCapture(driver,"点击我的");
        clickByImage(driver,new File(MyMainPO.我的订单.getImagePath()));
        Thread.sleep(1000);
        logAndCapture(driver,"点击我的订单");
        clickByImage(driver,new File(MyOrderMainPO.更多工具.getImagePath()));
        Thread.sleep(1000);
        logAndCapture(driver,"点击更多工具");
        clickByImage(driver,new File(MyOrderMainPO.收货地址.getImagePath()));
        Thread.sleep(2000);
        logAndCapture(driver,"点击收获地址");
        clickByImage(driver,new File(ReceiveAddressPO.添加地址.getImagePath()));
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.收货人姓名.getImagePath()));
        driver.getKeyboard().sendKeys("张三");
        driver.getKeyboard().sendKeys("123");
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.收货人手机号.getImagePath()));
        driver.getKeyboard().sendKeys("13658249621");
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.选择地区.getImagePath()));
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.河北省.getImagePath()));
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.石家庄市.getImagePath()));
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.长安区.getImagePath()));
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.详细地址.getImagePath()));
        driver.getKeyboard().sendKeys("31");
        Thread.sleep(1000);
        clickByImage(driver,new File(AddAddressPO.保存.getImagePath()));





    }
}