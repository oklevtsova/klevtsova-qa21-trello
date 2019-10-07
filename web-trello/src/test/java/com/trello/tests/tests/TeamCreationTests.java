package com.trello.tests.tests;

import com.trello.tests.manager.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validTeams() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name", "description"});
        list.add(new Object[]{"NAME", "DESCRIPTION"});
        list.add(new Object[]{"134", "54656942"});
        list.add(new Object[]{"%$*^($&", "#@&^&^@#*@#"});
        list.add(new Object[]{"name", " "});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeamsfromcsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Team.csv")));
        String line = reader.readLine();
        while (line != null) {
String[]split = line.split(",");
list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});

            line = reader.readLine();
        }

        return list.iterator();
    }

    @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("o.klevtsova1@gmail.com", "25031992Klevtsova");
        }

    }

    @BeforeMethod
    public void isOnHomePage() {
        if (!app.getTeamHelper().isTherePersonalBoards()) {
            app.getTeamHelper().returnToHomePage();
        }
    }
    @Test(dataProvider = "validTeamsfromcsv")
   public void testTeamCreationFromPlusButtonOnHeaderWithDataProviderFromcsv(TeamData team){

        //int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();

        app.getTeamHelper().fillTeamCreationForm(team);
      app.getTeamHelper().clickContinueButton();
        if (!app.getTeamHelper().isElementPresent(By.cssSelector("._3okPZ1UgyOorbL"))) {
            app.getTeamHelper().returnToHomePage();
        }else{app.getTeamHelper().closeInviteToYourTeamButton();
        }
        app.getTeamHelper().returnToHomePage();
        //String createdTeamName = getTeamNameFromTeamPage();
       //int after = app.getTeamHelper().getTeamsCount();
      // Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

        // Assert.assertTrue(isUserLoggedIn());
    }

    @Test(dataProvider = "validTeams")
    public void testTeamCreationFromPlusButtonOnHeaderWithDataProvider(String teamName, String description) {
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();

        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        if (!app.getTeamHelper().isElementPresent(By.cssSelector("._3okPZ1UgyOorbL"))) {
            app.getTeamHelper().returnToHomePage();
        }else{app.getTeamHelper().closeInviteToYourTeamButton();
        }
        app.getTeamHelper().returnToHomePage();
        //String createdTeamName = getTeamNameFromTeamPage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

        // Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "QA21 - " + System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName(teamName).withDescription("descr qa21"));
        app.getTeamHelper().clickContinueButton();
        //String createdTeamName = getTeamNameFromTeamPage();
        if (!app.getTeamHelper().isElementPresent(By.cssSelector("._3okPZ1UgyOorbL"))) {
            app.getTeamHelper().returnToHomePage();
        }else{app.getTeamHelper().closeInviteToYourTeamButton();
        }
        app.getTeamHelper().returnToHomePage();

        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

        // Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("a").withDescription("b"));
        app.getTeamHelper().clickContinueButton();
        if (!app.getTeamHelper().isElementPresent(By.cssSelector("._3okPZ1UgyOorbL"))) {
            app.getTeamHelper().returnToHomePage();
        }else{app.getTeamHelper().closeInviteToYourTeamButton();
        }
        app.getTeamHelper().returnToHomePage();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        //  refreshPage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, "a");

    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromPlusButtonOnHeader() {
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("QA-21").withDescription("descr qa21"));
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().clickXButton();

        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        app.getTeamHelper().cleanTeams();
    }

}