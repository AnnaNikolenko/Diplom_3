package site.nomoreparties.stellarburgers.pojo;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public ProfilePage() {
    }
    //ссылка на конструктор
    public void clickConstructorButton(){
        $(byXpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p")).click();
    }

    //логотип
    public MainPage clickLogo(){
        $(byAttribute("href", "/")).click();
        return new MainPage();
    }

    //кнопка Выйти
    public LogInPage clickExitButton(){
        $(byTagAndText("button", "Выход")).click();
        return new LogInPage();
    }
}
