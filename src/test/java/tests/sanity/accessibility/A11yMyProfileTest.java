package tests.sanity.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class A11yMyProfileTest {
    AxeBuilder axeBuilder = new AxeBuilder();
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void myProfilePage() throws JsonProcessingException {
        Results axeResults;

        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, loginPage);
        driver.findElement(By.xpath(LandingPage.myProfileButton())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        axeResults = axeBuilder.analyze(driver);
        List<Rule> violations = axeResults.getViolations();
        if (!axeResults.violationFree()) {
            ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonReport = writer.writeValueAsString(violations);
            System.out.println(jsonReport);
            Assert.fail();
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
