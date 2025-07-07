package pageObjects.adminSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AddJobTitleForm {

    private SelenideElement getJobTitleName = $x("//label[contains(text(),'Job Title')]/following::input[1]");
    private SelenideElement getJobTitleDescription = $x("//textarea[@id='jobTitle_jobDescription']");
    private SelenideElement getGetJobTitleNote = $x("//textarea[@id='jobTitle_note']");
    private SelenideElement getAddButton = $x("//button[normalize-space()='Add']");
    private SelenideElement getSaveButton = $x("//button[normalize-space()='Save']");

    @Step("Add new Job title")
    public void addNewJobTitle(String text) {

        executeJavaScript("arguments[0].click();", getAddButton);
        getJobTitleName.sendKeys(text);
        getSaveButton.click();
    }

}
