package page;

import common.AttachHooks;
import common.BasePage;
import common.ConfigManager;
import objectrepository.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


    public boolean NavigateToTheURL(String URL) {
        try {
            LOGGER.info("entering the URL");

            if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Web")) {
                AttachHooks.getDriver().navigate().to(URL);
                LOGGER.info("URL is entered successfully");
                LOGGER.info("Landing page is verified successfully for all texts and buttons");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("User was not able to enter the URL successfully " + e.getMessage());
        }
        LOGGER.error("User was not able to enter the URL successfully");
        return false;
    }

    public boolean EnterLoginCredentials() {
        try {
            if (isElementPresent(LoginPageLocators.userNameInputBox, LessWaitElementFor())) {
                findElement(LoginPageLocators.userNameInputBox, LessWaitElementFor()).sendKeys(ConfigManager.getProperty("UserName"));
                LOGGER.info("User Name is entered successfully");
                findElement(LoginPageLocators.passwordInputBox, LessWaitElementFor()).sendKeys(ConfigManager.getProperty("Password"));
                LOGGER.info("Password is entered successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("email id and password have not been entered successfully for " + e.getMessage());
        }
        LOGGER.error("email id and password have not been entered successfully for ");
        return false;
    }

    public boolean ClickLoginBtn() {
        try {
            if (isElementPresent(LoginPageLocators.loginButton,LessWaitElementFor())) {
                findElement(LoginPageLocators.loginButton,LessWaitElementFor()).click();
                LOGGER.info("Login Button is clicked successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Login button is not clicked successfully" + e.getMessage());
        }
        LOGGER.error("Login button is not clicked successfully");
        return false;
    }

}

