package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    //ссылка на конструктор
    private final SelenideElement constructorButton = $(byXpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p"));
    public MainPage clickConstructorButton(){
        constructorButton.click();
        return new MainPage();
    }

    //логотип
    private final SelenideElement logo = $(byAttribute("href", "/"));
    public MainPage clickLogo(){
        logo.click();
        return new MainPage();
    }

    //кнопка Выйти
    private final SelenideElement exitButton = $(byTagAndText("button", "Выход"));
    public LogInPage clickExitButton(){
        exitButton.click();
        return new LogInPage();
    }

    public SelenideElement getExitButton(){
        return exitButton;
    }
}
