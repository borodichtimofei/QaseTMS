package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;
import pages.ProjectsList;

@Log4j2
public class LoginSteps {

    LoginPage loginPage;
    ProjectsList projectsList;

    public LoginSteps() {
        loginPage = new LoginPage();
        projectsList = new ProjectsList();
    }

    @Step("Log in by '{user}' using password '{password}'")
    public void login(String user, String password) {
        log.info("Log in by {} using password {}", user, password);
        loginPage.openPage()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
    }
}
