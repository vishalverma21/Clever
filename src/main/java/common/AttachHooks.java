package common;

import Bean.DataBean;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AttachHooks {

    private Scenario scenario;
    private static WebDriver driver;

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload() {
        dr.remove();
    }

    DesiredCapabilities capabilities;
    private static Logger LOGGER = LoggerFactory.getLogger(AttachHooks.class);
    public static final String webId = "id";
    public static final String appId = "resource-id";

    //for extent external report only

    ExtentReports extent = new ExtentReports();

    ExtentTest test;

    ExtentHtmlReporter htmlReporter;


    @Before
    public void setUp(Scenario scenario) throws IOException, Exception {
        LOGGER.info("Inside set up method of before hook");
        LOGGER.info(System.getProperty("user.dir"));
        LOGGER.info("setup:::::::");
        ConfigManager.loadConfig();
        this.scenario = scenario;

        System.out.println(scenario.getName());
        String path;

        if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Web") &&
                ConfigManager.getProperty("BrowserName").equalsIgnoreCase("chrome")) {
            LOGGER.info("Our browser will be invoked here");
            System.setProperty("webdriver.chrome.driver", "webdriver/bin/chromedriver");

            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless", "--ignore-certificate-errors");
            chromeOptions.addArguments("--start-fullscreen");
            chromeOptions.setCapability("browserName", "chrome");
            chromeOptions.setCapability("name", scenario.getName());

            driver = new ChromeDriver(chromeOptions);
            setDriver(driver);
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        }
    }

    /**
     * This method Is responsible for stopping test case and embedding
     * screenshot on failure
     *
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    @After
    public void tearDown() throws InstantiationException, IllegalAccessException, IOException, InterruptedException, Exception {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        } else if (!scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
        getDriver().quit();
        unload();
    }
}