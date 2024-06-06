package org.example.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Loginpage2 {

    public String userName(){
        return "//*[@id=\"48:2;a\"]";
    }
    public String Password(){
        return "//*[@id=\"48:2;a\"]";
    }
    public String loginButton() { return "//*[@id=\"centerPanel\"]///*[@id=\"centerPanel\"]/div/div[2]/div/div[2]/div/div[3]/button";}

        pubic void login(WebDriver driver){
        driver.get("https://brave-unicorn-kbiupz-dev-ed.trailblaze.my.site.com/s/login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement userName= driver.findElement(By.xpath(LoginPage.userName()));
        userName.sendKeys("anjali.narayanan@platotech.com");

        WebElement password= driver.findElement(By.xpath(loginPage.userName()));
        userName.sendKeys("Anjali@12345");

        WebElement loginButton= driver.findElement(By.xpath(loginPage.loginButton()));
        loginButton.click();
    }
}
