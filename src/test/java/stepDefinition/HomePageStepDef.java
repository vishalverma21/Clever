package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.HomePage;

public class HomePageStepDef {

    HomePage homePage = new HomePage(AttachHooks.getDriver());

    private static Logger LOGGER = LoggerFactory.getLogger(HomePageStepDef.class);

    @Then("^Verify Home Page$")
    public void verify_home_page() throws Throwable {
        if (homePage.VerifyHomePageExistingUser()) {
            LOGGER.info("Home page is verified successfully ");
        } else {
            Assert.fail();
        }
    }

    @And("^Click on working time$")
    public void click_on_working_time() throws Throwable {
        if (homePage.ClickWorkingTime()) {
            LOGGER.info("Working time is clicked successfully on Home page");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify that user is redirected to working time area$")
    public void verify_working_time_area() throws Throwable {
        if (homePage.VerifyWorkingTimeArea()) {
            LOGGER.info("Working time area is verified successfully ");
        } else {
            Assert.fail();
        }
    }

    @Then("^Click on Record working time$")
    public void click_on_record_working_time() throws Throwable {
        if (homePage.ClickRecordTime()) {
            LOGGER.info("Record time button is clicked successfully ");
        } else {
            Assert.fail();
        }
    }

    @And("^Validate that timer is started$")
    public void validate_timer() throws Throwable {
        if (homePage.ValidateTimer()) {
            LOGGER.info("Timer is verified successfully ");
        } else {
            Assert.fail();
        }
    }

    @And("^Click on stop working time$")
    public void click_on_stop_working_time() throws Throwable {
        if (homePage.StopRecordingTime()) {
            LOGGER.info("Stop working time button is clicked successfully ");
        } else {
            Assert.fail();
        }
    }

    @And("^Validate that the timer is stopped$")
    public void validate_that_the_timer_is_stopped() throws Throwable {
        if (homePage.VerifyStoppedTimer()) {
            LOGGER.info("Timer is stopped successfully ");
        } else {
            Assert.fail();
        }
    }
}
