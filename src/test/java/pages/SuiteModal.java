package pages;

import com.codeborne.selenide.Condition;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import wrappers.DropDown;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SuiteModal extends BasePage {

    public static final By SUITE_NAME = By.id("name");
    public static final By SAVE_SUITE = By.xpath("//a[contains(text(),'Cancel')]");

    @Override
    public SuiteModal isPageOpened() {
        log.info("Waiting for Suite modal to be opened");
        $(SUITE_NAME).shouldBe(Condition.visible);
        return this;
    }

    @Step("Input suite information: {suite}")
    public SuiteModal create(Suite suite) {
        log.info("Input suite name: {}, select parent suite: {}", suite.getName(), suite.getParent());
        $(SUITE_NAME).sendKeys(suite.getName());
        new DropDown("Parent suite").select(suite.getParent());
        return this;
    }

    @Step("Click on button 'Create'")
    public ProjectPage save() {
        log.info("Click on button 'Create'");
        $(byText("Create")).click();
        return new ProjectPage();
    }
}
