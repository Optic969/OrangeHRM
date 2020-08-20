package pageObjects.dashboardSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private SelenideElement getDashboardTitle = $x("//h1[contains(text(),'Dashboard')]");
    private SelenideElement getDashboardAssignLeaveLink = $x("//span[contains(text(),'Assign Leave')]");
    private SelenideElement getDashboardLeaveListLink =$x("//span[contains(text(),'Leave List')]");
    private SelenideElement getDashboardTimesheets = $x("//span[contains(text(),'Timesheets')]");
    private SelenideElement getDashboardEmployeeDistributionDiagram = $x("//div[@id='dashboard__employeeDistribution']");
    private SelenideElement getDashboardLegend = $x("//div[@id='panel_draggable_1_1']");
    private SelenideElement getDashboardPendingLeaveRequest = $x("//div[@id='task-list-group-panel-menu_holder']");

    @Step("Check Dashboard element present")
    public void checkDashboardElementPresent(){
        getDashboardTitle.shouldBe(Condition.visible);
        getDashboardAssignLeaveLink.shouldBe(Condition.visible);
        getDashboardLeaveListLink.shouldBe(Condition.visible);
        getDashboardTimesheets.shouldBe(Condition.visible);
        getDashboardEmployeeDistributionDiagram.shouldBe(Condition.visible);
        getDashboardLegend.shouldBe(Condition.visible);
        getDashboardPendingLeaveRequest.shouldBe(Condition.visible);
    }
}
