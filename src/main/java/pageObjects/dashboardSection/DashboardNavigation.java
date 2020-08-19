package pageObjects.dashboardSection;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardNavigation {

    private SelenideElement getDashboardSectionPage = $x("//a[@id='menu_dashboard_index']//b");

    public void getDashboardPage(){

    getDashboardSectionPage.click();
    }

}
