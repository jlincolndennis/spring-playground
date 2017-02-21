package com.example;

public class Gem {
    private String name;
    private String weapon;

    public Gem(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


}

class Fusion {
    private String name;
    private Gem[] members;

    public Fusion(String name, Gem[] members) {
        this.name = name;
        this.members = members;
    }

    public Fusion(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gem[] getMembers() {
        return members;
    }

    public void setMembers(Gem[] members) {
        this.members = members;
    }
}
