package com.example.interviewui.RecyclerHolders;

public class MatchScores {
    private final String teamAName;
    private final String teamBName;

    public MatchScores(String teamAName, String teamBName) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public String getTeamBName() {
        return teamBName;
    }
}
