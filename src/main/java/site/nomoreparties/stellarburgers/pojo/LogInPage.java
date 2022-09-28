package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    public LogInPage() {
    }

    //ссылка Зарегистрироваться
    private final SelenideElement registerButton = $(byAttribute("href", "/register"));
    public RegistrationPage clickRegisterButton(){
        registerButton.click();
        return new RegistrationPage();
    }

    //поле Email
    private final SelenideElement emailField = $(byAttribute("name", "name"));
    public LogInPage enterEmail(String email){
        emailField.setValue(email);
        return new LogInPage();
    }

    //поле Password
    private final SelenideElement passwordField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"));
    public LogInPage enterPassword(String password){
        passwordField.setValue(password);
        return new LogInPage();
    }

    //кнопка Войти
    private final SelenideElement enterButton = $(byTagAndText("button", "Войти"));
    public MainPage clickEnterButton(){
        enterButton.click();
        return new MainPage();
    }
    public SelenideElement getEnterButton(){
        return enterButton;
    }

    //кнопка Восстановить пароль
    private final SelenideElement recoveryPasswordButton = $(byAttribute("href", "/forgot-password"));
    public ForgotPasswordPage clickRecoveryPasswordButton(){
        recoveryPasswordButton.click();
        return new ForgotPasswordPage();
    }
}
