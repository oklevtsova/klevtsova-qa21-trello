package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.getBoardHelper().isTherePersonalBoards()) {
            app.getBoardHelper().createBoard();
        }
    }

    @Test
    public void changeBoardName() {
        app.getBoardHelper().clickOnFirstPrivateBoard();
        String bName = "BB";
        app.getBoardHelper().changeBoardName(bName);

        //Assert.assertTrue(app.getBoardHelper().findBoardByName(bName));

    }
}


