package dto;

import com.github.javafaker.Faker;

public class ProjectsFactory {

    public static Project getProject() {
        Faker faker = new Faker();
        return Project.builder()
                .name(faker.internet().url())
                .code(faker.name().firstName())
                .description(faker.internet().emailAddress())
                .build();
    }
}
