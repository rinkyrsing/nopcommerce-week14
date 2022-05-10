package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void init() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

      homePage.clickOnRegisterLink();
      registerPage.getRegisterText();
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {

        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        //System.out.println("softAssert method ");
        String expectedResult = "First name is required.";
        String actualResult = registerPage.getFirstNameErrorText();
        softAssert.assertEquals(actualResult, expectedResult, "Error");
        String expectedText = "Last name is required.";
        String actualText = registerPage.getLastNameErrorText();
        softAssert.assertEquals(actualResult, expectedResult, "Error");
        String expectedMessage = "Email is required.";
        String actualMessage = registerPage.getEmailErrorText();
        softAssert.assertEquals(actualResult, expectedResult, "Error");
        String expectedMessage1 = "Password is required.";
        String actualMessage1 = registerPage.getPasswordErrorText();
        softAssert.assertEquals(actualResult, expectedResult, "Error");
        String expectedText1 = "Password is required.";
        String actualText1 = registerPage.getPasswordConfErrorText();
        softAssert.assertEquals(actualResult, expectedResult, "Error");
        softAssert.assertAll();

    }
   @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully(){

       homePage.clickOnRegisterLink();
       registerPage.clickOnGenderButton();
       registerPage.selectFirstName("amy");
       registerPage.selectLastName("smith");
       registerPage.selectDateOfBirth("24");
       registerPage.selectMonthOfBirth("July");
       registerPage.selectYearOfBirth("2010");
       registerPage.sendEmailText("gitshub123@gmail.com");
       registerPage.sendPasswordText("gh123456");
       registerPage.sendConfirmText("gh123456");
       registerPage.clickOnRegisterButton();
       String expectedText = "Your registration completed";
       String actualText = registerPage.getRegistrationCompletedText();
       softAssert.assertEquals(actualText, expectedText, "Error");
       softAssert.assertAll();

    }

}


