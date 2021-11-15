package com.drumandbase.dndspellapi.spells;

import java.util.Objects;

public class Spell {

    private long id;
    private String spell_name;
    private String spell_level;
    private String range;
    private String components;
    private String duration;
    private Boolean ritual;
    private Boolean canSorcerer;
    private Boolean canWizard;
    private Boolean canWarlock;
    private Boolean canBard;
    private Boolean canPaladin;
    private Boolean canDruid;
    private Boolean canCleric;
    private Boolean canRanger;



    public Spell(long id, String spell_name, String spell_level, String range, String components, String duration, Boolean ritual, Boolean canSorcerer, Boolean canWizard, Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid, Boolean canCleric, Boolean canRanger) {
        this.id = id;
        this.spell_name = spell_name;
        this.spell_level = spell_level;
        this.range = range;
        this.components = components;
        this.duration = duration;
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

    public String getSpell_name() {
        return spell_name;
    }

    public void setSpell_name(String spell_name) {
        this.spell_name = spell_name;
    }

    public String getSpell_level() {
        return spell_level;
    }

    public void setSpell_level(String spell_level) {
        this.spell_level = spell_level;
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
        return id == spell.id && Objects.equals(spell_name, spell.spell_name) && Objects.equals(spell_level, spell.spell_level) && Objects.equals(range, spell.range) && Objects.equals(components, spell.components) && Objects.equals(duration, spell.duration) && Objects.equals(ritual, spell.ritual) && Objects.equals(canSorcerer, spell.canSorcerer) && Objects.equals(canWizard, spell.canWizard) && Objects.equals(canWarlock, spell.canWarlock) && Objects.equals(canBard, spell.canBard) && Objects.equals(canPaladin, spell.canPaladin) && Objects.equals(canDruid, spell.canDruid) && Objects.equals(canCleric, spell.canCleric) && Objects.equals(canRanger, spell.canRanger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spell_name, spell_level, range, components, duration, ritual, canSorcerer, canWizard, canWarlock, canBard, canPaladin, canDruid, canCleric, canRanger);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "id=" + id +
                ", spell_name='" + spell_name + '\'' +
                ", spell_level='" + spell_level + '\'' +
                ", range='" + range + '\'' +
                ", components='" + components + '\'' +
                ", duration='" + duration + '\'' +
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
