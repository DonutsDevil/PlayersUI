package com.example.interviewui.RecyclerHolders;

public class MatchInformation {

    private final String time;
    private final String title;

    public MatchInformation(String time, String title) {
        this.time = time;
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
