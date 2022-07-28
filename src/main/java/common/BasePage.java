package common;

import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasePage {

    protected static WebDriver driver;
    static WebDriverWait wait;
    private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver driver) {
        BasePage.driver = AttachHooks.getDriver();
    }

    public WebElement waitForWebElementPresent(WebElement element, int timeoutSeconds) {
        wait = new WebDriverWait(AttachHooks.getDriver(), timeoutSeconds);
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element));
        if (elem != null) {
            return elem;
        } else {
            return null;
        }
    }

    public WebElement WaitForElementVisibility(By locator, int timeoutSeconds) {
        wait = new WebDriverWait(AttachHooks.getDriver(), timeoutSeconds);
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (elem != null) {
            return elem;
        } else {
            return null;
        }
    }


    //Common Method created to check if element is present - Vishal
    public boolean isElementPresent(By locator, int timeoutInSeconds) {
        try {
            wait = new WebDriverWait(AttachHooks.getDriver(), timeoutInSeconds);
            WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (elem != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    //Common Method created to find an element
    public WebElement findElement(By locator, int timeoutSeconds) {
        wait = new WebDriverWait(AttachHooks.getDriver(), timeoutSeconds);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if (elem != null) {
            return elem;
        } else {
            return null;
        }
    }

    public boolean WaitTime(long time) {
        long startTime = System.currentTimeMillis();
        long waitTime = Long.parseLong(ConfigManager.getProperty("WaitTime")) * 60000;
        long endTime = time + waitTime;
        if (startTime < endTime) {
            return true;
        } else {
            return false;
        }
    }

    public Integer LessWaitElementFor() {
        int timeInSecond = Integer.parseInt(ConfigManager.getProperty("LessWaitForElementTime"));
        return timeInSecond;
    }

    public Integer WaitElementFor() {
        int timeInSecond = Integer.parseInt(ConfigManager.getProperty("WaitForElementTime"));
        return timeInSecond;
    }

    public Integer LongWaitElementFor() {
        int timeInSecond = Integer.parseInt(ConfigManager.getProperty("LongWaitForElementTime"));
        return timeInSecond;
    }
}