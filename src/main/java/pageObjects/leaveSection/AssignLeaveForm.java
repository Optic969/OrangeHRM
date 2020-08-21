package pageObjects.leaveSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AssignLeaveForm {
    private SelenideElement getEmployeeNameField = $x("//input[@id='assignleave_txtEmployee_empName']");
    private ElementsCollection getEmployeeNameList = $$x("//div[6]/ul/li");
    private SelenideElement getLeaveTypeDropDownList = $x("//select[@id='assignleave_txtLeaveType']");
    private SelenideElement getDataFromLeaveTypeDropDownList = $x("//option[contains(text(),'Vacation US')]");
    private SelenideElement getFromDateField = $x("//input[@id='assignleave_txtFromDate']");
    private ElementsCollection getFromDateInCalendar = $$x("//td//a[contains(text(),'')]");
    private SelenideElement getToDateField = $x("//input[@id='assignleave_txtToDate']");
    private ElementsCollection getToDateInCalendar = $$x("//td//a[contains(text(),'')]");
    private SelenideElement getEmployeeNameHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[1]/span");
    private SelenideElement getLeaveTypeHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[2]/span");
    private SelenideElement getFromDateHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/span");
    private SelenideElement getToDateHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span");
    private SelenideElement successMessage = $x("//div[@class ='message success fadable']");

    @Step("Check hints for empty Assign leave form")
    public void shouldHaveHintsForEmptyAssignLeaveForm(String EmployeeNameHint,String LeaveTypeHints,String FromDateHints,String ToDateHints){

        getEmployeeNameHints.shouldHave(Condition.text(EmployeeNameHint));
        getLeaveTypeHints.shouldHave(Condition.text(LeaveTypeHints));
        getFromDateHints.shouldHave(Condition.text(FromDateHints));
        getToDateHints.shouldHave(Condition.text(ToDateHints));

    }
    @Step("Add Assign leave")
    public void getAddAssignLeave(int CalendarDayFrom, int CalendarDayTo){

        getEmployeeNameField.sendKeys(String.format("%s %s", Property.getProperty("employeeName"), Property.getProperty("employeeLastName")));
        getLeaveTypeDropDownList.click();
        getDataFromLeaveTypeDropDownList.click();
        getFromDateField.click();
        getFromDateInCalendar.get(CalendarDayFrom).click();
        getToDateField.click();
        getToDateInCalendar.get(CalendarDayTo).click();
        Selenide.sleep(1000);

    }
    public boolean checkSuccessMessage() {

        return successMessage.isDisplayed();
    }


}
