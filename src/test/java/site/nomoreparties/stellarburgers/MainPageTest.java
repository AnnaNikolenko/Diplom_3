package site.nomoreparties.stellarburgers;

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
                .clickBunsTab();
        Thread.sleep(5000);
        Assert.assertEquals("Булки", new MainPage().getBunsHeader().getText());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Соусы")
    public void clickSousesTabTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickSousesTab();
        Thread.sleep(5000);
        Assert.assertEquals("Соусы", new MainPage().getSousesHeader().getText());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу Начинки")
    public void clickFillingsTabTest() throws InterruptedException {
        new MainPage()
                .openMainPage()
                .clickFillingsTab();
        Thread.sleep(5000);
        Assert.assertEquals("Начинки", new MainPage().getFillingsHeader().getText());
    }
}
