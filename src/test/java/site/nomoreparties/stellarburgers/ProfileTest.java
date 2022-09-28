package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
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

public class ProfileTest extends BaseTest {
    private String email;
    private String password;
    private UserData responseRegistration;

    public String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    public String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

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
