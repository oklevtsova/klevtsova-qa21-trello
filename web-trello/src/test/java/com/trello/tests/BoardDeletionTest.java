package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.isUserLoggedIn()){
            app.login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void BoardDeletion() throws InterruptedException {
        int before = app.getPersonalBoardsCount();
        app.clickOnFirstPrivateBoard();
        //Thread.sleep(10000);
        new WebDriverWait(app.driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-header-btn.mod-show-menu")));
        app.clickOnMoreButtonInBoardMenu();
        app.initBoardMenu();
        app.confirmBoardDeletion();
        app.confirmFinishBoardDeletion();
        app.returnToHomePage();

        int after = app.getPersonalBoardsCount();

        Assert.assertEquals(after, before-1);

    }

}
