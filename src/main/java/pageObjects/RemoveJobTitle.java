package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class RemoveJobTitle {

    private ElementsCollection getJobTitleCheckBox = $$x("//table[@id='resultTable']//tbody//tr//td//input");
    private SelenideElement getDeleteButton = $x("//input[@id='btnDelete']");

    public void chooseAddedThreeJobTitle(){

        getJobTitleCheckBox.get(1).click();
        getJobTitleCheckBox.get(2).click();
        getJobTitleCheckBox.get(3).click();
    }

}
