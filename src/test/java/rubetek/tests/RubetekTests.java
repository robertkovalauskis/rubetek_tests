package rubetek.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RubetekTests extends TestBase {

    @Test
    @DisplayName("Корректное открытие главной страницы")
    void mainPageTest() {
        open("https://rubetek.com/");
        $(By.xpath("//h1")).shouldHave(text("Интернет-магазин Rubetek"));
    }

    @Test
    @Disabled("Нужны учетные данные")
    @DisplayName("Успешная авторизация")
    void successfulLoginTest() {
        open("https://rubetek.com/");
        $(By.xpath(".right-menu__item--lk")).click();
        // todo
    }

    @Test
    @DisplayName("Неуспешная авторизация")
    void unSuccessfulLoginTest() {
        open("https://rubetek.com/");
        $(".right-menu__item--lk").click();
        $(By.xpath("//input[@name='login']")).sendKeys("123123");
        $(By.xpath("//input[@name='password']")).sendKeys("123123");
        $(".pop-auth__btn").click();

        $("body").shouldHave(text("Неверный логин или пароль"));
    }

    @Test
    @DisplayName("Навигация по сайту")
    void webNavigationTest() {
        open("https://rubetek.com/");
        $(By.linkText("Управление")).click();
        $("body").shouldHave(text("Управление"));
        $(By.linkText("Видеонаблюдение")).click();
        $("body").shouldHave(text("Видеонаблюдение"));
        $(By.linkText("Климат")).click();

        $("body").shouldHave(text("Климат"));
        $(By.linkText("Датчики")).click();
        $("body").shouldHave(text("Датчики"));
        $(By.linkText("Освещение и электропитание")).click();
        $("body").shouldHave(text("Освещение и электропитание"));
        $(By.linkText("Комплекты умного дома")).click();
        $("body").shouldHave(text("Комплекты умного дома"));
    }


}