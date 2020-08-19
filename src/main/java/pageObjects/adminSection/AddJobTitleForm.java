package pageObjects.adminSection;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AddJobTitleForm {

    private SelenideElement getJobTitleName = $x("//input[@id='jobTitle_jobTitle']");
    private SelenideElement getJobTitleDescription = $x("//textarea[@id='jobTitle_jobDescription']");
    private SelenideElement getGetJobTitleNote = $x("//textarea[@id='jobTitle_note']");
    private SelenideElement getAddButton = $x("//input[@id='btnAdd']");
    private SelenideElement getSaveButton = $x("//input[@id='btnSave']");

    public void addNewJobTitle(String text) {

        getAddButton.click();
        getJobTitleName.sendKeys(text);
        getSaveButton.click();
    }

}
