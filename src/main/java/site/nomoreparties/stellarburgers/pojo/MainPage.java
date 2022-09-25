package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage() {
    }

    public MainPage openMainPage(){
        Selenide.open("https://stellarburgers.nomoreparties.site/");
        return new MainPage();
    }

    //кнопка Войти в аккаунт
    public LogInPage clickLogInButton(){
        $(byAttribute("class", "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg")).click();
        return new LogInPage();
    }

    //кнопка Личный кабинет
    public LogInPage clickPersonalAccountButton(){
        $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p")).click();
        return new LogInPage();
    }
    //кнопка Личный кабинет (если ее кликает залогинившийся пользователь)
    public ProfilePage clickPersonalAccountButtonAfterLogIn(){
        $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p")).click();
        return new ProfilePage();
    }
    //таб Соусы
    public MainPage clickSousesTab(){
        $(byTagAndText("span", "Соусы")).click();
        return new MainPage();
    }

    //таб Булки
    public MainPage clickBunsTab(){
        $(byTagAndText("span", "Булки")).click();
        return new MainPage();
    }

    //таб начинки
    public MainPage clickFillingsTab(){
        $(byTagAndText("span", "Начинки")).click();
        return new MainPage();
    }

    //Заголовок Булки
    public SelenideElement getBunsHeader(){
        return $(byTagAndText("h2", "Булки"));
    }

    //Заголовок Соусы
    public SelenideElement getSousesHeader(){
        return $(byTagAndText("h2", "Соусы"));
    }

    //Заголовок Начинки
    public SelenideElement getFillingsHeader(){
        return $(byTagAndText("h2", "Начинки"));
    }
}
