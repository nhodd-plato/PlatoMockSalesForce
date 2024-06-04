package tests.sanity.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class A11yLoginTest {

    AxeBuilder axeBuilder = new AxeBuilder();
    WebDriver driver = new ChromeDriver();

    @Test (priority = 1)
    public void loginPage() throws JsonProcessingException {
        Results axeResults;

        driver.get("https://brave-unicorn-kbiupz-dev-ed.trailblaze.my.site.com/s/login/");

        axeResults = axeBuilder.analyze(driver);
        List<Rule> violations = axeResults.getViolations();
        if(!axeResults.violationFree()){
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
