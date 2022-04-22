package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    @Step("Select: {option} into: {select}")
    public void select(String option) {
        log.info("Select {} into  {}", option, label);
        $(By.xpath(String.format("//label[text()='%s']/../div[contains(@class, 'css')]", label))).click();
        $(byText(option)).click();


    }
}
