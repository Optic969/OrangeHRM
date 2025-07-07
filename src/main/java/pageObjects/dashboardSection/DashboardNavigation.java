package pageObjects.dashboardSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardNavigation {

    private SelenideElement getDashboardSectionPage = $x("//span[text()='Dashboard']");

    @Step("Get Dashboard page")
    public void getDashboardPage(){

        getDashboardSectionPage.click();
    }

}
