package tests;

import dto.Project;
import dto.ProjectsFactory;
import dto.Suite;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class SuiteTest extends BaseTest {

    @Test(description = "Create suite")
    public void createSuite() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(USER, PASSWORD);
        projectStep.createProject(project);
        Suite suite = Suite.builder()
                .suiteName("Test")
                .parentSuite("Project root")
                .build();
        suiteSteps.createSuite(suite);
    }
}
