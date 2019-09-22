package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!isUserLoggedIn()){
            login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = getPersonalBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm("QA-21", "descr");
        confirmBoardCreation();
        returnToHomePage();
        int afterCreation = getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
