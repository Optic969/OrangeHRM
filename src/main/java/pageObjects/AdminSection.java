package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AdminSection {

    private SelenideElement getAdminSection = $x("//b[contains(text(),'Admin')]");
    private SelenideElement getUserManagment = $x("//a[@id='menu_admin_UserManagement']");
    private SelenideElement getUserSection = $x("//*[@id=\"menu_admin_viewSystemUsers\"]");
    private SelenideElement getJobSection = $x("//a[@id='menu_admin_Job']");
    private SelenideElement getJobTitleSection = $x("//a[@id='menu_admin_viewJobTitleList']");
    private SelenideElement getSaveButton = $x("//input[@id='btnSave']");


    public void getUserCreationPage(){

        getAdminSection.hover();
        getUserManagment.hover();
        getUserSection.hover().click();
    }
    public void getJobTitleCreationPage(){

        getAdminSection.hover();
        getJobSection.hover();
        getJobTitleSection.hover().click();
    }
}
