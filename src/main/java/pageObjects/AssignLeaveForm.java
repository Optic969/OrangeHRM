package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AssignLeaveForm {
    private SelenideElement getEmployeeNameField = $x("//input[@id='assignleave_txtEmployee_empName']");
    private ElementsCollection getEmployeeNameList = $$x("//div[6]/ul/li");
    private SelenideElement getLeaveTypeDropDownList = $x("//select[@id='assignleave_txtLeaveType']");
    private ElementsCollection getDataFromLeaveTypeDropDownList = $$x("//select[@id='assignleave_txtLeaveType']//option");
    private SelenideElement getFromDateField = $x("//input[@id='assignleave_txtFromDate']");
    private ElementsCollection getFromDateInCalendar = $$x("//td//a[contains(text(),'')]");
    private SelenideElement getToDateField = $x("//input[@id='assignleave_txtToDate']");
    private SelenideElement getEmployeeNameHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[1]/span");
    private SelenideElement getLeaveTypeHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[2]/span");
    private SelenideElement getFromDateHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/span");
    private SelenideElement getToDateHints = $x("//*[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/span");

    public void shouldHaveHintsForEmptyAssignLeaveForm(String EmployeeNameHint,String LeaveTypeHints,String FromDateHints,String ToDateHints){

        getEmployeeNameHints.shouldHave(Condition.text(EmployeeNameHint));
        getLeaveTypeHints.shouldHave(Condition.text(LeaveTypeHints));
        getFromDateHints.shouldHave(Condition.text(FromDateHints));
        getToDateHints.shouldHave(Condition.text(ToDateHints));

    }
    public void getAddAssignLeave(String EmployeeName, int CalendarDayFrom){

        getEmployeeNameField.sendKeys(EmployeeName);
        getLeaveTypeDropDownList.click();
        getDataFromLeaveTypeDropDownList.get(5).click();
        getFromDateField.click();
        getFromDateInCalendar.get(CalendarDayFrom).click();
    }


}
