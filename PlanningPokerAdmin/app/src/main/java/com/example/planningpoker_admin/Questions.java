package com.example.planningpoker_admin;

public class Questions {

    private String quest;
    private String date;

    public Questions(String date, String quest) {
        this.date = date;
        this.quest = quest;
    }

    public String getQuest() {
        return quest;
    }

    public String getDate() {
        return date;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
