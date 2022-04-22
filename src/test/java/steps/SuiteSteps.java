package steps;

import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.ProjectPage;
import pages.SuiteModal;

@Log4j2
public class SuiteSteps {

    ProjectPage projectPage;
    SuiteModal suiteModal;

    public SuiteSteps() {
        projectPage = new ProjectPage();
        suiteModal = new SuiteModal();
    }

    @Step("Creation project: '{project}'")
    public void createSuite(Suite suite) {
        log.info("Creation suite: '{}'", suite);
        projectPage.clickSuite()
                .isPageOpened()
                .create(suite)
                .save()
                .isPageOpened();
    }
}
