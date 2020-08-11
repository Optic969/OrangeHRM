package tests;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import pageObjects.*;

public class  TestsOrangeHRM extends TestsSetups {

    LoginPage loginPage = new LoginPage();
    AdminSection adminSection = new AdminSection();
    Buttons buttons = new Buttons();
    AddUserForm addUserForm = new AddUserForm();
    AddJobTitleForm addJobTitleForm = new AddJobTitleForm();
    RemoveJobTitle removeJobTitle = new RemoveJobTitle();

    @Test
    @Order(1)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testAuthorization() {

        loginPage.getAuthorization();

    }

    @Test
    @Order(2)
    @DisplayName("Check Add of new User ")
    public void testAddNewUser() {

        adminSection.getUserCreationPage();
        buttons.clickAddButton();
        addUserForm.addNewUser();
        addUserForm.shouldHaveAddedUserAttribute("Ivan","BlackDominator","Qwerty1234","Qwerty1234");
        buttons.clickSaveButton();
    }

    @Test
    @Order(3)
    @DisplayName("Check Add new three titles ")
    public void testAddNewThreeTitles() {
        adminSection.getJobTitleCreationPage();
        for (int i =0; i <4; i++){
            addJobTitleForm.addNewJobTitle("Test" + i);
        }
    }

    @Test
    @Order(4)
    @DisplayName("Check Delete added three titles")
    public void testRemoveAddedThreeTitles(){

        removeJobTitle.chooseAddedThreeJobTitle();
        buttons.clickDeleteButton();
    }


}
