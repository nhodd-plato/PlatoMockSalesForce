package tests.sanity;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.example.locators.MyProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

/*
 This file contains an aesthetic tests for My Profile page
*/
public class MyProfileTest {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    /*
     This method allows the suites.xml file to run these tests on multiple browsers
     (if browser isn't specified, it defaults to Chrome)
    */
    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("browser") String browser){
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
            driver = new ChromeDriver(); //default browser
        }

        loginPage.login(driver,loginPage);
        driver.findElement(By.xpath(LandingPage.myProfileButton())).click();
    }

    @Test (priority = 1)
    public void profileIcon(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement profileIcon = driver.findElement(By.xpath(MyProfile.profileIcon()));
        if(profileIcon == null){
            Assert.fail();
        }
    }

    @Test (priority = 2)
    public void editButton(){
        String editButton = driver.findElement(By.xpath(MyProfile.editButton())).getText();
        Assert.assertEquals(editButton, "Edit");
    }

    @Test (priority = 3)
    public void influenceText(){
        String influence = driver.findElement(By.xpath(MyProfile.influence())).getText();
        Assert.assertEquals(influence, "Influence");
    }

    @Test (priority = 4)
    public void groupsText(){
        String groups = driver.findElement(By.xpath(MyProfile.groups())).getText();
        Assert.assertEquals(groups, "Groups");
    }

    @Test (priority = 5)
    public void filesText(){
        String files = driver.findElement(By.xpath(MyProfile.files())).getText();
        Assert.assertEquals(files, "Files");
    }

    @Test (priority = 6)
    public void followersText(){
        String followers = driver.findElement(By.xpath(MyProfile.followers())).getText();
        Assert.assertEquals(followers, "Followers");
    }

    @Test (priority = 7)
    public void followingText(){
        String following = driver.findElement(By.xpath(MyProfile.following())).getText();
        Assert.assertEquals(following, "Following");
    }

    @Test (priority = 8)
    public void feedTabText(){
        String feedTab = driver.findElement(By.xpath(MyProfile.feedTab())).getText();
        Assert.assertEquals(feedTab, "FEED");
    }

    @Test (priority = 9)
    public void postSubTabText(){
        String postSubTab = driver.findElement(By.xpath(MyProfile.postSubTab())).getText();
        Assert.assertEquals(postSubTab, "Post");
    }

    @Test (priority = 10)
    public void postSubTabTextbox(){
        String postSubTabShareAnUpdate = driver.findElement(By.xpath(MyProfile.postSubTabShareAnUpdate())).getText();
        Assert.assertEquals(postSubTabShareAnUpdate, "Share an update...");
    }

    @Test (priority = 11)
    public void postSubTabShareButton(){
        String postSubTabShareButton = driver.findElement(By.xpath(MyProfile.postSubTabShareButton())).getText();
        Assert.assertEquals(postSubTabShareButton, "Share");
    }

    @Test (priority = 12)
    public void pollSubTabText(){
        String pollSubTab = driver.findElement(By.xpath(MyProfile.pollSubTab())).getText();
        driver.findElement(By.xpath(MyProfile.pollSubTab())).click();
        Assert.assertEquals(pollSubTab, "Poll");
    }

    @Test (priority = 13)
    public void pollSubTabChoiceOne(){
        String pollSubTabChoiceOne = driver.findElement(By.xpath(MyProfile.pollSubTabChoiceOne())).getText();
        Assert.assertEquals(pollSubTabChoiceOne, "Choice 1");
    }

    @Test (priority = 14)
    public void pollSubTabChoiceTwo(){
        String pollSubTabChoiceTwo = driver.findElement(By.xpath(MyProfile.pollSubTabChoiceTwo())).getText();
        Assert.assertEquals(pollSubTabChoiceTwo, "Choice 2");
    }

    @Test (priority = 15)
    public void pollSubTabAddChoiceButton(){
        String pollSubAddChoiceButton = driver.findElement(By.xpath(MyProfile.pollSubAddChoiceButton())).getText();
        Assert.assertEquals(pollSubAddChoiceButton, "Add new choice");
    }

    @Test (priority = 16)
    public void pollSubTabAskButton(){
        String pollSubTabAskButton = driver.findElement(By.xpath(MyProfile.pollSubTabAskButton())).getText();
        driver.findElement(By.xpath(MyProfile.pollSubTab())).click();
        Assert.assertEquals(pollSubTabAskButton, "Ask");
    }

    @Test (priority = 17)
    public void questionSubTabText(){
        String questionSubTab = driver.findElement(By.xpath(MyProfile.questionSubTab())).getText();
        driver.findElement(By.xpath(MyProfile.questionSubTab())).click();
        Assert.assertEquals(questionSubTab, "Question");
    }

    @Test (priority = 18)
    public void questionSubTabQuestionText(){
        String questionSubTabQuestion = driver.findElement(By.xpath(MyProfile.questionSubTabQuestion())).getText();
        Assert.assertEquals(questionSubTabQuestion, "Question (Enter up to 255 characters)");
    }

    @Test (priority = 19)
    public void questionSubTabDetailsText(){
        String questionSubTabDetails = driver.findElement(By.xpath(MyProfile.questionSubTabDetails())).getText();
        Assert.assertEquals(questionSubTabDetails, "Details");
    }

    @Test (priority = 19)
    public void questionSubTabAskButton(){
        String questionSubTabAskButton = driver.findElement(By.xpath(MyProfile.questionSubTabAskButton())).getText();
        Assert.assertEquals(questionSubTabAskButton, "Ask");
    }

    @Test (priority = 20)
    public void casesTabText(){
        String casesTab = driver.findElement(By.xpath(MyProfile.casesTab())).getText();
        driver.findElement(By.xpath(MyProfile.casesTab())).click();
        Assert.assertEquals(casesTab, "CASES");
    }

    @Test (priority = 21)
    public void casesTabMyCases(){
        String myCases = driver.findElement(By.xpath(MyProfile.myCases())).getText();
        Assert.assertEquals(myCases, "My Cases");
    }

    @Test (priority = 22)
    public void casesTabCreateCaseLinkText(){
        String createCaseLink = driver.findElement(By.xpath(MyProfile.createCaseLink())).getText();
        Assert.assertEquals(createCaseLink, "Create Case");
    }

    @Test (priority = 23)
    public void casesTabCaseNumber(){
        String casesNumber = driver.findElement(By.xpath(MyProfile.casesNumberText())).getText();
        Assert.assertTrue(casesNumber.contains("Case Number"));
    }

    @Test (priority = 24)
    public void casesTabContactName(){
        String contactName = driver.findElement(By.xpath(MyProfile.contactName())).getText();
        Assert.assertTrue(contactName.contains("Contact Name"));
    }

    @Test (priority = 25)
    public void casesTabSubject(){
        String subject = driver.findElement(By.xpath(MyProfile.subject())).getText();
        Assert.assertTrue(subject.contains( "Subject"));
    }

    @Test (priority = 26)
    public void casesTabStatus(){
        String status = driver.findElement(By.xpath(MyProfile.status())).getText();
        Assert.assertTrue(status.contains("Status"));
    }

    @Test (priority = 27)
    public void casesTabPriority(){
        String priority = driver.findElement(By.xpath(MyProfile.priority())).getText();
        Assert.assertTrue(priority.contains("Priority"));
    }

    @Test (priority = 28)
    public void casesTabDate(){
        String date = driver.findElement(By.xpath(MyProfile.date())).getText();
        Assert.assertTrue(date.contains("Date/Time Opened"));
    }

    @Test (priority = 29)
    public void casesTabCaseOwner(){
        String caseOwner = driver.findElement(By.xpath(MyProfile.caseOwner())).getText();
        Assert.assertTrue(caseOwner.contains( "Case Owner Alias"));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
