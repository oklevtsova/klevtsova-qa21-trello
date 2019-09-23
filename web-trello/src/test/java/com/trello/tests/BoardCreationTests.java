package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.isUserLoggedIn()){
            app.login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = app.getPersonalBoardsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateBoardFromDropDown();
        app.fillBoardCreationForm("QA-21", "descr");
        app.confirmBoardCreation();
        app.returnToHomePage();
        int afterCreation = app.getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
