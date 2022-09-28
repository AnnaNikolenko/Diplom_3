package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public MainPage openMainPage(){
        Selenide.open(BASE_URL);
        return new MainPage();
    }

    //кнопка Войти в аккаунт
    private final SelenideElement logInButton = $(byAttribute("class", "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg"));
    public LogInPage clickLogInButton(){
        logInButton.click();
        return new LogInPage();
    }

    //кнопка Личный кабинет
    private final SelenideElement personalAccountButton = $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p"));
    public LogInPage clickPersonalAccountButton(){
        personalAccountButton.click();
        return new LogInPage();
    }

    //кнопка Личный кабинет (если ее кликает залогинившийся пользователь)
    private final SelenideElement personalAccountButtonAfterLogin = $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p"));
    public ProfilePage clickPersonalAccountButtonAfterLogIn(){
        personalAccountButtonAfterLogin.click();
        return new ProfilePage();
    }
    //таб Соусы
    private final SelenideElement sousesTab = $(byTagAndText("span", "Соусы"));
    public MainPage clickSousesTab(){
        sousesTab.click();
        return new MainPage();
    }

    //таб Булки
    private final SelenideElement bunsTab = $(byTagAndText("span", "Булки"));
    public MainPage clickBunsTab(){
        bunsTab.click();
        return new MainPage();
    }

    //таб начинки
    private final SelenideElement fillingsTab = $(byTagAndText("span", "Начинки"));
    public MainPage clickFillingsTab(){
        fillingsTab.click();
        return new MainPage();
    }

    //Заголовок Булки
    private final SelenideElement bunsHeader = $(byTagAndText("h2", "Булки"));
    public SelenideElement getBunsHeader(){
        return bunsHeader;
    }

    //Заголовок Соусы
    private final SelenideElement sousesHeader = $(byTagAndText("h2", "Соусы"));
    public SelenideElement getSousesHeader(){
        return sousesHeader;
    }

    //Заголовок Начинки
    private final SelenideElement fillings = $(byTagAndText("h2", "Начинки"));
    public SelenideElement getFillingsHeader(){
        return fillings;
    }

    //Кнопка Оформить заказ
    private final SelenideElement checkoutButton = $(byTagAndText("button", "Оформить заказ"));
    public SelenideElement getCheckoutButton(){
        return checkoutButton;
    }
}
