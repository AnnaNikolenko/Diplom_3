package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //поле Имя
    private final SelenideElement nameField = $(byAttribute("name", "name"));
    //поле Email
    private final SelenideElement emailField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"));
    //поле Пароль
    private final SelenideElement passwordField = $(byXpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input"));
    //кнопка Зарегистрироваться
    private final SelenideElement registrationButton = $(byTagAndText("button", "Зарегистрироваться"));
    //сообщение Некорректный пароль
    private final SelenideElement invalidPasswordMessage = $(byClassName("input__error"));

    public RegistrationPage setName(String name){
        nameField.setValue(name);
        return new RegistrationPage();
    }

    public RegistrationPage setEmail(String email){
        emailField.setValue(email);
        return new RegistrationPage();
    }
    public RegistrationPage setPassword(String password){
        passwordField.setValue(password);
        return new RegistrationPage();
    }

    public RegistrationPage clickRegistrationButtonWithInvalidPassword(){
        registrationButton.click();
        return new RegistrationPage();
    }

    public LogInPage clickRegistrationButton(){
        registrationButton.click();
        return new LogInPage();
    }

    public SelenideElement getInvalidPasswordMessage(){
       return invalidPasswordMessage;
    }

    public LogInPage clickEnterButton(){
        $(byAttribute("href", "/login")).click();
        return new LogInPage();
    }
}
