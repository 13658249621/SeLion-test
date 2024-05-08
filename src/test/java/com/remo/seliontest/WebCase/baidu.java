package com.remo.seliontest.WebCase;

import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.InputStreamResource;
import com.remo.TripMainPage;
import com.remo.seliontest.PageObjects.LoginData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static Utils.ImageMatchUtil.clickByImage;

public class baidu {
    private static final String URL = "https://www.baidu.com/";

    @DataProvider(name = "loginFailProvider")
    public Object[][] getLoginFailProvider() throws IOException {
        DataResource resource = new InputStreamResource(new FileInputStream("src/test/resources/testdata/loginFail.json"), LoginData.class, "json");
        SeLionDataProvider dataProvider = DataProviderFactory.getDataProvider(resource);
        return dataProvider.getAllData();
    }

    @Test(dataProvider = "loginFailProvider")
    @com.paypal.selion.annotations.WebTest
    public void loginFail(LoginData data) throws IOException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/SeLion-test/src/test/resources/chromedriver");
        //初始化一个chrome浏览器实例，实例名称叫driver
        RemoteWebDriver driver = new ChromeDriver();
        driver.get(URL);

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
        TripMainPage trip = new TripMainPage();

        Thread.sleep(1000);

//        actions.moveByOffset(788, 124).click().perform();
//        clickByImage(driver,new File(trip.getResouButton().getLocator()));
        Thread.sleep(1000);
//        clickByImage(driver,new File(trip.getChakangengduobangdanButton().getLocator()));
//        System.out.println("click account button:"+driver.findElementByXPath("//*[@id=\"bbz_accounts_pc_lg_box\"]/div/div/div[1]/div[1]/form/dl[1]/dd/input").getLocation());
//        driver.findElementByXPath("//*[@id=\"bbz_accounts_pc_lg_box\"]/div/div/div[1]/div[1]/form/dl[1]/dd/input").click();
//        driver.getKeyboard().sendKeys("13658249621");
//        clickByImage(driver,new File(trip.getBaiduButton().getLocator()));


    }

}