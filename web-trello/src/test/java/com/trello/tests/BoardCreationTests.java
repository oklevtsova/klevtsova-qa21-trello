package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation(){
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm("QA-21", "descr");
        confirmBoardCreation();
    }



}
