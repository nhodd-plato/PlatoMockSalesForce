package tests;

import org.example.locators.LandingPage;
import org.example.locators.LoginPage;
import org.example.locators.MyProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyProfileTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void beforeTest(){
        loginPage.login(driver,loginPage);
        driver.findElement(By.xpath(LandingPage.myProfileButton())).click();
    }

    @Test (priority = 1)
    public void checkProfileIcon(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement profileIcon = driver.findElement(By.xpath(MyProfile.profileIcon()));
        if(profileIcon == null){
            Assert.fail();
        }
    }

    @Test (priority = 2)
    public void checkEditButton(){
        String editButton = driver.findElement(By.xpath(MyProfile.editButton())).getText();
        Assert.assertEquals(editButton, "Edit");
    }

    @Test (priority = 3)
    public void checkInfluenceText(){
        String influence = driver.findElement(By.xpath(MyProfile.influence())).getText();
        Assert.assertEquals(influence, "Influence");
    }

    @Test (priority = 4)
    public void checkGroupsText(){
        String groups = driver.findElement(By.xpath(MyProfile.groups())).getText();
        Assert.assertEquals(groups, "Groups");
    }

    @Test (priority = 5)
    public void checkFilesText(){
        String files = driver.findElement(By.xpath(MyProfile.files())).getText();
        Assert.assertEquals(files, "Files");
    }

    @Test (priority = 6)
    public void checkFollowersText(){
        String followers = driver.findElement(By.xpath(MyProfile.followers())).getText();
        Assert.assertEquals(followers, "Followers");
    }

    @Test (priority = 7)
    public void checkFollowingText(){
        String following = driver.findElement(By.xpath(MyProfile.following())).getText();
        Assert.assertEquals(following, "Following");
    }

    @Test (priority = 8)
    public void checkFeedTabText(){
        String feedTab = driver.findElement(By.xpath(MyProfile.feedTab())).getText();
        Assert.assertEquals(feedTab, "FEED");
    }

    @Test (priority = 9)
    public void checkPostSubTabText(){
        String postSubTab = driver.findElement(By.xpath(MyProfile.postSubTab())).getText();
        Assert.assertEquals(postSubTab, "Post");
    }

    @Test (priority = 10)
    public void checkPollSubTabText(){
        String pollSubTab = driver.findElement(By.xpath(MyProfile.pollSubTab())).getText();
        Assert.assertEquals(pollSubTab, "Poll");
    }

    @Test (priority = 11)
    public void checkQuestionSubTabText(){
        String questionSubTab = driver.findElement(By.xpath(MyProfile.questionSubTab())).getText();
        Assert.assertEquals(questionSubTab, "Question");
    }

    @Test (priority = 12)
    public void checkCasesTabText(){
        String casesTab = driver.findElement(By.xpath(MyProfile.casesTab())).getText();
        driver.findElement(By.xpath(MyProfile.casesTab())).click();
        Assert.assertEquals(casesTab, "CASES");
    }

    @Test (priority = 13)
    public void checkCreateCaseLinkText(){
        String createCaseLink = driver.findElement(By.xpath(MyProfile.createCaseLink())).getText();
        Assert.assertEquals(createCaseLink, "Create Case");
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
