package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import site.nomoreparties.stellarburgers.pojo.RegistrationPage;
import java.util.Random;

public class RegistrationTest extends BaseTest{

    private String name;
    private String email;
    public String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void generateUserData(){
        name = new Random().nextInt(500) + "Miaa";
        email = new Random().nextInt(500) + "@ya.ru";
    }

    @Test
    @DisplayName("Регистрация с использованием валидных данных")
    public void registrationWithValidDataTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .setName(name)
                .setEmail(email)
                .setPassword("1q2w3e4r")
                .clickRegistrationButton()
                .getEnterButton()
                .shouldBe(Condition.visible);
        Assert.assertEquals(LOGIN_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Регистрация с вводом некорректного пароля")
    public void registrationWithInvalidPasswordTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .setName(name)
                .setEmail(email)
                .setPassword("1q2")
                .clickRegistrationButtonWithInvalidPassword()
                .getInvalidPasswordMessage()
                .shouldBe(Condition.visible);
        Assert.assertEquals("Некорректный пароль", new RegistrationPage().getInvalidPasswordMessage().getText());
    }
}
