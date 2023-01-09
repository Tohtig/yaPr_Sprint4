package ru.praktikum.sprint4.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQTest extends TestBase {
    private final int itemNumber;
    private final String correctQuestion;
    private final String correctAnswer;

    public FAQTest(int itemNumber, String question, String answer) {
        this.itemNumber = itemNumber;
        this.correctQuestion = question;
        this.correctAnswer = answer;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете " +
                                "просто сделать несколько заказов — один за другим."},
                {3, "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт " +
                                "времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы " +
                                "привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                                "номеру 1010."},
                {6, "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете " +
                                "кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все " +
                                "же свои."},
                {8, "Я живу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Test
    public void faqClickShowsTheCorrectText() {
        MainPage page = new MainPage(driver)
                .open()
                .acceptCookie();

        String question = page.getQuestion(itemNumber);
        String answer = page.getAnswer(itemNumber);

        assertEquals(correctQuestion, question);
        assertEquals(correctAnswer, answer);
    }
}