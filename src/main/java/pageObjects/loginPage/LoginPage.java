package pageObjects.loginPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement getUserName = $x("//input[@placeholder='Username']");
    private SelenideElement getPassword = $x("//input[@placeholder='Password']");
    private SelenideElement getLogin = $x("//button[normalize-space()='Login']");
    private SelenideElement userLink = $x("//a[@id='welcome']");
    private SelenideElement logoutLink = $x("//a[contains(text(), 'Logout')]");

    @Step("Authorization to OrangeHRM")
    public void getAuthorization(){

        getUserName.sendKeys("Admin");
        getPassword.sendKeys("admin123");
        getLogin.click();
}
    @Step("Log out from OrangeHRM")
    public void logoutFromApp() {

        userLink.click();
        logoutLink.click();
    }


}
