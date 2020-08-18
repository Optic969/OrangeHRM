package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class JobTitlePage {

    private ElementsCollection getJobTitleList = $$x("//table[@id='resultTable']//tbody//tr");
    private ElementsCollection getJobTitleCheckBox = $$x("//td[contains(.,'Test')]/..//input");
    private ElementsCollection getJobTitleName = $$x("//a[contains(text(),'Test')]");
    private SelenideElement successMessage = $x("d//div[@class='fadable']");


    public void chooseAddedThreeJobTitle(){
        for (SelenideElement jobTitle:getJobTitleCheckBox){
            jobTitle.click();
        }
    }

    public void checkSuccessTitleMessage() {

         successMessage.isDisplayed();
    }

}
