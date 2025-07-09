package pageObjects.PIMSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EmployeeListPage {

    private final SelenideElement idNumber = $x("//a[contains(text(), 'Id')]");
    private final SelenideElement successMessage = $x("//div[contains(@class,'oxd-toast-content--success')]");
    private final SelenideElement successDeleteMessage = $x("//div[contains(@class,'oxd-toast-content--success')]");

    @Step("Open Employee profile")
    public void openEmployeeProfile() {

        //idNumber.click();
        //idNumber.click();
        $x(String.format("//div[contains(text(), '%s')]", EmployeeAddPage.employeeId)).click();
    }

    @Step("Get Employee for delete")
    public void getEmployForDelete() {
        executeJavaScript("arguments[0].click();", $x(String.format(
                "//div[contains(text(), '%s')]/preceding::input[@type='checkbox'][1]",
                EmployeeAddPage.employeeId
        )));
    }

    @Step("Check success message")
    public void checkSuccessMessage() {

        successMessage.shouldHave(text("Successfully Saved"));
    }

    @Step("Check success delete message")
    public void checkSuccessDeleteMessage() {

        successMessage.shouldHave(text("Successfully Deleted"));
    }
}
