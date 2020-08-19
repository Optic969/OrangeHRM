package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class PIMNavigation {

    private SelenideElement getPIMSection = $x("//a[@id='menu_pim_viewPimModule']//b");
    private SelenideElement getEmployeeList = $x("//a[@id='menu_pim_viewEmployeeList']");
    private SelenideElement getEmployeeAdd = $x("//a[@id='menu_pim_addEmployee']");

    public void getPIMEmployeeListPage(){
        getPIMSection.hover();
        getEmployeeList.hover().click();
    }
    public void getPIMAddEmployeePage(){
        getPIMSection.hover();
        getEmployeeAdd.hover().click();
    }
}
