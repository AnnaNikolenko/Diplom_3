package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    public LogInPage() {
    }

    //ссылка Зарегистрироваться
    private final SelenideElement registerButton = $(byAttribute("href", "/register"));
    //поле Email
    private final SelenideElement emailField = $(byAttribute("name", "name"));
    //поле Password
    private final SelenideElement passwordField = $(byAttribute("name", "Пароль"));
    //кнопка Войти
    private final SelenideElement enterButton = $(byTagAndText("button", "Войти"));
    //кнопка Восстановить пароль
    private final SelenideElement recoveryPasswordButton = $(byAttribute("href", "/forgot-password"));

    public RegistrationPage clickRegisterButton(){
        registerButton.click();
        return new RegistrationPage();
    }

     public LogInPage enterEmail(String email){
        emailField.setValue(email);
        return new LogInPage();
    }

    public LogInPage enterPassword(String password){
        passwordField.setValue(password);
        return new LogInPage();
    }

    public MainPage clickEnterButton(){
        enterButton.click();
        return new MainPage();
    }
    public SelenideElement getEnterButton(){
        return enterButton;
    }

    public ForgotPasswordPage clickRecoveryPasswordButton(){
        recoveryPasswordButton.click();
        return new ForgotPasswordPage();
    }
}
