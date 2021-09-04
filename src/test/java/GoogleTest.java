import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

/**
 * @author Seva Nardin
 */
public class GoogleTest {
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // автоматизация управления драйверами
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/home/seva/chromedriver");
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void test1() {
        driver.get( "https://www.google.ru/" );
        String txt = driver.getTitle();

        Assertions.assertEquals( "Google", txt );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
