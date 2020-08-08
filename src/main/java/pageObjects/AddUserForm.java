package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AddUserForm {

    private SelenideElement getNewEmployeeName = $x("//input[@id='systemUser_employeeName_empName']");
    private SelenideElement getNewUserName = $x("//input[@id='systemUser_userName']");
    private SelenideElement getNewPassword = $x("//input[@id='systemUser_password']");
    private SelenideElement getConfirmPassword = $x("//input[@id='systemUser_confirmPassword']");
    private SelenideElement getSaveButton = $x("//input[@id='btnSave']");

    public void addNewUser(){
        getNewEmployeeName.sendKeys("Ivan");
        getNewUserName.sendKeys("BlackDominator");
        getNewPassword.sendKeys("Qwerty1234");
        getConfirmPassword.sendKeys("Qwerty1234");
    }

    public void saveNewUser(){
        getSaveButton.click();
    }

    public void shouldHaveAddUserAttribute(String EmployeeName, String UserName, String Password, String ConfirmPassword) {
        getNewEmployeeName.shouldHave(Condition.text(EmployeeName));
        getNewUserName.shouldHave(Condition.text(UserName));
        getNewPassword.shouldHave(Condition.text(Password));
        getConfirmPassword.shouldHave(Condition.text(ConfirmPassword));
    }
}
