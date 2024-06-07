package userflows;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.example.locators.MyProfile;
import org.example.locators.RaiseAnIssue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RaiseAnIssueFormTest {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(driver, loginPage);
        driver.findElement(By.xpath(LandingPage.RaiseAnIssueTab())).click();
    }

    @Test(priority = 1)
    public void saveWithoutRequiredFields() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expected = "Review the errors on this page.";
        driver.findElement(By.xpath(RaiseAnIssue.submitButton())).click();
        String actual = driver.findElement(By.xpath(RaiseAnIssue.errorMessage())).getText();
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2)
    public void validCaseSuccess(){
        String successCaseNumber;
        String myProfileCaseNumber;

        driver.findElement(By.xpath(RaiseAnIssue.caseOriginDropdown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.caseOriginPhone())).click();

        driver.findElement(By.xpath(RaiseAnIssue.caseReasonDropDown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.caseReasonInstallation())).click();

        driver.findElement(By.xpath(RaiseAnIssue.productDropdown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.productDropdownLaptop())).click();

        driver.findElement(By.xpath(RaiseAnIssue.descriptionTextBox())).sendKeys("Test");

        driver.findElement(By.xpath(RaiseAnIssue.submitButton())).click();

        boolean isPresent = !driver.findElements(By.xpath(RaiseAnIssue.caseSuccessfullyCreated())).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        successCaseNumber = driver.findElement(By.xpath(RaiseAnIssue.caseNumber())).getText();

        driver.findElement(By.xpath(LandingPage.myProfileButton())).click();
        driver.findElement(By.xpath(MyProfile.casesTab())).click();

        myProfileCaseNumber = driver.findElement(By.xpath(MyProfile.caseNumber())).getText();

        Assert.assertTrue(isPresent);
        Assert.assertEquals(myProfileCaseNumber,successCaseNumber);
    }

    /*
    If case reason is performance or feedback,
    case owner should be assigned to People Manager Queue
    */
    @Test(priority = 3)
    public void validCaseOwner(){
        String expectedCaseOwner = "People Manager Queue";
        String actualCaseOwner;
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.findElement(By.xpath(LandingPage.RaiseAnIssueTab())).click();

        driver.findElement(By.xpath(RaiseAnIssue.caseOriginDropdown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.caseOriginPhone())).click();

        driver.findElement(By.xpath(RaiseAnIssue.caseReasonDropDown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.caseReasonPerformance())).click();

        driver.findElement(By.xpath(RaiseAnIssue.productDropdown())).click();
        driver.findElement(By.xpath(RaiseAnIssue.productDropdownLaptop())).click();

        driver.findElement(By.xpath(RaiseAnIssue.descriptionTextBox())).sendKeys("Test");

        driver.findElement(By.xpath(RaiseAnIssue.submitButton())).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.findElement(By.xpath(RaiseAnIssue.successPopUpCancel())).click();

        driver.findElement(By.xpath(LandingPage.myProfileButton())).click();
        driver.findElement(By.xpath(MyProfile.casesTab())).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        /*
        This test isn't working, I'm not sure the best way to wait for the newly
        populated case in the case tab. Even if I force a page refresh it doesn't show up
        */

        //wait.until(ExpectedConditions.textToBe(By.xpath(RaiseAnIssue.caseOwner()), expectedCaseOwner));

        actualCaseOwner = driver.findElement(By.xpath(RaiseAnIssue.caseOwner())).getText();

        Assert.assertEquals(actualCaseOwner, expectedCaseOwner);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
