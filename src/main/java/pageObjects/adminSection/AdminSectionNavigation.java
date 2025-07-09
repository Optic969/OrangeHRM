package pageObjects.adminSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AdminSectionNavigation {

    private SelenideElement getAdminSection = $x("//span[normalize-space()='Admin']");
    private SelenideElement getUserManagment = $x("//span[normalize-space()='User Management']");
    private SelenideElement getUserSection = $x("//a[normalize-space()='Users']");
    private SelenideElement getJobSection = $x("//span[normalize-space()='Job']");
    private SelenideElement getJobTitleSection = $x("//a[normalize-space()='Job Titles']");

    @Step("Get User creation page")
    public void getUserCreationPage() {

        //getAdminSection.shouldBe(Condition.visible, Duration.ofSeconds(30)).hover();
        getAdminSection.hover().click();
        getUserManagment.hover().click();
        getUserSection.hover().click();
    }

    @Step("Get User Page")
    public void getUserPage() {

        getAdminSection.click();
    }

    @Step("Get Job title creation page")
    public void getJobTitleCreationPage() {

        getAdminSection.click();
        getJobSection.click();
        getJobTitleSection.shouldBe(visible).click();
    }
}
