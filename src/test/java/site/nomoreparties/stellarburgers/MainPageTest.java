package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;

public class MainPageTest {

    @Test
    @DisplayName("Проверка, что работает переход к разделу Булки")
    public void clickBunsTabTest() {
        Assert.assertTrue(
                new MainPage()
                .openMainPage()
                .clickSousesTab()
                .clickBunsTab()
                .getActiveTab()
                .innerHtml()
                .contains("Булки"));
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Соусы")
    public void clickSousesTabTest() {
        Assert.assertTrue(
                new MainPage()
                .openMainPage()
                .clickSousesTab()
                .getActiveTab()
                .innerHtml()
                .contains("Соусы"));
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Начинки")
    public void clickFillingsTabTest() {
        Assert.assertTrue(
                new MainPage()
                        .openMainPage()
                        .clickFillingsTab()
                        .getActiveTab()
                        .innerHtml()
                        .contains("Начинки"));
        }
    }

