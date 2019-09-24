//package com.trello.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.BrowserType;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TeamModificationTests extends TestBase {
//
//@BeforeMethod
//public void precondition(){
//    if(!app.getTeamHelper().isTeamsPresent()){
//        app.getTeamHelper().createTeam();
//    }
//}
//
//    @Test
//    public void testRenameTeam(){
//        clickOnFirstTeam();
//        openSettings();
//        initEditTeamProfile();
//        changeTeamProfile("hh","hha");
//        confirmEditTeam();
//    }
//
//    public void confirmEditTeam() {
//        click(By.cssSelector(".js-submit-profile"));
//    }
//
//    public void changeTeamProfile(String   name, String description) {
//        type(By.name("displayName"),name);
//        type(By.name("descr"),description);
//    }
//
//    public void initEditTeamProfile() {
//        click(By.cssSelector(".js-edit-profile"));
//        //waitForElementAndClick(By.cssSelector(".js-edit-profile"),10);
//    }
//    public void init(){
//        String browser = null;
//        if(browser.equals(BrowserType.CHROME)){
//            driver=new ChromeDriver();
//        }if (browser.equals(BrowserType.FIREFOX)){
//            driver = new FirefoxDriver();
//        }
//    }
//
//}
