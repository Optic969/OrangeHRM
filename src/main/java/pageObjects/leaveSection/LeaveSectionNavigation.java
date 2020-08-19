package pageObjects.leaveSection;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LeaveSectionNavigation {

    private SelenideElement getLeaveSection = $x("//a[@id='menu_leave_viewLeaveModule']//b");
    private SelenideElement getAssignLeaveSection = $x("//a[@id='menu_leave_assignLeave']");

    public void getAssignLeavePage(){

        getLeaveSection.hover();
        getAssignLeaveSection.hover().click();
    }

}
