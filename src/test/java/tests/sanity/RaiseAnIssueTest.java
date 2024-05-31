package tests.sanity;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.example.locators.RaiseAnIssue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RaiseAnIssueTest {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("FireFox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        else if(browser.equalsIgnoreCase("Edge")){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }
        else{
            throw new Exception("Browser is not correct");
        }

        loginPage.login(driver,loginPage);
        driver.findElement(By.xpath(LandingPage.RaiseAnIssueTab())).click();
    }

    @Test (priority = 1)
    public void contactCustomerSupportText(){
        String ContactCustomerSupport = driver.findElement(By.xpath(RaiseAnIssue.contactCustomerSupport())).getText();
        Assert.assertEquals(ContactCustomerSupport, "Contact Customer Support");
    }

    @Test (priority = 2)
    public void needAnswersFastText(){
        String needAnswersFast = driver.findElement(By.xpath(RaiseAnIssue.needAnswersFast())).getText();
        Assert.assertEquals(needAnswersFast, "Need Answers Fast?");
    }

    @Test (priority = 3)
    public void caseOriginText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.caseOrigin())).getText();
        Assert.assertEquals(caseOrigin, "Case Origin");
    }

    @Test (priority = 4)
    public void caseOriginDropDown(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.caseOriginDropdown())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 5)
    public void caseReasonText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.caseReason())).getText();
        Assert.assertEquals(caseOrigin, "Case Reason");
    }

    @Test (priority = 6)
    public void caseReasonDropDown(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.caseReasonDropDown())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 7)
    public void productText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.product())).getText();
        Assert.assertEquals(caseOrigin, "Product");
    }

    @Test (priority = 8)
    public void productDropdown(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.productDropdown())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 9)
    public void subjectText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.subject())).getText();
        Assert.assertEquals(caseOrigin, "Subject");
    }

    @Test (priority = 10)
    public void subjectTextBox(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.subjectTextBox())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 11)
    public void descriptionText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.description())).getText();
        Assert.assertEquals(caseOrigin, "Description");
    }

    @Test (priority = 12)
    public void descriptionTextBox(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.descriptionTextBox())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 13)
    public void priorityText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.priority())).getText();
        Assert.assertEquals(caseOrigin, "Priority");
    }

    @Test (priority = 14)
    public void priorityDropDown(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.priorityDropDown())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 15)
    public void escalatedText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.escalated())).getText();
        Assert.assertEquals(caseOrigin, "Escalated");
    }

    @Test (priority = 16)
    public void escalatedCheckBox(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.escalatedCheckBox())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 17)
    public void statusText(){
        String caseOrigin = driver.findElement(By.xpath(RaiseAnIssue.status())).getText();
        Assert.assertEquals(caseOrigin, "Status");
    }

    @Test (priority = 18)
    public void statusDropDown(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.statusDropDown())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 19)
    public void uploadFileLink(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.uploadFileLink())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 20)
    public void submitButton(){
        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.submitButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
