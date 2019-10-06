package com.trello.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends HelperBase{

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void closeInviteToYourTeamButton(){
        click(By.cssSelector(".eg0KI5SqghoOFd"));
    }
    public String getTeamNameFromTeamPage() throws InterruptedException {
        //new WebDriverWait(driver,15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
       // Thread.sleep(10000);
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public int getTeamsCount()  {
       new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
         return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {
    }

    public void deleteTeam() {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings() throws InterruptedException {
        Thread.sleep(5000);
        click(By.cssSelector("ul .icon-gear.icon-sm"));
    }

    public void clickOnFirstTeam() {
        click(By.cssSelector("[data-test-id^='home-team-tab-section-']"));
    }

    public void cleanTeams() throws InterruptedException{
        int count = getTeamsCount();
        while (count>5) {
            clickOnFirstTeam();
            openSettings();
            deleteTeam();
           // returnToHomePage();
            refreshPage();
            count = getTeamsCount();
            System.out.println(count);
        }
    }

    public void initEditTeamProfile() {
        click(By.cssSelector(".js-edit-profile"));

    }

    public void changeTeamProfile(String name, String description) {
        type(By.name("displayName"),name);
        type(By.name("desc"),description);
    }

    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public boolean isTeamsPresent() {
        return getTeamsCount()>0;
    }

    public void createTeam() {
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "QA21 - " + System.currentTimeMillis();
        fillTeamCreationForm(new TeamData().withTeamName(teamName).withDescription("descr qa21"));
        clickContinueButton();
        returnToHomePage();
    }

}
