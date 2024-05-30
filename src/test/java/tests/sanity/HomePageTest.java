package tests.sanity;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomePageTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void beforeTest(){
        loginPage.login(driver,loginPage);
    }

    @Test (priority = 1)
    public void checkHomeButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.homeButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 2)
    public void checkMyProfileButton(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.myProfileButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 3)
    public void checkRaiseSupportIssueButton(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.raiseAnIssueButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (enabled = false, priority = 4)
    public void checkTopicsButton(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.topicsButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 5)
    public void checkNotificationButton(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.notificationButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 6)
    public void checkProfileButton(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.profileButton())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @Test (priority = 7)
    public void checkTitleText(){
        String title = driver.findElement(By.xpath(LandingPage.pageTitle())).getText();
        Assert.assertEquals(title, "What can we help you with?");
    }

    @Test (priority = 8)
    public void checkSubTitleText(){
        String subTitle = driver.findElement(By.xpath(LandingPage.pageSubtitle())).getText();
        Assert.assertEquals(subTitle, "We are here to assist you!");
    }

    @Test (priority = 9)
    public void checkFeaturedTabText(){
        String featuredTab = driver.findElement(By.xpath(LandingPage.featuredTab())).getText();
        Assert.assertEquals(featuredTab, "FEATURED");
    }

    @Test (priority = 10)
    public void checkDiscussionsTabText(){
        String discussionsTab = driver.findElement(By.xpath(LandingPage.discussionsTab())).getText();
        Assert.assertEquals(discussionsTab, "DISCUSSIONS");
    }

    @Test (priority = 11)
    public void checkMyFeedTabText(){
        String myFeedTab = driver.findElement(By.xpath(LandingPage.myFeedTab())).getText();
        Assert.assertEquals(myFeedTab, "MY FEED");
    }

    @Test (priority = 12)
    public void checkAskQuestionFooterText(){
        String askQuestionFooter = driver.findElement(By.xpath(LandingPage.askQuestionFooter())).getText();
        Assert.assertEquals(askQuestionFooter, "Ask a Question");
    }

    @Test (priority = 13)
    public void checkContactSupportFooterText(){
        String contactSupportFooter = driver.findElement(By.xpath(LandingPage.contactSupportFooter())).getText();
        Assert.assertEquals(contactSupportFooter, "Contact Support");
    }

    @Test (priority = 14)
    public void checkSearchBar(){
        boolean isPresent = !driver.findElements(By.xpath(LandingPage.searchBar())).isEmpty();
        Assert.assertTrue(isPresent);
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

}