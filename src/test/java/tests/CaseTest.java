package tests;

import dto.Case;
import dto.Project;
import dto.ProjectsFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CaseTest extends BaseTest {

    @Test(description = "Create case")
    public void createCase() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        Case aCase = Case.builder()
                .title("Test")
                .status("Draft")
                .suite("Test cases without suite")
                .severity("Minor")
                .priority("Low")
                .type("Smoke")
                .layer("API")
                .build();
        caseSteps.createCase(aCase);
    }
}
