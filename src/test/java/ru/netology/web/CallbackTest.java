package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $ (".form");
        form.$("[data-test-id=name] input").setValue("Алена Редина");
        form.$("[data-test-id=phone] input").setValue("+79277970093");
        form.$("[data-test-id=agreement]").click();
        form.$(".button__content").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}


