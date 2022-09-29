package site.nomoreparties.stellarburgers.pojo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    //кнопка Войти
    private final SelenideElement enterButton = $(byAttribute("href", "/login"));
    public LogInPage clickEnterButton(){
        enterButton.click();
        return new LogInPage();
    }
}
