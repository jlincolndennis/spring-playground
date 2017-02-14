package com.example;

public class Adventurer {
    private String race;
    private String job;
    private int hp;


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "{" +
                "race=" + race + ", job=" + job + ", hp=" + hp + "}";
    }
}
