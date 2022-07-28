package stepDefinition;

import common.AttachHooks;
import common.ConfigManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.LoginPage;

public class LoginPageStepDef {
    LoginPage loginPage = new LoginPage(AttachHooks.getDriver());

    private static Logger LOGGER = LoggerFactory.getLogger(LoginPageStepDef.class);

    @Given("^Go to CleverShuttle$")
    public void Go_to_CleverShuttle() throws Throwable {
        if (loginPage.NavigateToTheURL(ConfigManager.getProperty("PageURL"))) {
            LOGGER.info("URL entered Successfully");
        } else {
            Assert.fail();
        }
    }

    @And("^Enter UserName and Password$")
    public void enter_login_credentials() throws Throwable {
        if (loginPage.EnterLoginCredentials()) {
            LOGGER.info("Login credentials entered Successfully");
        } else {
            Assert.fail();
        }
    }

    @And("^Click on Login button$")
    public void click_login() throws Throwable {
        if (loginPage.ClickLoginBtn()) {
            LOGGER.info("Login Button clicked Successfully");
        } else {
            Assert.fail();
        }
    }
}
