package tests;

import dto.Project;
import dto.ProjectsFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class NewProjectTest extends BaseTest {

    @Test(description = "Create new Account")
    public void createNewProject() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        Assert.assertEquals(projectPage.name(), project.getName());
        projectsList.openPage();
        assertTrue(projectsList.validate(project.getName()));
    }
}
