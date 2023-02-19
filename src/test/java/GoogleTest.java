import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Seva Nardin
 */
public class GoogleTest {
    private WebDriver driver;
    Logger logger = LoggerFactory.getLogger(GoogleTest.class);

    @BeforeAll
    static void setupClass() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browser = "chrome";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void test1() throws InterruptedException {
        open( "https://www.google.ru/" );
        boolean result = $(By.name("q")).isDisplayed();
        Thread thread = new Thread(() -> System.out.println("Hello!"));

        thread.run();

        Assertions.assertTrue( result );
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
