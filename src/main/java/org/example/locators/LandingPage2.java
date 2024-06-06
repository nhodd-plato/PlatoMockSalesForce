package org.example.locators;

public class LandingPage2 {

    public static String homeButton() { return "//*[@id=\"0\"]"; }

    public static String myProfileButton() { return "//*[@id=\"1\"]"; }

    public static String raiseAnIssueButton() {return "//*[@id=\"2\"]"; }

    public static String topicsButton() {return "//*[@id=\"3\"]";}

    public static String notificationButton() {
        return "/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[1]/div/div[1]/button/";

    }
    public static String profileButton(){
        return "/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[2]/div/div/div/community_user-user-profile-menu/div/button/div/div/span/img";
    }

    public static String pageSubtitle(){
        return "/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div/div/h2";

    }

    public static String featureTab(){
        return "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/ul/li[1]/a/span[2]";
    }

    public static String discussionsTab(){
        return "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/ul/li[2]/a/span[2]";
    }

    public static String myFeedTab(){
        return "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div/ul/li[3]/a/span[2]";
    }
    public static String askQuestionFooter()
    {
        return "//*[@id=\"askCommunity\"]/button";
    }
    public static String contactSupportFooter(){
        return "//*[@id=\"contactSupport\"]/button";
    }

    public static String pageTitle(){
        return "/html/body/div[3]/div[1]/div[2]/div/div/div/div[3]/div/div/h2";
    }

    public static String searchBar() {
        return "//*[@id=\"129:0-input\"]";
    }
}