package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class TC001_Scenario {
    WebDriver driver;

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Then("the results page should show results")
    public void the_results_page_should_show_results() {
        System.out.println("Results: " + driver.getTitle());
        driver.quit();
    }
}

