package pageObjects.leaveSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LeaveSectionNavigation {

    private SelenideElement getLeaveSection = $x("//span[normalize-space()='Leave']");
    private SelenideElement getAssignLeaveSection = $x("//a[normalize-space()='Assign Leave']");

    @Step("Get Assign Leave page")
    public void getAssignLeavePage(){

        getLeaveSection.hover().click();
        getAssignLeaveSection.hover().click();
    }

}
