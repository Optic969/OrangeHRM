package pageObjects.buttons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class Buttons {

    private SelenideElement getAddButton = $x("//button[normalize-space()='Add']");
    private SelenideElement getSaveButton = $x("//button[normalize-space()='Save']");
    private SelenideElement getDeleteButton = $x("//input[@id='btnDelete']");
    private SelenideElement getAssignButton = $x("//input[@id='assignBtn']");
    private SelenideElement getCancelButton = $x("//button[normalize-space()='Cancel']");
    private SelenideElement getPIM = $x("//b[contains(text(),'PIM')]");
    private SelenideElement getDialogDeleteButton = $x("//input[@id='dialogDeleteBtn']");
    private SelenideElement getDialogOkButton = $x("//input[@id='confirmOkButton']");
    private SelenideElement getSearchButton = $x("//input[@id='searchBtn']");

    @Step("Click Add button")
    public void clickAddButton() throws InterruptedException {

        Thread.sleep(1000);
        getAddButton.click();
    }
    @Step("Click Save button")
    public void clickSaveButton() throws InterruptedException {

        Thread.sleep(1000);
        getSaveButton.click();
        Selenide.sleep(1000);
    }
    @Step("Click Delete button")
    public void clickDeleteButton() throws InterruptedException {

        Thread.sleep(1000);
        getDeleteButton.click();
    }
    @Step("Click Dialog Delete button")
    public void clickDialogDeleteButton() throws InterruptedException {

        Thread.sleep(1000);
        getDialogDeleteButton.click();
        Selenide.sleep(1000);
    }
    @Step("Click Assign button")
    public void clickAssignButton() throws InterruptedException {

        Thread.sleep(1000);
        getAssignButton.click();
    }
    @Step("Click Cancel button")
    public void clickCancelButton() throws InterruptedException {

        Thread.sleep(1000);
        getCancelButton.click();
    }
    @Step("Click Dialog Ok button")
    public void clickDialogOkButton() throws InterruptedException {

        Thread.sleep(1000);
        getDialogOkButton.shouldBe(Condition.visible).click();
    }
    @Step("Click PIM button")
    public void clickPIM(){

        getPIM.click();
    }
}
