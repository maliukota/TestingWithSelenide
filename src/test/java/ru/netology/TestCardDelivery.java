package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCardDelivery {
    @Test
    void shouldFullForm() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Барнаул");
        $("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        final String FORMAT_DATE = "dd.MM.yyyy";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.plusDays(5);
        String futureDate = dateFormatter.format(newDate);
        $("[placeholder='Дата встречи']").setValue(futureDate);
        $("[name='name']").setValue("Мамин-Сибиряк Иван Петрович");
        $("[name='phone']").setValue("+70000000000");
        $("[data-test-id='agreement']").click();
        $(byClassName("button")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }

//    @Test
//    void shouldFullFormByContainer() {
//        open("http://localhost:9999");
//        $("[placeholder='Город']").setValue("Мо");
//        $(withText("Смоленск")).click();
//        $("[placeholder='Дата встречи']").click();
//        //код для выбора даты через Календарь: +неделя к текущей дате
//
//        $("[name='name']").setValue("Иванов Иван");
//        $("[name='phone']").setValue("+79999999999");
//        $("[data-test-ad='agreement']").click();
//        $(byClassName("button")).click();
//        $(withText("Успешно!")).waitUntil(visible, 15000);
//    }
}