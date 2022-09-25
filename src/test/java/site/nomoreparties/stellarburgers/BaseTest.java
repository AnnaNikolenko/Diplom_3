package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

        //создаем метод предварительных настроек
        public void setUp(){

            /** настройка Хром браузера */
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";

            /** настройка Яндекс браузера
            System.setProperty("webdriver.chrome.driver","/Users/anna/Desktop/Diplom_3/src/main/resources/chromedriver");
            ChromeOptions options=new ChromeOptions();
            options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
            WebDriver webDriver= new ChromeDriver(options); */

            //подтверждаем, что драйвер менеджер у нас доступен
            Configuration.driverManagerEnabled = false;
            //устанавливаем размер окна браузера при открытии
            Configuration.browserSize = "1154x821";
            //устанавливаем, чтоб браузер открывался и можно было увидеть как проходят тесты
            Configuration.headless = false;
            //увеличиваем время ожидания загрузки страницы
            Configuration.pageLoadTimeout = 50000;
            //чистим куки
            Selenide.clearBrowserCookies();
        }

        //перед каждым запуском теста нужно выполнить созданные выше настройки
        @Before
        public void unit(){
            setUp();
        }

        //после каждого теста надо закрыть веб-драйвер

        @After
        public void tearDown(){
            Selenide.closeWebDriver();
        }

    }



