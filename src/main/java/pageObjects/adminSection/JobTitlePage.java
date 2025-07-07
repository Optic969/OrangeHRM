package pageObjects.adminSection;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.Matchers.containsString;


public class JobTitlePage {

    private ElementsCollection getJobTitleList = $$x("//table[@id='resultTable']//tbody//tr");
    //private ElementsCollection getJobTitleCheckBox = $$x("//td[contains(.,'Test')]/preceding-sibling::td//span[contains(@class,'oxd-checkbox-input')]");
    //private ElementsCollection getJobTitleName = $$x("//a[contains(text(),'Test')]");
    //private ElementsCollection getJobTitleCheckBox = $$x("//td[contains(.,'Test')]/preceding-sibling::td//label");
    private final SelenideElement getJobTitleCheckBox = $x("//div[contains(.,'ATest')]/ancestor::div[contains(@class,'oxd-table-row')]//label");
    //private ElementsCollection getJobTitleCheckBox = $$x("//span[contains(text(),'ATest')]/ancestor::label//input[@type='checkbox']");
    //private SelenideElement successMessage = $x("d//div[@class='fadable']");
    private SelenideElement successMessage = $x("//div[contains(@class,'oxd-toast-container')]//p[text()='Successfully Deleted']");

    @Step("Choose added three Job title")
    /*public void chooseAddedThreeJobTitle(){

        for (SelenideElement jobTitle:getJobTitleCheckBox){
            jobTitle.click();
        }
    }*/
    /* public void chooseAddedThreeJobTitle() {
        for (SelenideElement jobTitle : getJobTitleCheckBox) {
            /*jobTitle.scrollIntoView(true).shouldBe(visible);
            executeJavaScript("arguments[0].click();", jobTitle);
            jobTitle.shouldHave(cssClass("oxd-checkbox-input--active"));*/
            /*executeJavaScript(
                    "arguments[0].style.display='block';" +
                            "arguments[0].style.opacity='1';" +
                            "arguments[0].style.visibility='visible';",
                    jobTitle
            );

            // Прокрутка и клик
            jobTitle.scrollIntoView(true).shouldBe(enabled);
            executeJavaScript("arguments[0].click();", jobTitle);
        }
    }*/

    public void chooseAddedThreeJobTitle() {
        getJobTitleCheckBox.scrollIntoView(true).shouldBe(visible);
        executeJavaScript("arguments[0].click();", getJobTitleCheckBox);
    }


    @Step("Check success Title message")
    public void checkSuccessTitleMessage() {
        sleep(500);
        successMessage.should(appear);
        successMessage.shouldHave(text("Successfully Deleted"));
    }
}


