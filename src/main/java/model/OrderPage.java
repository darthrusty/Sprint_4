package model;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;
    private By maiPageOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By fieldName = By.xpath(".//input[@placeholder = '* Имя']");
    private By fieldSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By fieldAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By fieldPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By fieldMetro = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By fistConfirmOrderButton = By.xpath(".//button[text() = 'Далее']");
    private By secondConfimOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By thirdConfirmOrderButton = By.xpath(".//div[text() = 'Да']");
    private By fieldComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By fieldDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By fieldCalendar = By.xpath(".//div[@class = 'react-datepicker__month-container']");
    private By fieldLength = By.xpath(".//div[@class = 'Dropdown-control']");
    private By fieldConfirmed = By.xpath(".//div[text() = 'Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public void checkStartingOrder () {
        WebElement elementMaiPageOrderButton = driver.findElement(maiPageOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementMaiPageOrderButton);
        elementMaiPageOrderButton.click();
    }

    public void checkFillPersonalFields(String name, String surname, String address, String metro, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(fieldName)).sendKeys(name);
        driver.findElement(fieldSurname).sendKeys(surname);
        driver.findElement(fieldAdress).sendKeys(address);
        driver.findElement(fieldPhone).sendKeys(phone);
        driver.findElement(fieldMetro).sendKeys(metro);
        driver.findElement(fieldMetro).sendKeys(Keys.DOWN);
        driver.findElement(fieldMetro).sendKeys(Keys.ENTER);
        driver.findElement(fistConfirmOrderButton).click();
    }

    public void checkFillScooterFields(String length, String color) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(fieldComment)).sendKeys("");
        driver.findElement(fieldDate).click();
        driver.findElement(fieldCalendar).click();
        driver.findElement(fieldLength).click();
        WebElement elementLength = driver.findElement(By.xpath(".//div[text() = '" + length + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementLength);
        elementLength.click();
        driver.findElement(By.id(color)).click();
        driver.findElement(secondConfimOrderButton).click();
    }
        public boolean checkConfirmation() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(thirdConfirmOrderButton)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(fieldConfirmed));
        String text = driver.findElement(fieldConfirmed).getText();
        return text.equals("Заказ оформлен");
    }


}
