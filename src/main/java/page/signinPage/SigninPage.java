package page.signinPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import page.BasePage;

public class SigninPage extends BasePage {

    private static final By CLOSE_REKLAMA = By.xpath("//*[@class='pay-promo-close-btn js-close']");
    private static final By START_BUTTON = By.xpath("//*[@class='button-inner deco-button-stylable']//*[.='Войти']");
    private static final By LOGIN_INPUT = By.xpath("//input[@name='login'] ");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='passp-field-passwd'] ");
    private static final By SIGNIN_IN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    private static final By ICON = By.xpath("//div[@title='an.verkhova@gmail.com']");
    protected static final By CONFIRMATION_WINDOW = By.xpath("//span[@title='an.verkhova@gmail.com']");
    protected static final By BUTTON_EXIT = By.xpath("//a[.='Выйти']");
    private static String pageURL = "https://music.yandex.ru/home";

    @Step("Открывается страница")
    public void open() {
        super.open(pageURL);
    }

    @Step("Нажать кнопку Войти на стартовой странице ")
    public void clickLoginButtonOnHomePage() {
        lookElement(START_BUTTON).click();
        goToHandle();
    }

    @Step("Ввести валидный логин")
    public SigninPage insertLogin(String login) {
        lookForElement(LOGIN_INPUT, login);
        return this;
    }

    @Step("Ввести валидный пароль ")
    public SigninPage insertPassword(String password) {
        lookForElement(PASSWORD_INPUT, password);
        return this;
    }

    @Step("Закрыть рекламу")
    public SigninPage clickReklama() {
        lookElement(CLOSE_REKLAMA).click();
        return this;
    }

    @Step("Поставить курсор в поле пароля")
    public SigninPage clickPassword() {
        lookElement(PASSWORD_INPUT).click();
        return this;
    }

    @Step("Поставить курсов в поле логин")
    public SigninPage clickLogin() {
        lookElement(LOGIN_INPUT).click();
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public SigninPage clickLoginButton() {
        lookElement(SIGNIN_IN_BUTTON).click();
        return this;
    }

    @Step("Нажать на иконку профиля")
    public SigninPage clickOnIcon() {
        goToHandle();
        lookElement(ICON).click();
        return this;
    }

    @Step("Проверка отображения почты зарегистрированного пользователя")
    public boolean isDisplayed() {
        boolean displayed = lookElement(CONFIRMATION_WINDOW).isDisplayed();
        return displayed;
    }

    @Step("Выйти из профиля пользователя")
    public void clickExit() {
        lookElement(BUTTON_EXIT).click();
    }
}
