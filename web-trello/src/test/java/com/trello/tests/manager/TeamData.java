package com.trello.tests.manager;

public class TeamData {
    private String teamName;
    private String description;



    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public TeamData withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamData withDescription(String description) {
        this.description = description;
        return this;
    }
}
