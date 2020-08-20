package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PIMNavigation {

    private SelenideElement getPIMSection = $x("//a[@id='menu_pim_viewPimModule']//b");
    private SelenideElement getEmployeeList = $x("//a[@id='menu_pim_viewEmployeeList']");
    private SelenideElement getEmployeeAdd = $x("//a[@id='menu_pim_addEmployee']");

    @Step("Get PIM employee list page")
    public void getPIMEmployeeListPage(){

        getPIMSection.hover();
        getEmployeeList.hover().click();
    }
    @Step("Get PIM Add employee page")
    public void getPIMAddEmployeePage(){

        getPIMSection.hover();
        getEmployeeAdd.hover().click();
    }
    @Step("Get PIM employee page")
    public void getPIMEmployeePage(){

        getPIMSection.click();
        getEmployeeList.click();
    }
}
