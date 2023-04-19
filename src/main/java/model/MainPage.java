package model;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public static By faqButton0 = By.id("accordion__heading-0");
    public static By faqButton1 = By.id("accordion__heading-1");
    public static By faqButton2 = By.id("accordion__heading-2");
    public static By faqButton3 = By.id("accordion__heading-3");
    public static By faqButton4 = By.id("accordion__heading-4");
    public static By faqButton5 = By.id("accordion__heading-5");
    public static By faqButton6 = By.id("accordion__heading-6");
    public static By faqButton7 = By.id("accordion__heading-7");
    public static By faqPanel0 = By.id("accordion__panel-0");
    public static By faqPanel1 = By.id("accordion__panel-1");
    public static By faqPanel2 = By.id("accordion__panel-2");
    public static By faqPanel3 = By.id("accordion__panel-3");
    public static By faqPanel4 = By.id("accordion__panel-4");
    public static By faqPanel5 = By.id("accordion__panel-5");
    public static By faqPanel6 = By.id("accordion__panel-6");
    public static By faqPanel7 = By.id("accordion__panel-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean checkFAQPanel(By faqButton, By faqPanel, String faqData) {
        WebElement element = driver.findElement(faqButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(faqButton)).click();
        String text = driver.findElement(faqPanel).getText();
        return text.equals(faqData);
    }

}
