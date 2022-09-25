package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import java.util.Random;

public class LogInTest extends BaseTest {

    String name;
    String email;
    String password;

    @Before
    public void createUser(){
            name = new Random().nextInt(300) + "Mia";
            email = new Random().nextInt(300) + "@ya.ru";
            password = "1q2w3e4r";
            new MainPage()
                    .openMainPage()
                    .clickLogInButton()
                    .clickRegisterButton()
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password)
                    .clickRegistrationButton();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void logInByEnterAccountButtonTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton();
        Thread.sleep(5000);
    Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void logInByPersonalAccountButtonTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickPersonalAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void logInByButtonInRegistrationFormTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .clickEnterButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void logInByButtonInRecoveryPasswordFormTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRecoveryPasswordButton()
                .clickEnterButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
