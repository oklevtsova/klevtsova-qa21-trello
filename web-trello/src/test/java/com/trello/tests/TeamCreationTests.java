package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreationFromPlusButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA-21","descr qa21");
        clickContinueButton();

        Assert.assertTrue(isUserLoggedIn());
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

    public void clickXButton() {
    }

}
