package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AdminSection {

    private SelenideElement getAdminSection = $x("//b[contains(text(),'Admin')]");
    private SelenideElement getUserManagment = $x("//a[@id='menu_admin_UserManagement']");
    private SelenideElement getUserSection = $x("//*[@id=\"menu_admin_viewSystemUsers\"]");
    private SelenideElement getAddNewUserSection = $x("//input[@id='btnAdd']");


    public void getUserCreationPage(){
        getAdminSection.hover();
        getUserManagment.hover();
        getUserSection.hover().click();
        getAddNewUserSection.click();

    }

}
