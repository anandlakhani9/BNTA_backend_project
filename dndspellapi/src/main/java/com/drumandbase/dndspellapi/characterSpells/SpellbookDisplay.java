package com.drumandbase.dndspellapi.characterSpells;

import java.util.Objects;

public class SpellbookDisplay {
    private long characterSpellID;
    private String characterName;
    private String characterLevel;
    private String spellName;
    private int spellLevel;
    private String schoolName;
    private String range;
    private String components;
    private String duration;
    private String description;
    private String higherLevel;
    private Boolean ritual;

    public SpellbookDisplay(long characterSpellID, String characterName, String characterLevel, String spellName, int spellLevel, String schoolName, String range, String components, String duration, String description, String higherLevel, Boolean ritual) {
        this.characterSpellID = characterSpellID;
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.schoolName = schoolName;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
        this.higherLevel = higherLevel;
        this.ritual = ritual;
    }

    public long getCharacterSpellID() {
        return characterSpellID;
    }

    public void setCharacterSpellID(long characterSpellID) {
        this.characterSpellID = characterSpellID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(String characterLevel) {
        this.characterLevel = characterLevel;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHigherLevel() {
        return higherLevel;
    }

    public void setHigherLevel(String higherLevel) {
        this.higherLevel = higherLevel;
    }

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpellbookDisplay that = (SpellbookDisplay) o;
        return characterSpellID == that.characterSpellID && spellLevel == that.spellLevel && characterName.equals(that.characterName) && characterLevel.equals(that.characterLevel) && spellName.equals(that.spellName) && schoolName.equals(that.schoolName) && range.equals(that.range) && components.equals(that.components) && duration.equals(that.duration) && description.equals(that.description) && higherLevel.equals(that.higherLevel) && ritual.equals(that.ritual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterSpellID, characterName, characterLevel, spellName, spellLevel, schoolName, range, components, duration, description, higherLevel, ritual);
    }
}
