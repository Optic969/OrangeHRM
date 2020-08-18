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
    private SelenideElement getToDateField = $x("//input[@id='assignleave_txtToDate']");

    public void getAddAssignLeave(){
        getEmployeeNameField.sendKeys("1");
        getEmployeeNameList.get(1);//.shouldHave(Condition.text("Test1"));
        getLeaveTypeDropDownList.click();
        getDataFromLeaveTypeDropDownList.get(5);
        getFromDateField.click();



    }


}
