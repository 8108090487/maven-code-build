package stepdefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentReportManager;


public class TC001_Scenario {
    WebDriver driver;
    ExtentReports extent = ExtentReportManager.setupReport();
    ExtentTest test = extent.createTest("Google Search Test");

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
        test.info("Navigating to Google homepage...");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
        test.info("Searching for: " + query);

    }

    @Then("the results page should show results")
    public void the_results_page_should_show_results() {
        System.out.println("Results: " + driver.getTitle());
        driver.quit();
        test.pass("Results page displayed successfully!");

    }

    @After
    public void tearDown() {
        extent.flush(); // Save the report
    }
}

