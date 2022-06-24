package com.example.dummyproject;

public class StoryModel {
    public String title, desc;

    public StoryModel() {
    }

    public StoryModel(String title) {
        this.title = title;
    }

    public StoryModel(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
