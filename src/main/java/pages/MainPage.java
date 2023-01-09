package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {


    private final WebDriver webDriver;
    // Кнопка «Заказать» вверху страницы
    private By orderButtonTop = By.className("Button_Button__ra12g");
    // Кнопка «Заказать» внизу страницы (TODO скролл до неё)
    private By orderButtonMiddle = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // FAQ
    private By faqBasePath = By.className("accordion");
    // куки кнопка
    private By cookieButton = By.xpath(".//button[text()='да все привыкли']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage open(){
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    public MainPage acceptCookie() {
        webDriver.findElement(cookieButton).click();
        return this;
    }

    // может быть сделать свитч для констант order_Button_TOP, *_MIDDLE
    public OrderPage orderButtonTopClick() {
        webDriver.findElement(orderButtonTop).click();
        return new OrderPage(webDriver);
    }

    public OrderPage orderButtonMiddleClick() {
        webDriver.findElement(orderButtonMiddle).click();
        return new OrderPage(webDriver);
    }

    public String getQuestion(int itemNumber) {
        webDriver.findElement(By.xpath(".//div[@class='accordion']/div["+ itemNumber + "]")).click();
        String questionId = String.format("accordion__heading-%d", itemNumber - 1);
        return webDriver.findElement(By.id(questionId)).getText();
    }

    public String getAnswer(int itemNumber) {
        webDriver.findElement(By.xpath(".//div[@class='accordion']/div["+ itemNumber + "]")).click();
        String answerId = String.format("accordion__panel-%d", itemNumber - 1);
        return webDriver.findElement(By.id(answerId)).getText();
    }

    public OrderPage openOrderPageFromTopButton() {
        return new MainPage(webDriver)
                .open()
                .acceptCookie()
                .orderButtonTopClick();
    }

    public OrderPage openOrderPageFromMiddleButton() {
        return new MainPage(webDriver)
                .open()
                .acceptCookie()
                .orderButtonMiddleClick();
    }
}