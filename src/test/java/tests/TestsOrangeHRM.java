package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pageObjects.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class  TestsOrangeHRM extends TestsSetups {

    LoginPage loginPage = new LoginPage();
    AdminSection adminSection = new AdminSection();
    Buttons buttons = new Buttons();
    AddUserForm addUserForm = new AddUserForm();
    AddJobTitleForm addJobTitleForm = new AddJobTitleForm();
    JobTitlePage jobTitlePage = new JobTitlePage();
    RecruitmentSection recruitmentSection = new RecruitmentSection();
    AddCandidatesForm addCandidatesForm = new AddCandidatesForm();
     
    @Test
    @Order(1)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testAuthorization() {

        loginPage.getAuthorization();
    }
    @Test
    @Order(2)
    @DisplayName("Check Add New User empty form ")
    public void testAddNewUserEmptyForm() throws InterruptedException {

        adminSection.getUserCreationPage();
        buttons.clickAddButton();
        buttons.clickSaveButton();
        addUserForm.shouldHaveHintsForEmptyForm("Employee does not exist","Required");
    }
    @Test
    @Order(3)
    @DisplayName("Check Add New User ")
    public void testAddNewUser() throws InterruptedException {
        buttons.clickCancelButton();
        buttons.clickAddButton();
        addUserForm.addNewUser();
        buttons.clickSaveButton();
        Selenide.sleep(1000);
        Assertions.assertTrue(addUserForm.checkSuccessMessage());
    }
    @Test
    @Order(4)
    @DisplayName("Check Add new three titles ")
    public void testAddNewThreeTitles() {
        adminSection.getJobTitleCreationPage();
        for (int i =0; i <3; i++){
            addJobTitleForm.addNewJobTitle("Test" + i);
        }
    }
    @Test
    @Order(5)
    @DisplayName("Check Delete added three titles")
    public void testRemoveAddedThreeTitles() throws InterruptedException {

        jobTitlePage.chooseAddedThreeJobTitle();
        buttons.clickDeleteButton();
        buttons.clickDialogDeleteButton();
        Selenide.sleep(1000);
        jobTitlePage.checkSuccessTitleMessage();
    }
    @Test
    @Order(6)
    @DisplayName("Check Add new candidate")
    public void testAddNewCandidate() throws InterruptedException {

        recruitmentSection.getAddNewRecruitmentCandidatesPage();
        buttons.clickAddButton();
        addCandidatesForm.addCandidate();
        buttons.clickSaveButton();
        recruitmentSection.shouldHaveErrorMessage("An internal error occurred. Please contact your system administrator.");
    }
    

}
