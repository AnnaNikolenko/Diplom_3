package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private final SelenideElement constructorButton = $(byAttribute("class", "AppHeader_header__linkText__3q_va ml-2"));
    //логотип
    private final SelenideElement logo = $(byAttribute("href", "/"));
    //кнопка Выйти
    private final SelenideElement exitButton = $(byTagAndText("button", "Выход"));

    public MainPage clickConstructorButton(){
        constructorButton.click();
        return new MainPage();
    }

    public MainPage clickLogo(){
        logo.click();
        return new MainPage();
    }

    public LogInPage clickExitButton(){
        exitButton.click();
        return new LogInPage();
    }

    public SelenideElement getExitButton(){
        return exitButton;
    }
}
