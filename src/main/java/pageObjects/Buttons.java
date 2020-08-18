package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Buttons {

    private SelenideElement getAddButton = $x("//input[@id='btnAdd']");
    private SelenideElement getSaveButton = $x("//input[@id='btnSave']");
    private SelenideElement getDeleteButton = $x("//input[@id='btnDelete']");
    private SelenideElement getAssignButton = $x("//input[@id='assignBtn']");
    private SelenideElement getCancelButton = $x("//input[@id='btnCancel']");
    private SelenideElement getPIM = $x("//b[contains(text(),'PIM')]");
    private SelenideElement getDialogDeleteButton = $x("//input[@id='dialogDeleteBtn']");

    public void clickAddButton() throws InterruptedException {
        Thread.sleep(1000);
        getAddButton.click();
    }
    public void clickSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        getSaveButton.click();
    }

    public void clickDeleteButton() throws InterruptedException {
        Thread.sleep(1000);
        getDeleteButton.click();
    }
    public void clickDialogDeleteButton() throws InterruptedException {
        Thread.sleep(1000);
        getDialogDeleteButton.click();
    }

    public void getGetAssignButton(){
        getAssignButton.click();
    }
    public void clickCancelButton() throws InterruptedException {
        Thread.sleep(1000);
        getCancelButton.click();
    }
    public void clickPIM(){
        getPIM.click();
    }
}
