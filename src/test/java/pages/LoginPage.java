package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    public static final By USER_EMAIL = By.id("inputEmail");
    public static final By PASSWORD = By.id("inputPassword");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    @Override
    public LoginPage isPageOpened() {
        log.info("Waiting for Login page to be opened");
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening login page")
    public LoginPage openPage() {
        log.info("Opening login page");
        open("login");
        return this;
    }

    @Step("Log in by '{user}' using password '{password}'")
    public ProjectsList login(String user, String password) {
        log.info("Log in by {} using password {}", user, password);
        $(USER_EMAIL).sendKeys(user);
        $(PASSWORD).sendKeys(password);
        $(LOGIN_BUTTON).click();
        waitForPageLoaded();
        return new ProjectsList();
    }
}
