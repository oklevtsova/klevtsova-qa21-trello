package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
@BeforeMethod
public void preconditions(){
    if(!app.getTeamHelper().isTeamsPresent()){
        app.getTeamHelper().createTeam();
    }
}
    @Test
    public void testRenameTeam() throws InterruptedException {

        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile("ab","asd");
        app.getTeamHelper().confirmEditTeam();

        Assert.assertEquals(app.getTeamHelper().getTeamNameFromTeamPage(),"ab");
    }
}
