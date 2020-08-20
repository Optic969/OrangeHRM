package pageObjects.PIMSection;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class EmployeeListPage {

    private final SelenideElement idNumber = $x("//a[contains(text(), 'Id')]");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");


    public void openEmployeeProfile() {

        idNumber.click();
        idNumber.click();
        $x(String.format("//a[contains(text(), %s)]", EmployeeAddPage.employeeId)).click();
    }
    public void getEmployForDelete(){
        idNumber.click();
        idNumber.click();
        $x(String.format("//a[contains(text(), %s)]/parent::td/preceding-sibling::td", EmployeeAddPage.employeeId)).click();
    }
    public boolean checkSuccessMessage() {
        return successMessage.isDisplayed();
    }
}
