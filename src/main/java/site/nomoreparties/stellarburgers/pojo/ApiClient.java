package site.nomoreparties.stellarburgers.pojo;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiClient {
    //базовый урл
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    //ручка на авторизацию юзера
    public static final String LOGIN_USER = "/api/auth/login";
    //ручка на создание юзера
    public static final String CREATE_USER = "/api/auth/register";
    //ручка на получение данных юзера
    public static final String USER_DATA = "/api/auth/user";
    //логировать запросы и ответы
    private final Filter requestFilter = new RequestLoggingFilter();
    private final Filter responseFilter = new ResponseLoggingFilter();

    @Step("Объявлен метод создания пользователя, отправляющий запрос на сервер")
    public Response createRegistration(UserData registration) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(registration)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post(CREATE_USER);
    }

    @Step("Логин под существующим пользователем")
    public Response createAuthorization(UserData registration) {
        return RestAssured.with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .body(registration)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post(LOGIN_USER);
    }

    @Step("Удаление данных пользователя")
    public void deleteUser(String accessToken) {
        RestAssured.with()
                .filters(requestFilter, responseFilter)
                .header("Authorization", accessToken)
                .baseUri(BASE_URL)
                .accept(ContentType.HTML)
                .contentType(ContentType.HTML)
                .delete(USER_DATA);
    }
}
