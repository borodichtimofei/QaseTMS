package tests.base;

import api.ProjectApiClient;

public class BaseApiTest {

    protected ProjectApiClient projectApiClient;

    public BaseApiTest() {
        projectApiClient = new ProjectApiClient();
    }
}
