package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver webDriver;

    // Поле * Имя
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    // Поле * Фамилия
    private By lastNameFiled = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле * Адрес: куда привезти заказ
    private By addressFiled = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Выпадающий список * Станция метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле * Телефон: на него позвонит курьер
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее экрана заказа
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    // Календарь * Когда привезти самокат
    private By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Листбокс срок аренды
    private By rentalPeriodList = By.xpath(".//span[@class='Dropdown-arrow']");
    // Чекбокс Цвет самоката (т.к. не радиобаттн, негативный тест на два цвета одновременно)
    private By blackScooter = By.xpath(".//input[@id='black']");
    private By greyScooter = By.xpath(".//input[@id='grey']");
    // Коммент для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка заказать
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка Да
    private By yesButton = By.xpath(".//button[text()='Да']");
    // модальное окно подтверждения заказа
    private By orderConfirm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    // модальное окно подтверждения заказа - текст
    private By orderMessage = By.xpath(".//div[@class='Order_Text__2broi']");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderPage setFirstNameField(String firstNameField) {
        webDriver.findElement(this.firstNameField).sendKeys(firstNameField);
        return this;
    }

    public OrderPage setLastNameFiled(String lastNameFiled) {
        webDriver.findElement(this.lastNameFiled).sendKeys(lastNameFiled);
        return this;
    }

    public OrderPage setAddressFiled(String addressFiled) {
        webDriver.findElement(this.addressFiled).sendKeys(addressFiled);
        return this;
    }

    public OrderPage setMetroField(String metroStation) {
        webDriver.findElement(metroField).click();
        webDriver.findElement(metroField).sendKeys(metroStation);
        webDriver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
        return this;
    }

    public OrderPage setPhoneField(String phoneField) {
        webDriver.findElement(this.phoneField).sendKeys(phoneField);
        return this;
    }

    public OrderPage clickOnNextButton() {
        webDriver.findElement(nextButton).click();
        return this;
    }

    public OrderPage setDate(String date) {
        webDriver.findElement(calendar).sendKeys(date);
        return this;
    }

    // дописать как класс с константами из 1-го спринта, см. ScooterColour
    public OrderPage setRentalPeriod(String period) {
        webDriver.findElement(rentalPeriodList).click();
        webDriver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + period + "']")).click();
        return this;
    }

    public OrderPage setScooterColor(String color) {
        if (color.equals("black")) {
            webDriver.findElement(blackScooter).click();
        } else if (color.equals("grey")) {
            webDriver.findElement(greyScooter).click();
        }
        return this;
    }

    public OrderPage setCommentField(String commentField){
        webDriver.findElement(this.commentField).sendKeys(commentField);
        return this;
    }

    public OrderPage clickOnOrderButton() {
        webDriver.findElement(orderButton).click();
        return this;
    }

    public OrderPage clickOnYes() {
        webDriver.findElement(yesButton).click();
        return this;
    }

    public boolean orderConfirmIsDisplayed() {
        return webDriver.findElement(orderConfirm).isDisplayed();
    }

    public OrderPage createOrder(String firstName, String lastName, String address,
                                  String metroStation, String phone, String date, String period, String scooterСolor,
                                  String comment) {
        setFirstNameField(firstName);
        setLastNameFiled(lastName);
        setAddressFiled(address);
        setMetroField(metroStation);
        setPhoneField(phone);
        clickOnNextButton();
        setDate(date);
        setRentalPeriod(period);
        setScooterColor(scooterСolor);
        setCommentField(comment);
        clickOnOrderButton();
        clickOnYes();

        return this;
    }
}