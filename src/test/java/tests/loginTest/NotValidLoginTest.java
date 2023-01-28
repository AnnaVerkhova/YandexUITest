package tests.loginTest;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.errorMessagePage.ErrorMessagePage;
import page.signinPage.SigninPage;
import tests.BaseTest;

public class NotValidLoginTest extends BaseTest {
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
    @Description("Проверка появления сообщения при невалидном логине")
    public void LoginFieldIsEmpty() {
        signinPage.clickLoginButton();
        signinPage.clickLogin();
        Assert.assertTrue(errorMessagePage.errorMessageEmptyLogin());
    }
}
