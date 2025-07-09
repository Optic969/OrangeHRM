package pageObjects.adminSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AddUserForm {

    private SelenideElement getUserRoleList = $x("//label[normalize-space()='User Role']/following::div[contains(@class,'oxd-select-text')][1]");
    private SelenideElement getUserRole = $x("//div[@role='option' and normalize-space()='Admin']");
    private SelenideElement getUserStatusList = $x("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
    private SelenideElement getUserStatus = $x("//div[@role='option' and normalize-space()='Enabled']");

    private SelenideElement getNewEmployeeName = $x("//input[@placeholder='Type for hints...']");
    private SelenideElement getNewUserName = $x("//label[contains(text(),'Username')]/following::input[1]");
    private SelenideElement getNewPassword = $x("//label[contains(text(),'Password')]/following::input[@type='password'][1]");
    private SelenideElement getConfirmPassword = $x("//label[contains(text(),'Confirm Password')]/following::input[@type='password'][1]");
    private SelenideElement getEmployeeNameHints = $x("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/span[1]");
    private SelenideElement getNewUserNameHints = $x("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/span[1]");
    private SelenideElement getAddUserHeading = $x("//div[@role='option']//span[contains(normalize-space(), 'Ivan6 Ivanov6')]");
    private final SelenideElement successMessage = $x("//div[contains(@class,'oxd-toast-content--success')]");

    @Step("Add new user")
    public void addNewUser() throws InterruptedException {

        getUserRoleList.click();
        getUserRole.shouldBe(visible).click();
        getUserStatusList.click();
        getUserStatus.shouldBe(visible).click();
        getNewEmployeeName.sendKeys(String.format("%s %s", Property.getProperty("employeeName"), Property.getProperty("employeeLastName")));
        getAddUserHeading.shouldBe(visible).click();
        getNewUserName.sendKeys(Property.getProperty("userName"));
        getNewPassword.setValue("A1234567a");
        getConfirmPassword.setValue("A1234567a");
        Selenide.sleep(3000);
    }

    @Step("Check success message")
    public void checkSuccessMessage() {

        successMessage.shouldHave(text("Successfully Saved"));
    }

    @Step("Check hints for empty Add user form")
    public void shouldHaveHintsForEmptyAddUserForm(String EmployeeNameHint, String UserNameHint) {

        getEmployeeNameHints.shouldHave(text(EmployeeNameHint));
        getNewUserNameHints.shouldHave(text(UserNameHint));
    }

    public void shouldHaveAddedUserAttribute(String EmployeeName, String UserName, String Password, String ConfirmPassword) {

        getNewEmployeeName.shouldHave(text(EmployeeName));
        getNewUserName.shouldHave(text(UserName));
        getNewPassword.shouldHave(text(Password));
        getConfirmPassword.shouldHave(text(ConfirmPassword));
    }
}
