package pageObjects.PIMSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeePersonalDetailsForm {

    private final SelenideElement firstNameField = $x("//input[@id='personal_txtEmpFirstName']");
    private final SelenideElement middleNameField = $x("//input[@id='personal_txtEmpMiddleName']");
    private final SelenideElement lastNameField = $x("//input[@id='personal_txtEmpLastName']");
    private final SelenideElement employeeIdField = $x("//input[@id='personal_txtEmployeeId']");
    private final SelenideElement otherIdField = $x("//input[@id='personal_txtOtherID']");
    private final SelenideElement driversLicenseField = $x("//input[@id='personal_txtLicenNo']");
    private final SelenideElement driversLicenseExpireDateField = $x("//input[@id='personal_txtLicExpDate']");
    private final SelenideElement martialStatusDropdown = $x("//select[@id='personal_cmbMarital']");
    private final SelenideElement nationalityDropDown = $x("//select[@id='personal_cmbNation']");
    private final SelenideElement dateOfBirth = $x("//input[@id='personal_DOB']");
    private final SelenideElement editButton = $x("//input[@id='btnSave']");
    private final SelenideElement addAttachmentButton = $x("//input[@id='btnAddAttachment']");

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
        editButton.shouldBe(Condition.visible);
        addAttachmentButton.shouldBe(Condition.visible);
    }
    @Step("Check contains for Personal info")
    public void shouldContainsPersonalInfo() {

        Assertions.assertEquals(firstNameField.getValue(), Property.getProperty("employeeName"));
        Assertions.assertEquals(lastNameField.getValue(), Property.getProperty("employeeLastName"));
        Assertions.assertEquals(employeeIdField.getValue(), EmployeeAddPage.employeeId);
    }
}


