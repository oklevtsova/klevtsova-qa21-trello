package com.trello.tests.manager;

public class BoardData {

    private String boardName;
    private String description;



    public String getBoardName() {
        return boardName;
    }

    public String getDescription() {
        return description;
    }

    public BoardData withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public BoardData withDescription(String description) {
        this.description = description;
        return this;
    }

}
