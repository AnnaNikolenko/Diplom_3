package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    //кнопка Войти в аккаунт
    private final SelenideElement logInButton = $(byAttribute("class", "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg"));
    //кнопка Личный кабинет
    private final SelenideElement personalAccountButton = $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p"));
    //кнопка Личный кабинет (если ее кликает залогинившийся пользователь)
    private final SelenideElement personalAccountButtonAfterLogin = $(byXpath("//*[@id=\"root\"]/div/header/nav/a/p"));
    //таб Соусы
    private final SelenideElement sousesTab = $(byTagAndText("span", "Соусы"));
    //таб Булки
    private final SelenideElement bunsTab = $(byTagAndText("span", "Булки"));
    //таб начинки
    private final SelenideElement fillingsTab = $(byTagAndText("span", "Начинки"));
    //Активный таб
    public SelenideElement activeTab = $(byAttribute("class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
    //Кнопка Оформить заказ
    private final SelenideElement checkoutButton = $(byTagAndText("button", "Оформить заказ"));

    public MainPage openMainPage(){
        Selenide.open(BASE_URL);
        return new MainPage();
    }

    public LogInPage clickLogInButton(){
        logInButton.click();
        return new LogInPage();
    }

    public LogInPage clickPersonalAccountButton(){
        personalAccountButton.click();
        return new LogInPage();
    }

    public ProfilePage clickPersonalAccountButtonAfterLogIn(){
        personalAccountButtonAfterLogin.click();
        return new ProfilePage();
    }
     public MainPage clickSousesTab(){
        sousesTab.click();
        return new MainPage();
    }

     public MainPage clickBunsTab(){
        bunsTab.click();
        return new MainPage();
    }

    public MainPage clickFillingsTab(){
        fillingsTab.click();
        return new MainPage();
    }

    public SelenideElement getActiveTab(){
        return activeTab;
    }

     public SelenideElement getCheckoutButton(){
        return checkoutButton;
    }
}
