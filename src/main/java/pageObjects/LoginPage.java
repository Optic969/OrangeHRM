package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

private SelenideElement getUserName = $x("//input[@id='txtUsername']");
private SelenideElement getPassword = $x("//input[@id='txtPassword']");
private SelenideElement getLogin = $x("//input[@id='btnLogin']");

public void getAuthorization(){

    getUserName.sendKeys("Admin");
    getPassword.sendKeys("admin123");
    getLogin.click();
}


}
