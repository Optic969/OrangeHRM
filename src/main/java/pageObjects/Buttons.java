package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Buttons {

    private SelenideElement getAddButton = $x("//input[@id='btnAdd']");
    private SelenideElement getSaveButton = $x("//input[@id='btnSave']");
    private SelenideElement getDeleteButton = $x("//input[@id='btnDelete']");

    public void clickAddButton(){
        getAddButton.click();
    }
    public void clickSaveButton(){

        getSaveButton.click();
    }

    public void clickDeleteButton(){

        getDeleteButton.click();
    }

}
