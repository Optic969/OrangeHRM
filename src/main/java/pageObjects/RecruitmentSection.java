package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RecruitmentSection {

    private SelenideElement getRecruitmentSection = $x("//b[contains(text(),'Recruitment')]");
    private SelenideElement getCandidateSection = $x("//a[@id='menu_recruitment_viewCandidates']");
    private SelenideElement getErrorMessageField = $x("//div[@class='message error']");

    public void getAddNewRecruitmentCandidatesPage(){
        getRecruitmentSection.hover();
        getCandidateSection.hover().click();
    }
    public void shouldHaveErrorMessage(String ErrorMessage){
        getErrorMessageField.shouldHave(Condition.text(ErrorMessage));
    }

}
