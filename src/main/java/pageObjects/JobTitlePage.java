package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class JobTitlePage {

    private ElementsCollection getJobTitleCheckBox = $$x("//table[@id='resultTable']//tbody//tr");
    private ElementsCollection getJobTitleName = $$x("//a[contains(text(),'Test')]");


    public void chooseAddedThreeJobTitle(){
        for (SelenideElement jobTitle:getJobTitleCheckBox){
           if (jobTitle.getText().contains("Test"))
               jobTitle.click();

        }
        
    }

}
