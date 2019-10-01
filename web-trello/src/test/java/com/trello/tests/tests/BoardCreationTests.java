package com.trello.tests.tests;

import com.trello.tests.manager.BoardData;
import com.trello.tests.manager.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name","description"});
        list.add(new Object[]{"NAME","DESCRIPTION"});
        list.add(new Object[]{"789","78965413"});
        list.add(new Object[]{"@#&$*","$&%$*$&#@*"});
        list.add(new Object[]{"name",""});

        return list.iterator();
    }

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
    @Test(dataProvider = "validBoards")

    public void testBoardCreationFromPlusButtonOnHeaderWithDataProvider(String boardName, String description){
        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();
        BoardData board = new BoardData().withBoardName(boardName).withDescription(description);
        int before = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm("Qa-21","D");
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();
        int afterCreation = app.getBoardHelper() .getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
