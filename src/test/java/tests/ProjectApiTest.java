package tests;

import api.ProjectApiClient;
import dto.Project;
import org.testng.annotations.Test;
import tests.base.BaseApiTest;

import static org.testng.Assert.assertEquals;

public class ProjectApiTest extends BaseApiTest {

    @Test
    public void status200() {
        Project project = Project
                .builder()
                .name("TESTAPI")
                .code("TESTAPI5")
                .description("Timo")
                .access("all")
                .group("1")
                .build();

        projectApiClient.createNewProject(project);
        Project actual = projectApiClient.getProjectByCode(project.getCode());
        assertEquals(actual.getName(), project.getName());
        assertEquals(actual.getCode(), project.getCode());
        assertEquals(actual.getCounts().getCases(), 0);
    }

    @Test
    public void status201() {
        System.out.println(new ProjectApiClient().getProjectByCode("TESTAPI"));
    }
}
