package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import site.nomoreparties.stellarburgers.pojo.RegistrationPage;
import java.util.Random;

public class RegistrationTest extends BaseTest{

    String name;
    String email;

    @Before
    public void generateUserData(){
        name = new Random().nextInt(300) + "Mia";
        email = new Random().nextInt(300) + "@ya.ru";
    }

    @Test
    @DisplayName("Регистрация с использованием валидных данных")
    public void registrationWithValidDataTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .setName(name)
                .setEmail(email)
                .setPassword("1q2w3e4r")
                .clickRegistrationButton();
        Thread.sleep(5000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Регистрация с вводом некорректного пароля")
    public void registrationWithInvalidPasswordTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .setName(name)
                .setEmail(email)
                .setPassword("1q2")
                .clickRegistrationButton();
        Thread.sleep(5000);
        Assert.assertEquals("Некорректный пароль", new RegistrationPage().getInvalidPasswordMessage().getText());
    }
}
