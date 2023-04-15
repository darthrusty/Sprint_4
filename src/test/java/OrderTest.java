import model.MainPage;
import model.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String metro;
    private final String length;
    private final String color;

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public OrderTest(String name, String surname, String address, String phone, String metro, String length, String color) {
        this.name    = name;
        this.surname = surname;
        this.address = address;
        this.phone   = phone;
        this.metro   = metro;
        this.length  = length;
        this.color   = color;
    }

    @Parameters
    public static Object[][] getData() {
        return new Object[][] {
             {"Имярек", "Имяреков", "улица имени Имярекова", "88888888888", "Бульвар Рокоссовского", "семеро суток", "black"},
             {"Имярек", "Имярекова", "проспект Имярековой", "77777777777", "Лихоборы", "сутки", "grey"}
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkTextFAQPannel() {
        boolean result;
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        result = orderPage.checkOrder(name, surname, address, phone, metro, length, color);
        Assert.assertTrue(result);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
