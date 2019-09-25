package com.trello.tests.tests;

import com.trello.tests.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.init();


    }

    @AfterClass
    public void tearDown(){
        app.stop();

    }

}
