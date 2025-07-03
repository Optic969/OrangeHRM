package pageObjects.adminSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class    AdminSectionNavigation {

    private SelenideElement getAdminSection = $x("//a[@id='menu_admin_viewAdminModule']//b");
    private SelenideElement getUserManagment = $x("//a[@id='menu_admin_UserManagement']");
    private SelenideElement getUserSection = $x("//*[@id=\"menu_admin_viewSystemUsers\"]");
    private SelenideElement getJobSection = $x("//a[@id='menu_admin_Job']");
    private SelenideElement getJobTitleSection = $x("//a[@id='menu_admin_viewJobTitleList']");

    @Step("Get User creation page")
    public void getUserCreationPage(){

        getAdminSection.shouldBe(Condition.visible, Duration.ofSeconds(30)).hover();
        getUserManagment.hover();
        getUserSection.hover().click();
    }
    @Step("Get User Page")
    public void getUserPage(){

        getAdminSection.click();
    }
    @Step("Get Job title creation page")
    public void getJobTitleCreationPage(){

        getAdminSection.hover();
        getJobSection.hover();
        getJobTitleSection.hover().click();
    }
}
