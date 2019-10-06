package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
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
    @DataProvider
    public Iterator<Object[]>validBoardsFromcsv() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Board.csv")));
        String line = reader.readLine();
        while (line !=null){
            String[]split = line.split(",");
            list.add(new Object[]{new BoardData().withBoardName(split[0]).withDescription(split[1])});
            line = reader.readLine();
        }
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
        app.getBoardHelper().fillBoardCreationForm(new BoardData().withBoardName("QA-21").withDescription("descr"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper() .getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }
    @Test(dataProvider = "validBoardsFromcsv")
    public void testBoardCreationFromPlusButtonOnHeaderWithDataProviderFromcsv(BoardData board) throws InterruptedException {

        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();
        int afterCreation = app.getBoardHelper() .getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }

    @Test(dataProvider = "validBoards")

    public void testBoardCreationFromPlusButtonOnHeaderWithDataProvider(String boardName, String description) throws InterruptedException {

        BoardData board = new BoardData().withBoardName(boardName).withDescription(description);
        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();

        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();
        int afterCreation = app.getBoardHelper() .getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
