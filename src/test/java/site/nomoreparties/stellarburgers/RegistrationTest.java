package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.ApiClient;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import site.nomoreparties.stellarburgers.pojo.RegistrationPage;
import site.nomoreparties.stellarburgers.pojo.UserData;
import java.util.Random;

public class RegistrationTest extends BaseTest{
    private ApiClient client;
    private String name;
    private String email;
    public String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private UserData userData;


    @Before
    public void setUp() {
        client = new ApiClient();
        //сгенерировать данные для регистрации
        email = new Random().nextInt(500) + "@mail.ru";
        name = new Random().nextInt(500) + "Miaaa";
        //объявить данные пользователя
        userData = new UserData(email, "1234567", name, null, null, null, null, null);
    }

    @After
    public void deleteUser() {
        //залогиниться
        UserData responseAuthorization = client.createAuthorization(userData).then().extract().as(UserData.class);
        //если успешно авторизован
        if(responseAuthorization.getAccessToken() != null) {
            //получить токен пользователя, сгенерированный при авторизации
            String accessToken = responseAuthorization.getAccessToken();
            //удалить пользователя
            client.deleteUser(accessToken);
        }
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
