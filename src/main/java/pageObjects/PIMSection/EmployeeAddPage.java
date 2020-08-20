package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeeAddPage {

    private SelenideElement getFirstNameField = $x("//input[@id='firstName']");
    private SelenideElement getLastNameField = $x("//input[@id='lastName']");
    private SelenideElement getEmployeeIdField = $x("//input[@id='employeeId']");
    public static String employeeId;

    @Step("Create new Employee")
    public void createNewEmployee(){
        getFirstNameField.sendKeys(Property.getProperty("employeeName"));
        getLastNameField.sendKeys(Property.getProperty("employeeLastName"));
        employeeId = getEmployeeIdField.getValue();
    }

}
