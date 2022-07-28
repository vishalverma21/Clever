package objectrepository;

import Bean.DataBean;
import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By userNameInputBox = By.id("username");

    public static final By passwordInputBox = By.id("password");

    public static final By loginButton = By.id("kc-login");

    public static final By departingInputBox = By.id("departing");

    public static final By returningInputBox = By.id("returning");

    public static final By promotionalCodeInputBox = By.id("promotional_code");

    public static final By searchButton = By.xpath("//input[@type='submit']");

}
