package ru.praktikum.sprint4.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterMainFlowTests extends TestBase{
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String scooterСolour;
    private final String comment;

    public OrderScooterMainFlowTests(String firstName, String lastName, String address,
                                     String metroStation, String phone, String date, String period, String scooterСolour,
                                     String comment) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metro = metroStation;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.scooterСolour = scooterСolour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {"Петр", "Петров", "г. Воронеж, ул. Рылеева, д. 13", "Бульвар Рокоссовского", "+79204006411", "31.01.2023", "сутки", "black", "спасибо )"},
                {"Иван", "Иванов", "г. Москва", "Речной вокзал", "+79601341968", "31.01.2023", "двое суток", "grey", "спасибо ))"},
        };
    }

    @Test
    public void orderScooterMainFlowFromTopOrderButtonPositiveTest(){
        OrderPage orderPage = new MainPage(driver).openOrderPageFromTopButton();
        orderPage.createOrder(firstName,lastName, address, metro, phone, date, period, scooterСolour, comment);
        boolean actualResult = orderPage.orderConfirmIsDisplayed();
        assertTrue("Модальное окно 'Заказ оформлен' должно отображаться на странице", actualResult);
    }

    @Test
    public void orderScooterMainFlowFromMiddleOrderButtonPositiveTest(){
        OrderPage orderPage = new MainPage(driver).openOrderPageFromMiddleButton();
        orderPage.createOrder(firstName,lastName, address, metro, phone, date, period, scooterСolour, comment);
        boolean actualResult = orderPage.orderConfirmIsDisplayed();
        assertTrue("Модальное окно 'Заказ оформлен' должно отображаться на странице", actualResult);
    }
}
