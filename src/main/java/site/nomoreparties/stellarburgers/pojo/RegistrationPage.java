package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public RegistrationPage() {
    }

    //поле Имя
    public RegistrationPage setName(String name){
        $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")).setValue(name);
        return new RegistrationPage();
    }
    //поле Email
    public RegistrationPage setEmail(String email){
        $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")).setValue(email);
        return new RegistrationPage();
    }
    //поле Пароль
    public RegistrationPage setPassword(String password){
        $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")).setValue(password);
        return new RegistrationPage();
    }
    //кнопка Зарегистрироваться
    public void clickRegistrationButton(){
        $(byTagAndText("button", "Зарегистрироваться")).click();
    }

    //сообщение Некорректный пароль
    public SelenideElement getInvalidPasswordMessage(){
       return $(byClassName("input__error"));
    }

    //кнопка Войти
    public LogInPage clickEnterButton(){
        $(byAttribute("href", "/login")).click();
        return new LogInPage();
    }
}
