package org.example.locators;

public class LandingPage{

    public static String homeButton(){
        return "//*[@id=\"0\"]";
    }

    public static String myProfileButton(){
        return "//*[@id=\"1\"]";
    }

    public static String raiseAnIssueButton(){
        return "//*[@id=\"2\"]";
    }

    public static String topicsButton(){
        return "//*[@id=\"3\"]";
    }

    public static String searchButton(){
        return "/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[1]/div/div[1]/button/lightning-primitive-icon";
    }

    public static String notificationButton(){
        return "/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[1]/div/div[1]/button";
    }

    public static String profileButton(){
        return "/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[3]/div/div/div/community_user-user-profile-menu/div/button/div/div[1]";
    }

    public static String pageTitle(){ return "/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div/div/h2"; }


}