package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.ApiClient;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import site.nomoreparties.stellarburgers.pojo.UserData;
import java.util.Random;
import static com.codeborne.selenide.Condition.visible;

public class LogInTest extends BaseTest {
    private ApiClient client;
    private  UserData responseRegistration;
    private String email;
    private String password;
    public String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        client = new ApiClient();
        //сгенерировать данные для регистрации
        email = new Random().nextInt(800) + "@mail.ru";
        password = "1234567";
        //объявить данные пользователя
        UserData userData = new UserData(email, password, "Miaa", null, null, null, null, null);
        //зарегистрироваться
        responseRegistration = client.createRegistration(userData).then().extract().as(UserData.class);
    }

    @After
    public void deleteUser() {
        //если пользователь был создан
        if(responseRegistration.getAccessToken() != null) {
            //получить токен пользователя, сгенерированный при регистрации
            String accessToken = responseRegistration.getAccessToken();
            //удалить пользователя
            client.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void logInByEnterAccountButtonTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .getCheckoutButton()
                .shouldBe(visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void logInByPersonalAccountButtonTest() {
        new MainPage()
                .openMainPage()
                .clickPersonalAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .getCheckoutButton()
                .shouldBe(visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void logInByButtonInRegistrationFormTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRegisterButton()
                .clickEnterButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .getCheckoutButton()
                .shouldBe(visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void logInByButtonInRecoveryPasswordFormTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .clickRecoveryPasswordButton()
                .clickEnterButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .getCheckoutButton()
                .shouldBe(visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
