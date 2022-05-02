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
        loginSteps.login(user, password);
        projectStep.createProject(project);
        Suite suite = Suite.builder()
                .name("Test")
                .parent("Project root")
                .build();
        suiteSteps.createSuite(suite);
    }
}
