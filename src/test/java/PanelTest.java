import model.MainPage;
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

@RunWith(Parameterized.class)
public class PanelTest {

    private WebDriver driver;

    private static By faqButton0 = By.id("accordion__heading-0");
    private static By faqButton1 = By.id("accordion__heading-1");
    private static By faqButton2 = By.id("accordion__heading-2");
    private static By faqButton3 = By.id("accordion__heading-3");
    private static By faqButton4 = By.id("accordion__heading-4");
    private static By faqButton5 = By.id("accordion__heading-5");
    private static By faqButton6 = By.id("accordion__heading-6");
    private static By faqButton7 = By.id("accordion__heading-7");
    private static By faqPanel0 = By.id("accordion__panel-0");
    private static By faqPanel1 = By.id("accordion__panel-1");
    private static By faqPanel2 = By.id("accordion__panel-2");
    private static By faqPanel3 = By.id("accordion__panel-3");
    private static By faqPanel4 = By.id("accordion__panel-4");
    private static By faqPanel5 = By.id("accordion__panel-5");
    private static By faqPanel6 = By.id("accordion__panel-6");
    private static By faqPanel7 = By.id("accordion__panel-7");

    private final By faqButton;
    private final By faqPanel;
    private final String faqData;

    public PanelTest(By faqButton, By faqPanel, String faqData) {
        this.faqButton = faqButton;
        this.faqPanel  = faqPanel;
        this.faqData   = faqData;
    }

    @Parameters(name = "Проверка Вопросов о важном. Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        return new Object[][] {
            {faqButton0, faqPanel0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {faqButton1, faqPanel1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {faqButton2, faqPanel2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {faqButton3, faqPanel3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {faqButton4, faqPanel4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {faqButton5, faqPanel5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {faqButton6, faqPanel6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {faqButton7, faqPanel7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
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
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        result = mainPage.checkFAQPanel(faqButton, faqPanel, faqData);
        Assert.assertTrue(result);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
