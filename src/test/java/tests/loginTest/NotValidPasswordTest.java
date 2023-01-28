package tests.loginTest;

import config.AppConfigProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.errorMessagePage.ErrorMessagePage;
import page.signinPage.SigninPage;
import tests.BaseTest;

public class NotValidPasswordTest extends BaseTest {
    SigninPage signinPage;
    ErrorMessagePage errorMessagePage;

    @BeforeMethod
    public void setUp() {
        signinPage = new SigninPage();
        errorMessagePage = new ErrorMessagePage();
        signinPage.open();
        signinPage.clickReklama();
        signinPage.clickLoginButtonOnHomePage();
    }

    @Test
    @Description("Проверка появления сообщения при невалидном пароле")
    public void oneEmptyFields() {
        signinPage.insertLogin(AppConfigProvider.get().login());
        signinPage.clickLoginButton();
        signinPage.clickPassword();
        signinPage.clickLoginButton();
        Assert.assertTrue(errorMessagePage.errorMessagePassword());
    }
}
