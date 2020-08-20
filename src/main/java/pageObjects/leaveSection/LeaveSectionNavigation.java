package pageObjects.leaveSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LeaveSectionNavigation {

    private SelenideElement getLeaveSection = $x("//a[@id='menu_leave_viewLeaveModule']//b");
    private SelenideElement getAssignLeaveSection = $x("//a[@id='menu_leave_assignLeave']");

    @Step("Get Assign Leave page")
    public void getAssignLeavePage(){

        getLeaveSection.hover();
        getAssignLeaveSection.hover().click();
    }

}
