package pageObjects.dashboardSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardNavigation {

    private SelenideElement getDashboardSectionPage = $x("//a[@id='menu_dashboard_index']//b");

    @Step("Get Dashboard page")
    public void getDashboardPage(){

        getDashboardSectionPage.click();
    }

}
