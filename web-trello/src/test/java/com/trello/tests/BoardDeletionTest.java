package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!isUserLoggedIn()){
            login("o.klevtsova1@gmail.com","25031992Klevtsova");
        }
    }
    @Test
    public void BoardDeletion() throws InterruptedException {
        int before = getPersonalBoardsCount();
        clickOnFirstPrivateBoard();
        //Thread.sleep(10000);
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-header-btn.mod-show-menu")));
        clickOnMoreButtonInBoardMenu();
        initBoardMenu();
        confirmBoardDeletion();
        confirmFinishBoardDeletion();
        returnToHomePage();

        int after = getPersonalBoardsCount();

        Assert.assertEquals(after, before-1);

    }

}
