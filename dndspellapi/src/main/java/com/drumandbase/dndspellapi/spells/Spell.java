package com.drumandbase.dndspellapi.spells;

import java.util.Objects;

public class Spell {

    private long id;
    private String spellName;
    private int spellLevel;
    private int schoolId;
    private String range;
    private String components;
    private String duration;
    private String description;
    private String higherLevel;
    private Boolean ritual;
    private Boolean canSorcerer;
    private Boolean canWizard;
    private Boolean canWarlock;
    private Boolean canBard;
    private Boolean canPaladin;
    private Boolean canDruid;
    private Boolean canCleric;
    private Boolean canRanger;

    public Spell(long id, String spellName, int spellLevel, int schoolId, String range, String components, String duration,String description, String higherLevel, Boolean ritual, Boolean canSorcerer, Boolean canWizard, Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid, Boolean canCleric, Boolean canRanger) {
        this.id = id;
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.schoolId = schoolId;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
        this.higherLevel = higherLevel;
        this.ritual = ritual;
        this.canSorcerer = canSorcerer;
        this.canWizard = canWizard;
        this.canWarlock = canWarlock;
        this.canBard = canBard;
        this.canPaladin = canPaladin;
        this.canDruid = canDruid;
        this.canCleric = canCleric;
        this.canRanger = canRanger;
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

    public Boolean getCanSorcerer() {
        return canSorcerer;
    }

    public void setCanSorcerer(Boolean canSorcerer) {
        this.canSorcerer = canSorcerer;
    }

    public Boolean getCanWizard() {
        return canWizard;
    }

    public void setCanWizard(Boolean canWizard) {
        this.canWizard = canWizard;
    }

    public Boolean getCanWarlock() {
        return canWarlock;
    }

    public void setCanWarlock(Boolean canWarlock) {
        this.canWarlock = canWarlock;
    }

    public Boolean getCanBard() {
        return canBard;
    }

    public void setCanBard(Boolean canBard) {
        this.canBard = canBard;
    }

    public Boolean getCanPaladin() {
        return canPaladin;
    }

    public void setCanPaladin(Boolean canPaladin) {
        this.canPaladin = canPaladin;
    }

    public Boolean getCanDruid() {
        return canDruid;
    }

    public void setCanDruid(Boolean canDruid) {
        this.canDruid = canDruid;
    }

    public Boolean getCanCleric() {
        return canCleric;
    }

    public void setCanCleric(Boolean canCleric) {
        this.canCleric = canCleric;
    }

    public Boolean getCanRanger() {
        return canRanger;
    }

    public void setCanRanger(Boolean canRanger) {
        this.canRanger = canRanger;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSchoolID() {
        return schoolId;
    }

    public void setSchoolID(int schoolId) {
        this.schoolId = schoolId;
    }


    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
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
        Spell spell = (Spell) o;
        return id == spell.id && Objects.equals(spellName, spell.spellName) && Objects.equals(spellLevel, spell.spellLevel) && Objects.equals(range, spell.range) && Objects.equals(components, spell.components) && Objects.equals(duration, spell.duration) && Objects.equals(description, spell.description) && Objects.equals(higherLevel, spell.higherLevel) && Objects.equals(ritual, spell.ritual) && Objects.equals(canSorcerer, spell.canSorcerer) && Objects.equals(canWizard, spell.canWizard) && Objects.equals(canWarlock, spell.canWarlock) && Objects.equals(canBard, spell.canBard) && Objects.equals(canPaladin, spell.canPaladin) && Objects.equals(canDruid, spell.canDruid) && Objects.equals(canCleric, spell.canCleric) && Objects.equals(canRanger, spell.canRanger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spellName, spellLevel, range, components, duration, description, higherLevel, ritual, canSorcerer, canWizard, canWarlock, canBard, canPaladin, canDruid, canCleric, canRanger);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "id=" + id +
                ", spellName='" + spellName + '\'' +
                ", spellLevel='" + spellLevel + '\'' +
                ", range='" + range + '\'' +
                ", components='" + components + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", higherLevel='" + higherLevel + '\'' +
                ", ritual=" + ritual +
                ", canSorcerer=" + canSorcerer +
                ", canWizard=" + canWizard +
                ", canWarlock=" + canWarlock +
                ", canBard=" + canBard +
                ", canPaladin=" + canPaladin +
                ", canDruid=" + canDruid +
                ", canCleric=" + canCleric +
                ", canRanger=" + canRanger +
                '}';
    }
}
