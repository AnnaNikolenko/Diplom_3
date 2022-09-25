package site.nomoreparties.stellarburgers.pojo;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    public ForgotPasswordPage() {
    }

    //кнопка Войти
    public LogInPage clickEnterButton(){
        $(byAttribute("href", "/login")).click();
        return new LogInPage();
    }
}
