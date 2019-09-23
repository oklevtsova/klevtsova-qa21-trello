package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
    @Test
    public void deleteTeamFromLeftNavMenu(){
        int before = app.getTeamsCount();
        app.clickOnFirstTeam();
        app.openSettings();
        app.deleteTeam();
        app.returnToHomePage();
        app.refreshPage();

        int after = app.getTeamsCount();
        Assert.assertEquals(after, before-1);
    }

}
