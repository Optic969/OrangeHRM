package pageObjects.recruitmentSection;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class RecruitmentSectionNavigation {

    private SelenideElement getRecruitmentSection = $x("//b[contains(text(),'Recruitment')]");
    private SelenideElement getCandidateSection = $x("//a[@id='menu_recruitment_viewCandidates']");
    private SelenideElement getErrorMessageField = $x("//div[@class='message error']");

    @Step("Get New recruitment candidates page")
    public void getAddNewRecruitmentCandidatesPage(){

        getRecruitmentSection.hover();
        getCandidateSection.hover().click();
    }
    @Step("Check Error message for add New recruitment")
    public void shouldHaveErrorMessage(String ErrorMessage){

        getErrorMessageField.shouldHave(Condition.text(ErrorMessage));
    }

}
