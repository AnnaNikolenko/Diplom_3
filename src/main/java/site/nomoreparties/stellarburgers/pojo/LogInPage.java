package site.nomoreparties.stellarburgers.pojo;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    public LogInPage() {
    }

    //ссылка Зарегистрироваться
    public RegistrationPage clickRegisterButton(){
        $(byAttribute("href", "/register")).click();
        return new RegistrationPage();
    }

    //поле Email
    public LogInPage enterEmail(String email){
        $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")).setValue(email);
        return new LogInPage();
    }

    //поле Password
    public LogInPage enterPassword(String password){
        $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")).setValue(password);
        return new LogInPage();
    }

    //кнопка Войти
    public MainPage clickEnterButton(){
        $(byTagAndText("button", "Войти")).click();
        return new MainPage();
    }

    //кнопка Восстановить пароль
    public ForgotPasswordPage clickRecoveryPasswordButton(){
        $(byAttribute("href", "/forgot-password")).click();
        return new ForgotPasswordPage();
    }
}
