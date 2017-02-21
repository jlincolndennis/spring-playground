package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    private int id;
    private  String name;
    private String type;
    private int weight;
    private int height;
    private boolean isDefault;
    private int baseExperience;
    private String locationAreaEncounters;
    private HeldItems[] heldItems;
    private Stats[] stats;
    private Abilities[] abilities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @JsonProperty("is_default")
    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @JsonProperty("base_experience")
    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    @JsonProperty("location_area_encounters")
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    @JsonProperty("held_items")
    public HeldItems[] getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(HeldItems[] heldItems) {
        this.heldItems = heldItems;
    }

    public Stats[] getStats() {
        return stats;
    }

    public void setStats(Stats[] stats) {
        this.stats = stats;
    }

    public Abilities[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }
}

class Abilities {
    private int slot;
    private boolean isHidden;
    private Ability ability;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @JsonProperty("is_hidden")
    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }


}

class ApiToken {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Ability extends ApiToken {}

class test {
    private int nummmm;
    private String strgfsdg;

}

class Stats {
    private Stat stat;
    private int effort;
    private int baseStat;

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    @JsonProperty("base_stat")
    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }
}

class Stat extends ApiToken {}

class HeldItems {}