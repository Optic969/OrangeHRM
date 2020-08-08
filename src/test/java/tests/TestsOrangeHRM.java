package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import pageObjects.AdminSection;
import pageObjects.LoginPage;

public class  TestsOrangeHRM extends TestsSetups {

    LoginPage loginPage = new LoginPage();
    AdminSection adminSection = new AdminSection();

    @Test
    @Order(1)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testConnection() {
        loginPage.getAuthorization();
        //Assert.assertEquals();

    }

    @Test
    @Order(2)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testGoToUserSection() {
        adminSection.getUserCreationPage();
    }
}
