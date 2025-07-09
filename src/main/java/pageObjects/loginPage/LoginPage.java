package pageObjects.loginPage;

import com.codeborne.selenide.SelenideElement;
//import dev.failsafe.internal.util.Assert;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement getUserName = $x("//input[@placeholder='Username']");
    private SelenideElement getPassword = $x("//input[@placeholder='Password']");
    private SelenideElement getLogin = $x("//button[normalize-space()='Login']");
    private SelenideElement userLink = $x("//span[contains(@class,'oxd-userdropdown-tab')]");
    private SelenideElement logoutLink = $x("//a[text()='Logout']");
    private SelenideElement getDashboardSectionPage = $x("//span[normalize-space()='Dashboard']");

    @Step("Authorization to OrangeHRM")
    public void getAuthorization() {
        getUserName.sendKeys("Admin");
        getPassword.sendKeys("admin123");
        getLogin.click();
        //assertTrue(getDashboardSectionPage.isDisplayed(), "Заголовок Dashboard не отображается");
    }

    @Step("Log out from OrangeHRM")
    public void logoutFromApp() {
        userLink.scrollIntoView(true).shouldBe(visible).click();
        logoutLink.shouldBe(visible).click();
    }

    @Step("Check Log out from OrangeHRM")
    public void startPageApp() {
        getUserName.shouldBe(visible);
    }


}
