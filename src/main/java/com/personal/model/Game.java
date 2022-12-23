package com.personal.model;

import java.util.Date;

public class Game {
    private Integer id;
    private String winner;
    private String loser;
    private String league;
    private int odds;
    private double percentage;
    private Date date;
    private String result;

    public Game() {}

    public Game(String winner, String loser, String league, int odds, double percentage, Date date, String result) {
        this(null, winner, loser, league, odds, percentage, date, result);
    }

    public Game(Integer id, String winner, String loser, String league, int odds, double percentage, Date date, String result) {
        this.id = id;
        this.winner = winner;
        this.loser = loser;
        this.league = league;
        this.odds = odds;
        this.percentage = percentage;
        this.date = date;
        this.result = result;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
