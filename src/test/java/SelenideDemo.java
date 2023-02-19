import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author Seva Nardin
 */
public class SelenideDemo {
    @Test
    void test() {
        open( "https://www.google.ru/" );
    }

}
