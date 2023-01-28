package tests;

import config.AppConfigProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.errorMessagePage.ErrorMessagePage;
import page.signinPage.SigninPage;


public class LoginTest extends BaseTest {
    SigninPage signinPage;
    ErrorMessagePage errorMessagePage;

    @BeforeMethod
    public void setUp() {
        signinPage = new SigninPage();
        errorMessagePage = new ErrorMessagePage();
        signinPage.open();
        signinPage.clickReklama();
        signinPage.clickLoginButtonOnHomePage();
        signinPage.switchToTheTab(1);
    }

    @Test
    @Description("Проверка регистрации пользователя с валидными данными")
    public void validLoginTest() {
        signinPage.insertLogin(AppConfigProvider.get().login());
        signinPage.clickLoginButton();
        signinPage.insertPassword(AppConfigProvider.get().password());
        signinPage.clickLoginButton();
        signinPage.switchToTheTab(0);
        signinPage.clickOnIcon();
        Assert.assertTrue(signinPage.isDisplayed());
        signinPage.clickExit();
    }
}

