package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PIMNavigation {

    private SelenideElement getPIMSection = $x("//span[normalize-space()='PIM']");
    private SelenideElement getEmployeeList = $x("//a[normalize-space()='Employee List']");
    private SelenideElement getEmployeeAdd = $x("//button[normalize-space()='Add']");

    @Step("Get PIM employee list page")
    public void getPIMEmployeeListPage() {
        getPIMSection.hover().click();
        getEmployeeList.hover().click();
    }

    @Step("Get PIM Add employee page")
    public void getPIMAddEmployeePage() {
        getPIMSection.hover().click();
        getEmployeeAdd.hover().click();
    }

    @Step("Get PIM employee page")
    public void getPIMEmployeePage() {
        getPIMSection.click();
        getEmployeeList.click();
    }
}
