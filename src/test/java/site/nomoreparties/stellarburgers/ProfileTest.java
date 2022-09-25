package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;

import java.util.Random;

public class ProfileTest extends BaseTest {
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
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по ссылке «Конструктор»")
    public void clickConstructorFromPersonalAccountTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickConstructorButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип")
    public void clickLogoFromPersonalAccountTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickLogo();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на Выйти")
    public void clickExitFromPersonalAccountTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickExitButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
