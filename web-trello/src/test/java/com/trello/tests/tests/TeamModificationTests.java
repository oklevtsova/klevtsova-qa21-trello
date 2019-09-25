package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {

    @Test
    public void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile("hh"," dfg");
        app.getTeamHelper().confirmEditTeam();

        Assert.assertEquals(app.getTeamHelper().getTeamNameFromTeamPage(),"hh");

    }


    }
//    public void init(){
//        String browser = null;
//        if(browser.equals(BrowserType.CHROME)){
//            driver=new ChromeDriver();
//        }if (browser.equals(BrowserType.FIREFOX)){
//            driver = new FirefoxDriver();
//        }
//    }

