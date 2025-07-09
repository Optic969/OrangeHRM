package pageObjects.leaveSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AssignLeaveForm {
    private SelenideElement getEmployeeNameField = $x("//label[normalize-space()='Employee Name']/following::input[@placeholder='Type for hints...'][1]");
    private ElementsCollection getEmployeeNameList = $$x("//div[6]/ul/li");
    private SelenideElement getLeaveTypeDropDownList = $x("//label[normalize-space()='Leave Type']/following::div[@class='oxd-select-text-input'][1]");
    private SelenideElement getLeaveTypeDropDownListData = $x("//div[@role='listbox']");
    private SelenideElement getDataFromLeaveTypeDropDownList = $x("//div[@role='option']//span[text()='US - Vacation']");//div[@role='option' and normalize-space()='Admin']
    private SelenideElement getFromDateField = $x("//label[normalize-space()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]");
    private ElementsCollection getFromDateInCalendar = $$x("(//div[contains(@class,'oxd-calendar-wrapper')])[1]//div[contains(@class,'oxd-calendar-date')]");
    private SelenideElement getToDateField = $x("//label[normalize-space()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]");
    private ElementsCollection getToDateInCalendar = $$x("(//div[contains(@class,'oxd-calendar-wrapper')])[2]//div[contains(@class,'oxd-calendar-date')]");
    private SelenideElement getEmployeeNameHints = $x("//label[contains(text(),'Employee Name')]/ancestor::div[contains(@class,'oxd-input-group')]");
    private SelenideElement getLeaveTypeHints = $x("//label[contains(text(),'Leave Type')]/ancestor::div[contains(@class,'oxd-input-group')]");
    private SelenideElement getFromDateHints = $x("//label[contains(text(),'From Date')]/ancestor::div[contains(@class,'oxd-input-group')]");
    private SelenideElement getToDateHints = $x("//label[contains(text(),'To Date')]/ancestor::div[contains(@class,'oxd-input-group')]");
    private SelenideElement successMessage = $x("//div[@class ='message success fadable']");
    private SelenideElement getEmployeeNameHeading = $x("//div[@role='option']//span[text()='Ivan6  Ivanov6']");

    @Step("Check hints for empty Assign leave form")
    public void shouldHaveHintsForEmptyAssignLeaveForm(
            String EmployeeNameHint,
            String LeaveTypeHints,
            String FromDateHints,
            String ToDateHints) {

        getEmployeeNameHints.shouldHave(Condition.text(EmployeeNameHint));
        getLeaveTypeHints.shouldHave(Condition.text(LeaveTypeHints));
        getFromDateHints.shouldHave(Condition.text(FromDateHints));
        getToDateHints.shouldHave(Condition.text(ToDateHints));

    }
    @Step("Add Assign leave")
    public void getAddAssignLeave(int CalendarDayFrom, int CalendarDayTo) {

        getEmployeeNameField.sendKeys(String.format("%s %s",
                Property.getProperty("employeeName"),
                Property.getProperty("employeeLastName")));
        getEmployeeNameHeading.shouldBe(visible).click();

        getLeaveTypeDropDownList.click();
        getLeaveTypeDropDownListData.shouldBe(visible);

        getDataFromLeaveTypeDropDownList.scrollIntoView(true).click();

        getFromDateField.click();
        getFromDateInCalendar.get(CalendarDayFrom).scrollIntoView(true).click();

        getToDateField.click();
        getToDateInCalendar.get(CalendarDayTo).scrollIntoView(true).click();

        Selenide.sleep(1000);

    }
    @Step("Check success message")
    public boolean checkSuccessMessage() {

        return successMessage.isDisplayed();
    }


}
