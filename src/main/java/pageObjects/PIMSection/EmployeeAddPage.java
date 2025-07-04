package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeeAddPage {

    private SelenideElement getFirstNameField = $x("//input[@placeholder='First Name']");
    private SelenideElement getLastNameField = $x("//input[@placeholder='Last Name']");
    private SelenideElement getEmployeeIdField = $x("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    public static String employeeId;

    @Step("Create new Employee")
    public void createNewEmployee(){

        getFirstNameField.sendKeys(Property.getProperty("employeeName"));
        getLastNameField.sendKeys(Property.getProperty("employeeLastName"));
        employeeId = getEmployeeIdField.getValue();
    }

}
