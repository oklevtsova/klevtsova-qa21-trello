package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase {

//    @DataProvider
//    public Iterator<Object[]>validTeams(){
//        List<Object> list = new ArrayList<>();
//        list.add(new Object[]{"name","description"});
//        list.add(new Object[]{"NAME","DESCRIPTION"});
//        list.add(new Object[]{"134","54656942"});
//        list.add(new Object[]{"%$*^($&","#@&^&^@#*@#"});
//        list.add(new Object[]{"name"," "});
//
//        return list.listIterator();
//    }

    @BeforeClass
    public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }

    }
     @BeforeMethod
     public void isOnHomePage(){
        if(!app.getTeamHelper().isTherePersonalBoards()){
            app.getTeamHelper().returnToHomePage();
        }
     }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "QA21 - " + System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(teamName,"descr qa21");
        app.getTeamHelper().clickContinueButton();
        //String createdTeamName = getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

       // Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm("a","b");
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
      //  refreshPage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName,"a");

    }

    @Test(enabled=false)
    public void testTeamCancelCreationFromPlusButtonOnHeader(){
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm("QA-21","descr qa21");
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().clickXButton();

        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
    }
    @AfterClass
    public void postActions()throws InterruptedException{
        app.getTeamHelper().cleanTeams();
    }


}
