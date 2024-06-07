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

/*
 This file contains an accessibility scan for the login page
*/
public class A11yLoginTest {

    AxeBuilder axeBuilder = new AxeBuilder();
    WebDriver driver = new ChromeDriver();

    /*
     This test uses the axe core library to scan the page for accessibility violations.
     If the page is not violation free, the violations will be displayed in the console
     and the test will fail.
    */
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
