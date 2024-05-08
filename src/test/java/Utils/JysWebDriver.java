package Utils;

import com.paypal.selion.platform.html.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.net.URL;

public class JysWebDriver extends ChromeDriver {
    public JysWebDriver() {
        super();
    }
    public WebElement findElement(String using) {
        //判断是否有=号，没有则用xpath定位，有则根据=号前的字符判断使用不同的定位方式
        if (using.contains("=")) {
            String[] str = using.split("=");
            if (str[0].equals("xpath")) {
                return this.findElement(By.xpath(str[1]));

            } else if (str[0].equals("id")) {
                return this.findElement(By.id(str[1]));
            } else if (str[0].equals("name")) {
                return this.findElement(By.name(str[1]));
            } else if (str[0].equals("class")) {
                return this.findElement(By.className(str[1]));
            } else if (str[0].equals("linkText")) {
                return this.findElement(By.linkText(str[1]));
            } else if (str[0].equals("partialLinkText")) {
                return this.findElement(By.partialLinkText(str[1]));
            } else if (str[0].equals("tagName")) {
                return this.findElement(By.tagName(str[1]));
            } else if (str[0].equals("css")) {
                return this.findElement(By.cssSelector(str[1]));
            } else {
                return null;
            }
        } else {
            return this.findElement(By.xpath(using));
        }
    }
    public WebElement findElement(Button button){
        String using = button.getLocator();
        if (using.contains("=")) {
            String[] str = using.split("=");
            if (str[0].equals("xpath")) {
                return this.findElement(By.xpath(str[1]));
            } else if (str[0].equals("id")) {
                return this.findElement(By.id(str[1]));
            } else if (str[0].equals("name")) {
                return this.findElement(By.name(str[1]));
            } else if (str[0].equals("class")) {
                return this.findElement(By.className(str[1]));
            } else if (str[0].equals("linkText")) {
                return this.findElement(By.linkText(str[1]));
            } else if (str[0].equals("partialLinkText")) {
                return this.findElement(By.partialLinkText(str[1]));
            } else if (str[0].equals("tagName")) {
                return this.findElement(By.tagName(str[1]));
            } else if (str[0].equals("css")) {
                return this.findElement(By.cssSelector(str[1]));
            } else {
                return null;
            }
        } else {
            return this.findElement(By.xpath(using));
        }
    }

}


