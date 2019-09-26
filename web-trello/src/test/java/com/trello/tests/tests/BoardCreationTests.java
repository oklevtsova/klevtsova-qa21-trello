package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();

        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm("QA-21", "descr");
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper() .getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
