import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HelloWorldStepDefs {
    private WebDriver driver;

    @Given("I open the URL {string}")
    public void iOpenTheURL(String url) {
        // Set up the WebDriver with ChromeOptions to run headless (no UI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @Then("I should see the text {string}")
    public void iShouldSeeTheText(String expectedText) {
        String pageSource = driver.getPageSource();
        assertTrue("The text \"" + expectedText + "\" was not found on the page.", pageSource.contains(expectedText));
        driver.quit();
    }
}
