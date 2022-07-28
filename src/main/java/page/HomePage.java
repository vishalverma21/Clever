package page;

import Bean.DataBean;
import common.AttachHooks;
import common.BasePage;
import objectrepository.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public boolean VerifyHomePageExistingUser() {
        try {
            if (isElementPresent(HomePageLocators.profileButton, LessWaitElementFor()) &&
                    isElementPresent(HomePageLocators.clock, LessWaitElementFor()) &&
                    isElementPresent(HomePageLocators.calender, LessWaitElementFor()) &&
                    isElementPresent(HomePageLocators.brandLogo, LessWaitElementFor())) {
                LOGGER.info("Home Page is verified successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Home page is not verified successfully " + e.getMessage());
        }
        LOGGER.error("Home page is not verified successfully");
        return false;
    }

    public boolean ClickWorkingTime() {
        try {
            WaitForElementVisibility(HomePageLocators.brandLogo, WaitElementFor());
            if (isElementPresent(HomePageLocators.brandLogo, LessWaitElementFor())) {
                findElement(HomePageLocators.brandLogo, WaitElementFor()).click();
                LOGGER.info("Brand Logo is clicked successfully on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Brand Logo is not clicked successfully on Home page " + e.getMessage());
        }
        LOGGER.error("Brand Logo is not clicked successfully on Home page");
        return false;
    }

    public boolean VerifyWorkingTimeArea() {
        try {
            if (isElementPresent(HomePageLocators.elapsedTime, LessWaitElementFor()) &&
                    isElementPresent(HomePageLocators.recordTimeButton, LessWaitElementFor())) {
                DataBean.setTimer1(findElement(HomePageLocators.elapsedTime, LessWaitElementFor()).getText());
                LOGGER.info("Working time area page is verified successfully on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Working time area page was not verified successfully on Home page " + e.getMessage());
        }
        LOGGER.error("Working time area page was not verified successfully on Home page");
        return false;
    }

    public boolean ClickRecordTime() {
        try {
            if (isElementPresent(HomePageLocators.recordTimeButton, LessWaitElementFor())) {
                findElement(HomePageLocators.recordTimeButton, LessWaitElementFor()).click();
                LOGGER.info("Record time button is clicked successfully on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Record time button is not clicked successfully on Home page " + e.getMessage());
        }
        LOGGER.error("Record time button is not clicked successfully on Home page");
        return false;
    }

    public boolean ValidateTimer() {
        try {
            Thread.sleep(2000);
            if (findElement(HomePageLocators.elapsedTime, LessWaitElementFor()).getText() != DataBean.getTimer1()) {
                LOGGER.info("Timer is started successfully on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Timer was not started successfully on Home page " + e.getMessage());
        }
        LOGGER.error("Timer was not started successfully on Home page");
        return false;
    }

    public boolean StopRecordingTime() {
        try {
            findElement(HomePageLocators.recordTimeButton, LessWaitElementFor()).click();
            LOGGER.info("End Recording button is clicked");
            if (findElement(HomePageLocators.stopWorkingTime, LessWaitElementFor()).isDisplayed()) {
                findElement(HomePageLocators.stopWorkingTime, LessWaitElementFor()).click();
                LOGGER.info("Stop Timer button is clicked successfully on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Stop Timer button is not clicked successfully on Home page " + e.getMessage());
        }
        LOGGER.error("Stop Timer button is not clicked successfully on Home page");
        return false;
    }

    public boolean VerifyStoppedTimer() {
        try {
            DataBean.setTimer2(findElement(HomePageLocators.elapsedTime, LessWaitElementFor()).getText());
            AttachHooks.getDriver().navigate().refresh();
            if (findElement(HomePageLocators.elapsedTime, LessWaitElementFor()).getText() != DataBean.getTimer2() &&
                    findElement(HomePageLocators.elapsedTime, LessWaitElementFor()).getText().equals(DataBean.getTimer1())) {
                LOGGER.info("Timer is stopped successfully and reset to default on Home page");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Timer was not stopped successfully and reset to default on Home page " + e.getMessage());
        }
        LOGGER.error("Timer was not stopped successfully and reset to default on Home page");
        return false;
    }

}
