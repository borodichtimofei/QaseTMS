package tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CaseSteps;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected ProjectsList projectsList;
    protected NewProjectPage newProjectPage;
    protected ProjectSteps projectStep;
    protected ProjectPage projectPage;
    protected NavigationPage navigationPage;
    protected SuiteModal suiteModal;
    protected CaseModal caseModal;
    protected SuiteSteps suiteSteps;
    protected CaseSteps caseSteps;

    public static final String USER = "borodich.timofei@gmail.com";
    public static final String PASSWORD = "kazantip";

    @BeforeMethod(description = "Opening browser")
    public void setup(ITestContext context) {
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.clickViaJs = true;
        Configuration.timeout = 1000;

        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        projectsList = new ProjectsList();
        newProjectPage = new NewProjectPage();
        projectStep = new ProjectSteps();
        projectPage = new ProjectPage();
        navigationPage = new NavigationPage();
        suiteModal = new SuiteModal();
        caseModal = new CaseModal();
        suiteSteps = new SuiteSteps();
        caseSteps = new CaseSteps();
//
//        context.setAttribute("driver", getWebDriver());
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        getWebDriver().quit();
    }
}
