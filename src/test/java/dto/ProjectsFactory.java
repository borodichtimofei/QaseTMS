package dto;

import com.github.javafaker.Faker;

public class ProjectsFactory {

    public static Project getProject() {
        Faker faker = new Faker();
        return new Project(faker.internet().url(), faker.name().firstName(), faker.internet().emailAddress());
    }
}
