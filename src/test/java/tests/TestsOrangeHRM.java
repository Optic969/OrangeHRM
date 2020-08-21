package tests;

import org.junit.jupiter.api.*;
import pageObjects.adminSection.*;
import pageObjects.buttons.Buttons;
import pageObjects.dashboardSection.*;
import pageObjects.leaveSection.*;
import pageObjects.loginPage.LoginPage;
import pageObjects.PIMSection.*;
import pageObjects.recruitmentSection.*;
import utils.TestsSetups;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class  TestsOrangeHRM extends TestsSetups {

    LoginPage loginPage = new LoginPage();
    AdminSectionNavigation adminSectionNavigation = new AdminSectionNavigation();
    Buttons buttons = new Buttons();
    AddUserForm addUserForm = new AddUserForm();
    AddJobTitleForm addJobTitleForm = new AddJobTitleForm();
    JobTitlePage jobTitlePage = new JobTitlePage();
    RecruitmentSectionNavigation recruitmentSectionNavigation = new RecruitmentSectionNavigation();
    AddCandidatesForm addCandidatesForm = new AddCandidatesForm();
    LeaveSectionNavigation leaveSectionNavigation = new LeaveSectionNavigation();
    AssignLeaveForm assignLeaveForm = new AssignLeaveForm();
    DashboardNavigation dashboardNavigation = new DashboardNavigation();
    DashboardPage dashboardPage = new DashboardPage();
    PIMNavigation pimNavigation = new PIMNavigation();
    EmployeeAddPage employeeAddPage = new EmployeeAddPage();
    EmployeeListPage employeeListPage = new EmployeeListPage();
    EmployeePersonalDetailsForm employeePersonalDetailsForm = new EmployeePersonalDetailsForm();
     
    @Test
    @Order(1)
    @DisplayName("Check authorization to OrangeHRM ")
    public void testAuthorization() {

        loginPage.getAuthorization();
    }
    @Test
    @Order(2)
    @DisplayName("Create test Employee ")
    public void testCreateTestEmployee() throws InterruptedException {
        pimNavigation.getPIMAddEmployeePage();
        employeeAddPage.createNewEmployee();
        buttons.clickSaveButton();
    }
    @Test
    @Order(3)
    @DisplayName("Check Add New User empty form ")
    public void testAddNewUserEmptyForm() throws InterruptedException {

        adminSectionNavigation.getUserCreationPage();
        buttons.clickAddButton();
        buttons.clickSaveButton();
        addUserForm.shouldHaveHintsForEmptyAddUserForm(
                "Employee does not exist",
                "Required");
    }
    @Test
    @Order(4)
    @DisplayName("Check Add New User ")
    public void testAddNewUser() throws InterruptedException {
        buttons.clickCancelButton();
        buttons.clickAddButton();
        addUserForm.addNewUser();
        buttons.clickSaveButton();
        Assertions.assertTrue(addUserForm.checkSuccessMessage());
    }
    @Test
    @Order(5)
    @DisplayName("Check Add new three titles ")
    public void testAddNewThreeTitles() {
        adminSectionNavigation.getJobTitleCreationPage();
        for (int i =0; i <3; i++){
            addJobTitleForm.addNewJobTitle("Test" + i);
        }
    }
    @Test
    @Order(6)
    @DisplayName("Check Delete added three titles")
    public void testRemoveAddedThreeTitles() throws InterruptedException {

        jobTitlePage.chooseAddedThreeJobTitle();
        buttons.clickDeleteButton();
        buttons.clickDialogDeleteButton();
        jobTitlePage.checkSuccessTitleMessage();
    }
    @Test
    @Order(7)
    @DisplayName("Check Add new candidate")
    public void testAddNewCandidate() throws InterruptedException {

        recruitmentSectionNavigation.getAddNewRecruitmentCandidatesPage();
        buttons.clickAddButton();
        addCandidatesForm.addCandidate();
        buttons.clickSaveButton();
        recruitmentSectionNavigation.shouldHaveErrorMessage("An internal error occurred. Please contact your system administrator.");
    }
    @Test
    @Order(8)
    @DisplayName("Check Assign Leave empty form")
    public void testAddAssignLeave() throws InterruptedException {
        leaveSectionNavigation.getAssignLeavePage();
        buttons.clickAssignButton();
        assignLeaveForm.shouldHaveHintsForEmptyAssignLeaveForm(
                "Invalid",
                "Required",
                "Should be a valid date in yyyy-mm-dd format",
                "Should be a valid date in yyyy-mm-dd format");
    }
    @Test
    @Order(9)
    @DisplayName("Check Add Assign Leave")
    public void testCheckAddAssignLeave() throws InterruptedException {
        leaveSectionNavigation.getAssignLeavePage();
        assignLeaveForm.getAddAssignLeave(19,20);
        buttons.clickAssignButton();
        buttons.clickDialogOkButton();
        assignLeaveForm.checkSuccessMessage();
    }
    @Test
    @Order(10)
    @DisplayName("Check presence of Dashboard elements")
    public void testCheckDashboardElementPresent(){

        dashboardNavigation.getDashboardPage();
        dashboardPage.checkDashboardElementPresent();
    }
    @Test
    @Order(11)
    @DisplayName("Check PIM employee form")
    public void testCheckPIMEmployeeForm(){

        pimNavigation.getPIMEmployeeListPage();
        employeeListPage.openEmployeeProfile();
        employeePersonalDetailsForm.checkEmployeePersonalDetailsFormElements();
        employeePersonalDetailsForm.shouldContainsPersonalInfo();
    }
    @Test
    @Order(12)
    @DisplayName("Delete created test Employee")
    public void testDeleteCreatedEmployee() throws InterruptedException {
        pimNavigation.getPIMEmployeePage();
        employeeListPage.getEmployForDelete();
        buttons.clickDeleteButton();
        buttons.clickDialogDeleteButton();
        Assertions.assertTrue(employeeListPage.checkSuccessMessage());
        loginPage.logoutFromApp();
    }
}
