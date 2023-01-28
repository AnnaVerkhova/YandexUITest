package page.errorMessagePage;

import page.BasePage;

import static page.errorMessagePage.ErrorMessagePageLocator.ERROR_EMPTY_LOGIN;
import static page.errorMessagePage.ErrorMessagePageLocator.ERROR_PASSWORD_MESSAGE;

public class ErrorMessagePage extends BasePage {

    public boolean errorMessagePassword() {
        return lookElement(ERROR_PASSWORD_MESSAGE).isDisplayed();
    }

    public boolean errorMessageEmptyLogin() {
        return lookElement(ERROR_EMPTY_LOGIN).isDisplayed();
    }
}