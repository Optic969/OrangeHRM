package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import pageObjects.AddUserForm;
import pageObjects.AdminSection;
import pageObjects.LoginPage;

public class  TestsOrangeHRM extends TestsSetups {

    LoginPage loginPage = new LoginPage();
    AdminSection adminSection = new AdminSection();
    AddUserForm addUserForm = new AddUserForm();

    @Test
    @Order(1)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testAuthorization() {
        loginPage.getAuthorization();
        //Assert.assertEquals();

    }

    @Test
    @Order(2)
    @DisplayName("Check go to User section ")
    public void testGoToUserSection() {
        adminSection.getUserCreationPage();
    }

    @Test
    @Order(3)
    @DisplayName("Check creation of new User ")
    public void testCreateNewUser() {
        addUserForm.addNewUser();
        addUserForm.shouldHaveAddUserAttribute("Ivan","BlackDominator","Qwerty1234","Qwerty1234");
        addUserForm.saveNewUser();
    }
}
