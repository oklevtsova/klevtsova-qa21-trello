package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!isUserLoggedIn()){
            login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }

    }
     @BeforeMethod
     public void isOnHomePage(){
        if(!isTherePersonalBoards()){
            returnToHomePage();
        }
     }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "QA21 - " + System.currentTimeMillis();
        fillTeamCreationForm(teamName,"descr qa21");
        clickContinueButton();
        //String createdTeamName = getTeamNameFromTeamPage();
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

       // Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnLeftNavMenu();
        fillTeamCreationForm("a","b");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHomePage();
      //  refreshPage();
        int after = getTeamsCount();

        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName,"a");

    }

    @Test(enabled=false)
    public void testTeamCancelCreationFromPlusButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA-21","descr qa21");
        clickContinueButton();
        clickXButton();

        Assert.assertTrue(isUserLoggedIn());
    }


}
