package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pojo.MainPage;

public class MainPageTest {

    @Test
    @DisplayName("Проверка, что работает переход к разделу Булки")
    public void clickBunsTabTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickSousesTab()
                .clickBunsTab()
                .getBunsHeader()
                .shouldBe(Condition.visible);
        Assert.assertEquals("Булки", new MainPage().getBunsHeader().getText());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Соусы")
    public void clickSousesTabTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickSousesTab()
                .getSousesHeader()
                .shouldBe(Condition.visible);
        Assert.assertEquals("Соусы", new MainPage().getSousesHeader().getText());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Начинки")
    public void clickFillingsTabTest() throws InterruptedException {
        Assert.assertTrue(
                new MainPage()
                .openMainPage()
                .getFillingsHeader()
                .scrollTo()
                .isDisplayed());
    }
}
