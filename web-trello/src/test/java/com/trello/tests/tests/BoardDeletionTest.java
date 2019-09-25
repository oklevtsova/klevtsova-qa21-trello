package com.trello.tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void BoardDeletion() throws InterruptedException {
        int before = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnFirstPrivateBoard();
        //Thread.sleep(10000);
        new WebDriverWait(app.driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-header-btn.mod-show-menu")));
        app.getBoardHelper().clickOnMoreButtonInBoardMenu();
        app.getBoardHelper().initBoardMenu();
        app.getBoardHelper().confirmBoardDeletion();
        app.getBoardHelper().confirmFinishBoardDeletion();
        app.getBoardHelper().returnToHomePage();

        int after = app.getBoardHelper().getPersonalBoardsCount();

        Assert.assertEquals(after, before-1);

    }

}
