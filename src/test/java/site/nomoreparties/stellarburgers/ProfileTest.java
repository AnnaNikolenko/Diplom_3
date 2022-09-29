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
import site.nomoreparties.stellarburgers.pojo.UserData;

import java.util.Random;

public class ProfileTest extends BaseTest {
    private ApiClient client;
    private String email;
    private String password;
    private UserData responseRegistration;
    public String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    public String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @Before
    public void setUp() {
        client = new ApiClient();
        //сгенерировать данные для регистрации
        email = new Random().nextInt(900) + "@mail.ru";
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
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .getExitButton()
                .shouldBe(Condition.visible);
        Assert.assertEquals(PROFILE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по ссылке «Конструктор»")
    public void clickConstructorFromPersonalAccountTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickConstructorButton()
                .getCheckoutButton()
                .shouldBe(Condition.visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип")
    public void clickLogoFromPersonalAccountTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickLogo()
                .getCheckoutButton()
                .shouldBe(Condition.visible);
        Assert.assertEquals(BASE_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на Выйти")
    public void clickExitFromPersonalAccountTest() {
        new MainPage()
                .openMainPage()
                .clickLogInButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickEnterButton()
                .clickPersonalAccountButtonAfterLogIn()
                .clickExitButton()
                .getEnterButton()
                .shouldBe(Condition.visible);
        Assert.assertEquals(LOGIN_URL, WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
