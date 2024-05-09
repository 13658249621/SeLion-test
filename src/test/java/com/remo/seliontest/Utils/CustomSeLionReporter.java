package com.remo.seliontest.Utils;

import com.paypal.selion.internal.reports.model.BaseLog;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomSeLionReporter {
    public static void logAndCapture(JysWebDriver driver, String message) {
        // 截图并保存到项目中
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        Path destPath = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots", screenshot.getName());
        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(screenshot.toPath(), destPath);
        } catch (IOException e) {
            throw new RuntimeException("保存失败: " + e.getMessage(), e);
        }
        // 创建 BaseLog 对象并记录日志
        BaseLog log = new BaseLog();
        log.setMsg(message);
        // 将截图的相对路径添加到 image 字段中
        log.setScreen("screenshots/" + screenshot.getName());
        Reporter.log(log.toString());
    }
    public static void logAndCapture(JysAndroidDriver driver, String message) {
        // 截图并保存到文件系统中
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        Path destPath = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots", screenshot.getName());
        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(screenshot.toPath(), destPath);
        } catch (IOException e) {
            throw new RuntimeException("保存失败: " + e.getMessage(), e);
        }
        // 创建 BaseLog 对象并记录日志
        BaseLog log = new BaseLog();
        log.setMsg(message);
        // 将截图的相对路径添加到 image 字段中
        log.setScreen("screenshots/" + screenshot.getName());
        Reporter.log(log.toString());
    }
}