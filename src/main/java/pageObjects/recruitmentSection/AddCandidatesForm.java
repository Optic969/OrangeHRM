package pageObjects.recruitmentSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AddCandidatesForm {

    private SelenideElement getFirstNameField = $x("//input[@placeholder='First Name']");
    private SelenideElement getLastNameField = $x("//input[@placeholder='Last Name']");
    private SelenideElement getEmailField = $x("//label[contains(text(),'Email')]/following::input[1]");

    @Step("Add New candidate")
    public void addCandidate() {

        getFirstNameField.sendKeys("Petr");
        getLastNameField.sendKeys("Petrov");
        getEmailField.sendKeys("test@gmail.com");
    }
}
