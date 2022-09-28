package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;
import site.nomoreparties.stellarburgers.pojo.UserData;
import java.util.Random;
import static com.codeborne.selenide.Condition.visible;

public class LogInTest extends BaseTest {
    private String email;
    private String password;
    private UserData responseRegistration;
    public String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void createUser(){
        String name = new Random().nextInt(1000) + "Miia";
        email = new Random().nextInt(1000) + "@ya.ru";
        password = "1q2w3e4r";
        UserData registration = new UserData(email, password, name, null, null, null, null, null);
        responseRegistration = RestAssured.with()
                    .baseUri(BASE_URL)
                    .body(registration)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .post("/api/auth/register")
                    .then()
                    .statusCode(200)
                    .extract().as(UserData.class);
    }

    @After
    public void deleteUser() {
        if(responseRegistration != null) {
            String accessToken = responseRegistration.getAccessToken();
            RestAssured.with()
                    .header("Authorization", accessToken)
                    .baseUri(BASE_URL)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .delete("/api/auth/user");
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
