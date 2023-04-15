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

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean checkFAQPanel(String faqButton, String faqPanel, String faqData) {
        WebElement element = driver.findElement(By.id(faqButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id(faqButton))).click();
        String text = driver.findElement(By.id(faqPanel)).getText();
        return text.equals(faqData);
    }

}
