package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import groovy.util.logging.Log;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //поле Имя
    private final SelenideElement nameField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"));
    public RegistrationPage setName(String name){
        nameField.setValue(name);
        return new RegistrationPage();
    }
    //поле Email
    private final SelenideElement emailField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"));
    public RegistrationPage setEmail(String email){
        emailField.setValue(email);
        return new RegistrationPage();
    }
    //поле Пароль
    private final SelenideElement passwordField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input"));
    public RegistrationPage setPassword(String password){
        passwordField.setValue(password);
        return new RegistrationPage();
    }
    //кнопка Зарегистрироваться
    private final SelenideElement registrationButton = $(byTagAndText("button", "Зарегистрироваться"));

    public RegistrationPage clickRegistrationButtonWithInvalidPassword(){
        registrationButton.click();
        return new RegistrationPage();
    }

    public LogInPage clickRegistrationButton(){
        registrationButton.click();
        return new LogInPage();
    }


    //сообщение Некорректный пароль
    private final SelenideElement invalidPasswordMessage = $(byClassName("input__error"));
    public SelenideElement getInvalidPasswordMessage(){
       return invalidPasswordMessage;
    }

    //кнопка Войти
    private final SelenideElement enterButton = $(byAttribute("href", "/login"));
    public LogInPage clickEnterButton(){
        $(byAttribute("href", "/login")).click();
        return new LogInPage();
    }
}
