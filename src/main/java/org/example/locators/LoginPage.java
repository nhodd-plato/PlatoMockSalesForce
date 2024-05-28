package org.example.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage{

    public String userName(){
        return "//*[@id=\"48:2;a\"]";
    }

    public String password(){
        return "//*[@id=\"61:2;a\"]";
    }

    public String loginButton(){
        return "//*[@id=\"centerPanel\"]/div/div[2]/div/div[2]/div/div[3]/button";
    }

    public void login(WebDriver driver, LoginPage loginPage){
        driver.get("https://brave-unicorn-kbiupz-dev-ed.trailblaze.my.site.com/s/login/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement userName = driver.findElement(By.xpath(loginPage.userName()));
        userName.sendKeys("nick.hodd@platotech.com");

        WebElement password = driver.findElement(By.xpath(loginPage.password()));
        password.sendKeys("<password>");

        WebElement loginButton = driver.findElement(By.xpath(loginPage.loginButton()));
        loginButton.click();
    }

}
