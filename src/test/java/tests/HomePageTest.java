package tests;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void beforeTest(){
        loginPage.login(driver,loginPage);
    }

    @Test (priority = 1)
    public void checkHomeButton(){
        WebElement homeButton = driver.findElement(By.xpath(LandingPage.homeButton()));
        if(homeButton == null){
            Assert.fail();
        }
    }

    @Test (priority = 2)
    public void checkMyProfileButton(){
        WebElement myProfileButton = driver.findElement(By.xpath(LandingPage.myProfileButton()));
        if(myProfileButton == null){
            Assert.fail();
        }
    }

    @Test (priority = 3)
    public void checkRaiseSupportIssueButton(){
        WebElement raiseAnIssueButton = driver.findElement(By.xpath(LandingPage.raiseAnIssueButton()));
        if(raiseAnIssueButton == null){
            Assert.fail();
        }
    }

    @Test (priority = 4)
    public void checkTopicsButton(){
        WebElement topicsButton = driver.findElement(By.xpath(LandingPage.topicsButton()));
        if(topicsButton == null){
            Assert.fail();
        }
    }

    @Test (priority = 5)
    public void checkNotificationButton(){
        WebElement notificationButton = driver.findElement(By.xpath(LandingPage.notificationButton()));
        if(notificationButton == null){
            Assert.fail();
        }
    }

    @Test (priority = 6)
    public void checkProfileButton(){
        WebElement profileButton = driver.findElement(By.xpath(LandingPage.profileButton()));
        if(profileButton == null){
            Assert.fail();
        }
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

    @Test (priority = 8)
    public void checkMyFeedTabText(){
        String myFeedTab = driver.findElement(By.xpath(LandingPage.myFeedTab())).getText();
        Assert.assertEquals(myFeedTab, "MY FEED");
    }

    @Test (priority = 11)
    public void checkAskQuestionFooterText(){
        String askQuestionFooter = driver.findElement(By.xpath(LandingPage.askQuestionFooter())).getText();
        Assert.assertEquals(askQuestionFooter, "Ask a Question");
    }

    @Test (priority = 12)
    public void checkContactSupportFooterText(){
        String contactSupportFooter = driver.findElement(By.xpath(LandingPage.contactSupportFooter())).getText();
        Assert.assertEquals(contactSupportFooter, "Contact Support");
    }

    @Test (priority = 13)
    public void checkSearchBar(){
        WebElement searchBar = driver.findElement(By.xpath(LandingPage.searchBar()));
        if(searchBar == null){
            Assert.fail();
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

}