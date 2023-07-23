import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class HelloWorldSteps {

    private WebDriver driver;

    @Given("I am on the page {string}")
    public void iAmOnThePage(String url) {
        // Assuming you have set up the WebDriver executable path properly.
        // You need to download the WebDriver executable for the specific browser and set its path.
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");

        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("I should see the text {string} on the page")
    public void iShouldSeeTheTextOnThePage(String expectedText) {
        // Wait for the page to load (You can implement a proper wait mechanism if needed)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the element that contains the text "Hello World"
        boolean isTextPresent = driver.findElement(By.xpath("//*[contains(text(),'" + expectedText + "')]")).isDisplayed();
        
        // Assert that the text is visible on the page
        assertTrue("Text '" + expectedText + "' is not visible on the page.", isTextPresent);

        // Close the browser
        driver.quit();
    }
}
