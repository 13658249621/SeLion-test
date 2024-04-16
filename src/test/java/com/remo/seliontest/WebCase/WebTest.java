package com.remo.seliontest.WebCase;
import com.remo.TripMainPage;
import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.InputStreamResource;
import com.remo.seliontest.dataobjects.LoginData;
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

public class WebTest {
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
//        actions.moveByOffset(811, 240).click().perform();
//        actions.moveByOffset(939, 188).click().release().build().perform();

//        File target2 = new File(trip.getSearchButton().getLocator());
        //通过imagegugu方法获取图片的坐标
        clickByImage(driver, new File(trip.getSearchButton().getLocator()));
//        int[] result = imagegugu(driver, target2);
//        actions.moveByOffset(result[0]/2, result[1]/2).click().release().build().perform();

//        driver.findElementByXPath("//*[@id=\"bbz_accounts_pc_lg_box\"]/div/div/div[1]/div[1]/form/dl[1]/dd/input").click();
//        clickByImage(driver, new File(trip.getAccountButton().getLocator()));

        actions.moveByOffset(788, 124).click().perform();
        System.out.println("click account button:"+driver.findElementByXPath("//*[@id=\"bbz_accounts_pc_lg_box\"]/div/div/div[1]/div[1]/form/dl[1]/dd/input").getLocation());
//        driver.findElementByXPath("//*[@id=\"bbz_accounts_pc_lg_box\"]/div/div/div[1]/div[1]/form/dl[1]/dd/input").click();
        driver.getKeyboard().sendKeys("13658249621");
//        clickByImage(driver, new File(trip.getPasswordButton().getLocator()));
//        driver.getKeyboard().sendKeys("iloveyyt1314");
//        clickByImage(driver, new File(trip.getDengluButton().getLocator()));

    }

}