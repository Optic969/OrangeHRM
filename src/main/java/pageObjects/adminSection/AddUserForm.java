package pageObjects.adminSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.Property;

import static com.codeborne.selenide.Selenide.*;

public class AddUserForm {

    private SelenideElement getNewEmployeeName = $x("//input[@id='systemUser_employeeName_empName']");
    private SelenideElement getNewUserName = $x("//input[@id='systemUser_userName']");
    private SelenideElement getNewPassword = $x("//input[@id='systemUser_password']");
    private SelenideElement getConfirmPassword = $x("//input[@id='systemUser_confirmPassword']");
    private SelenideElement getEmployeeNameHints = $x("//span[contains(text(),'Employee does not exist')]");
    private SelenideElement getNewUserNameHints = $x("//span[contains(text(),'Required')]");
    private SelenideElement getAddUserHeading = $x("//h1[@id='UserHeading']");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");

    public void addNewUser() throws InterruptedException {

        getNewEmployeeName.sendKeys(String.format("%s %s", Property.getProperty("employeeName"), Property.getProperty("employeeLastName")));
        getAddUserHeading.click();
        getNewUserName.sendKeys(Property.getProperty("userName"));
        Selenide.sleep(1000);
    }
    public boolean checkSuccessMessage() {

        return successMessage.isDisplayed();
    }
    public void shouldHaveHintsForEmptyAddUserForm(String EmployeeNameHint, String UserNameHint){

        getEmployeeNameHints.shouldHave(Condition.text(EmployeeNameHint));
        getNewUserNameHints.shouldHave(Condition.text(UserNameHint));
    }
    public void shouldHaveAddedUserAttribute(String EmployeeName, String UserName, String Password, String ConfirmPassword) {

        getNewEmployeeName.shouldHave(Condition.text(EmployeeName));
        getNewUserName.shouldHave(Condition.text(UserName));
        getNewPassword.shouldHave(Condition.text(Password));
        getConfirmPassword.shouldHave(Condition.text(ConfirmPassword));
    }
}
