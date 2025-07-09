package pageObjects.dashboardSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private SelenideElement getDashboardTitle = $x("//h6[normalize-space()='Dashboard']");
    private SelenideElement getDashboardTimeAtWork = $x("//p[normalize-space()='Time at Work']");
    private SelenideElement getDashboardMyAction = $x("//p[normalize-space()='My Actions']");
    private SelenideElement getDashboardQuickLaunch = $x("//p[normalize-space()='Quick Launch']");
    private SelenideElement getDashboardBuzzLatestPosts = $x("//p[normalize-space()='Buzz Latest Posts']");
    private SelenideElement getDashboardEmployeesOnLeaveToday = $x("//p[normalize-space()='Employees on Leave Today']");
    private SelenideElement getDashboardEmployeeDistributionBySubUnit = $x("//p[normalize-space()='Employee Distribution by Sub Unit']");

    @Step("Check Dashboard element present")
    public void checkDashboardElementPresent() {

        getDashboardTitle.shouldBe(Condition.visible);
        getDashboardTimeAtWork.shouldBe(Condition.visible);
        getDashboardMyAction.shouldBe(Condition.visible);
        getDashboardQuickLaunch.shouldBe(Condition.visible);
        getDashboardBuzzLatestPosts.shouldBe(Condition.visible);
        getDashboardEmployeesOnLeaveToday.shouldBe(Condition.visible);
        getDashboardEmployeeDistributionBySubUnit.shouldBe(Condition.visible);
    }
}
