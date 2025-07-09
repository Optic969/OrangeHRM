package pageObjects.PIMSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import utils.Property;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$x;

public class EmployeePersonalDetailsForm {

    private final SelenideElement firstNameField = $x("//input[@placeholder='First Name']");
    private final SelenideElement middleNameField = $x("//input[@placeholder='Middle Name']");
    private final SelenideElement lastNameField = $x("//input[@placeholder='Last Name']");
    private final SelenideElement employeeIdField = $x("//label[text()='Employee Id']/following::input[1]");
    private final SelenideElement otherIdField = $x("//label[text()='Other Id']/following::input[1]");
    private final SelenideElement driversLicenseField = $x(
            "//label[text()=\"Driver's License Number\"]/following::input[1]"
    );
    private final SelenideElement driversLicenseExpireDateField = $x(
            "//label[text()='License Expiry Date']/following::input[1]"
    );
    private final SelenideElement martialStatusDropdown = $x(
            "//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text')][1]"
    );
    private final SelenideElement nationalityDropDown = $x(
            "//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]"
    );
    private final SelenideElement dateOfBirth = $x("//label[text()='Date of Birth']/following::input[1]");
    private final SelenideElement saveButton = $x("//button[normalize-space()='Save']");
    private final SelenideElement addAttachmentButton = $x("//button[normalize-space()='Add']");

    @Step("Check Employee personal details form elements present ")
    public void checkEmployeePersonalDetailsFormElements() {

        firstNameField.shouldBe(Condition.visible);
        middleNameField.shouldBe(Condition.visible);
        lastNameField.shouldBe(Condition.visible);
        employeeIdField.shouldBe(Condition.visible);
        otherIdField.shouldBe(Condition.visible);
        driversLicenseField.shouldBe(Condition.visible);
        driversLicenseExpireDateField.shouldBe(Condition.visible);
        martialStatusDropdown.shouldBe(Condition.visible);
        nationalityDropDown.shouldBe(Condition.visible);
        dateOfBirth.shouldBe(Condition.visible);
        saveButton.shouldBe(Condition.visible);
        addAttachmentButton.shouldBe(Condition.visible);
    }

    @Step("Check contains for Personal info")
    public void shouldContainsPersonalInfo() {
        firstNameField.shouldHave(value(Property.getProperty("employeeName")));
        Assertions.assertEquals(firstNameField.getValue(), Property.getProperty("employeeName"));
        Assertions.assertEquals(lastNameField.getValue(), Property.getProperty("employeeLastName"));
        Assertions.assertEquals(employeeIdField.getValue(), EmployeeAddPage.employeeId);
    }
}


