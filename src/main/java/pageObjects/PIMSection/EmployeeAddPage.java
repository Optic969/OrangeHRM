package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import utils.Property;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EmployeeAddPage {

    private SelenideElement getFirstNameField = $x("//input[@placeholder='First Name']");
    private SelenideElement getLastNameField = $x("//input[@placeholder='Last Name']");
    private SelenideElement getEmployeeIdField = $x(
            "//label[text()='Employee Id']/following::input[1]"
    );

    /*private SelenideElement getEmployeeIdField = $x(
            "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"
    );*/
    private final SelenideElement employeeIdField =
            $x("//label[text()='Employee Id']/following::input[1]");

    public static String employeeId;

    @Step("Create new Employee")
    public void createNewEmployee() {

        getFirstNameField.sendKeys(Property.getProperty("employeeName"));
        getLastNameField.sendKeys(Property.getProperty("employeeLastName"));

        String randomId = RandomStringUtils.randomNumeric(5); // например: "39482"
        employeeIdField
                .scrollIntoView(true)
                .shouldBe(visible)
                .sendKeys(randomId);

        employeeId = getEmployeeIdField.getValue();
    }

}
