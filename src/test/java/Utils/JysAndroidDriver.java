package Utils;

import com.paypal.selion.platform.mobile.android.UiButton;
import com.paypal.selion.platform.mobile.android.UiObject;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class JysAndroidDriver extends AndroidDriver {
    public JysAndroidDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
    }
    public WebElement findElement(String using) {
        //判断是否有=号，没有则用xpath定位，有则根据=号前的字符判断使用不同的定位方式
        if (using.contains("=")) {
            String[] str = using.split("=");
            if (str[0].equals("xpath")) {
                return this.findElementByXPath(str[1]);
            } else if (str[0].equals("id")) {
                return this.findElementById(str[1]);
            } else if (str[0].equals("name")) {
                return this.findElementByName(str[1]);
            } else if (str[0].equals("class")) {
                return this.findElementByClassName(str[1]);
            } else if (str[0].equals("linkText")) {
                return this.findElementByLinkText(str[1]);
            } else if (str[0].equals("partialLinkText")) {
                return this.findElementByPartialLinkText(str[1]);
            } else if (str[0].equals("tagName")) {
                return this.findElementByTagName(str[1]);
            } else if (str[0].equals("css")) {
                return this.findElementByCssSelector(str[1]);
            } else {
                return null;
            }
        } else {
            return this.findElementByXPath(using);
        }
    }
    public WebElement findElement(UiObject uiButton) {
        //判断是否有=号，没有则用xpath定位，有则根据=号前的字符判断使用不同的定位方式
        String using = uiButton.getLocator();
        if (using.contains("=")) {
            String[] str = using.split("=");
            if (str[0].equals("xpath")) {
                return this.findElementByXPath(str[1]);
            } else if (str[0].equals("id")) {
                return this.findElementById(str[1]);
            } else if (str[0].equals("name")) {
                return this.findElementByName(str[1]);
            } else if (str[0].equals("class")) {
                return this.findElementByClassName(str[1]);
            } else if (str[0].equals("linkText")) {
                return this.findElementByLinkText(str[1]);
            } else if (str[0].equals("partialLinkText")) {
                return this.findElementByPartialLinkText(str[1]);
            } else if (str[0].equals("tagName")) {
                return this.findElementByTagName(str[1]);
            } else if (str[0].equals("css")) {
                return this.findElementByCssSelector(str[1]);
            } else {
                return null;
            }
        } else {
            return this.findElementByXPath(using);
        }

    }


}
