package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.isUserLoggedIn()){
            app.login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }

    }
     @BeforeMethod
     public void isOnHomePage(){
        if(!app.isTherePersonalBoards()){
            app.returnToHomePage();
        }
     }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        String teamName = "QA21 - " + System.currentTimeMillis();
        app.fillTeamCreationForm(teamName,"descr qa21");
        app.clickContinueButton();
        //String createdTeamName = getTeamNameFromTeamPage();
        app.returnToHomePage();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

       // Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnLeftNavMenu();
        app.fillTeamCreationForm("a","b");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        app.returnToHomePage();
      //  refreshPage();
        int after = app.getTeamsCount();

        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName,"a");

    }

    @Test(enabled=false)
    public void testTeamCancelCreationFromPlusButtonOnHeader(){
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("QA-21","descr qa21");
        app.clickContinueButton();
        app.clickXButton();

        Assert.assertTrue(app.isUserLoggedIn());
    }
    @AfterClass
    public void postActions()throws InterruptedException{
        app.cleanTeams();
    }


}
