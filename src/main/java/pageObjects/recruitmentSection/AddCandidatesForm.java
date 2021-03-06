package pageObjects.recruitmentSection;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AddCandidatesForm {

    private SelenideElement getFirstNameField = $x("//input[@id='addCandidate_firstName']");
    private SelenideElement getLastNameField = $x("//input[@id='addCandidate_lastName']");
    private SelenideElement getEmailField = $x("//input[@id='addCandidate_email']");

    @Step("Add New candidate")
    public void addCandidate(){

        getFirstNameField.sendKeys("Petr");
        getLastNameField.sendKeys("Petrov");
        getEmailField.sendKeys("test@gmail.com");
    }
}
