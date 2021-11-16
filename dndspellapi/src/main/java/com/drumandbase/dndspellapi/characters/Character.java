package com.drumandbase.dndspellapi.characters;

import java.math.BigInteger;
import java.util.Objects;

public class Character {
    private Long id;
    private int race_id;
    private int  class_id;
    private int character_level;
    private String name;
    private int max_cantrips_known;
    private int max_spells_known;
    private int spell_slot_1;
    private int spell_slot_2;
    private int spell_slot_3;
    private int spell_slot_4;
    private int spell_slot_5;
    private int spell_slot_6;
    private int spell_slot_7;
    private int spell_slot_8;
    private int spell_slot_9;
    private int max_spell_slot_1;
    private int max_spell_slot_2;
    private int max_spell_slot_3;
    private int max_spell_slot_4;
    private int max_spell_slot_5;
    private int max_spell_slot_6;
    private int max_spell_slot_7;
    private int max_spell_slot_8;
    private int max_spell_slot_9;
    private int max_ivocations_known;

//    private CharacterService cs;

    public Character(Long id, int race_id, int class_id, int character_level, String name, int max_cantrips_known, int max_spells_known, int spell_slot_1, int spell_slot_2, int spell_slot_3, int spell_slot_4, int spell_slot_5, int spell_slot_6, int spell_slot_7, int spell_slot_8, int spell_slot_9, int max_spell_slot_1, int max_spell_slot_2, int max_spell_slot_3, int max_spell_slot_4, int max_spell_slot_5, int max_spell_slot_6, int max_spell_slot_7, int max_spell_slot_8, int max_spell_slot_9, int max_ivocations_known) {
        this.id = id;
        this.race_id = race_id;
        this.class_id = class_id;
        this.character_level = character_level;
        this.name = name;
        this.max_cantrips_known = max_cantrips_known;
        this.max_spells_known = max_spells_known;
        this.spell_slot_1 = spell_slot_1;
        this.spell_slot_2 = spell_slot_2;
        this.spell_slot_3 = spell_slot_3;
        this.spell_slot_4 = spell_slot_4;
        this.spell_slot_5 = spell_slot_5;
        this.spell_slot_6 = spell_slot_6;
        this.spell_slot_7 = spell_slot_7;
        this.spell_slot_8 = spell_slot_8;
        this.spell_slot_9 = spell_slot_9;
        this.max_spell_slot_1 = max_spell_slot_1;
        this.max_spell_slot_2 = max_spell_slot_2;
        this.max_spell_slot_3 = max_spell_slot_3;
        this.max_spell_slot_4 = max_spell_slot_4;
        this.max_spell_slot_5 = max_spell_slot_5;
        this.max_spell_slot_6 = max_spell_slot_6;
        this.max_spell_slot_7 = max_spell_slot_7;
        this.max_spell_slot_8 = max_spell_slot_8;
        this.max_spell_slot_9 = max_spell_slot_9;
        this.max_ivocations_known = max_ivocations_known;
    }

//    public Character(Long id, int race_id, int class_id, int character_level, String name, int max_spell_slot_1) {
//        this.id = id;
//        this.race_id = race_id;
//        this.class_id = class_id;
//        this.character_level = character_level;
//        this.name = name;
//        this.max_spell_slot_1 = max_spell_slot_1;
//        //cs.putSpellSlots(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int character_id) {
        this.class_id = character_id;
    }

    public int getCharacter_level() {
        return character_level;
    }

    public void setCharacter_level(int character_level) {
        this.character_level = character_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_cantrips_known() {
        return max_cantrips_known;
    }

    public void setMax_cantrips_known(int max_cantrips_known) {
        this.max_cantrips_known = max_cantrips_known;
    }

    public int getMax_spells_known() {
        return max_spells_known;
    }

    public void setMax_spells_known(int max_spells_known) {
        this.max_spells_known = max_spells_known;
    }

    public int getSpell_slot_1() {
        return spell_slot_1;
    }

    public void setSpell_slot_1(int spell_slot_1) {
        this.spell_slot_1 = spell_slot_1;
    }

    public int getSpell_slot_2() {
        return spell_slot_2;
    }

    public void setSpell_slot_2(int spell_slot_2) {
        this.spell_slot_2 = spell_slot_2;
    }

    public int getSpell_slot_3() {
        return spell_slot_3;
    }

    public void setSpell_slot_3(int spell_slot_3) {
        this.spell_slot_3 = spell_slot_3;
    }

    public int getSpell_slot_4() {
        return spell_slot_4;
    }

    public void setSpell_slot_4(int spell_slot_4) {
        this.spell_slot_4 = spell_slot_4;
    }

    public int getSpell_slot_5() {
        return spell_slot_5;
    }

    public void setSpell_slot_5(int spell_slot_5) {
        this.spell_slot_5 = spell_slot_5;
    }

    public int getSpell_slot_6() {
        return spell_slot_6;
    }

    public void setSpell_slot_6(int spell_slot_6) {
        this.spell_slot_6 = spell_slot_6;
    }

    public int getSpell_slot_7() {
        return spell_slot_7;
    }

    public void setSpell_slot_7(int spell_slot_7) {
        this.spell_slot_7 = spell_slot_7;
    }

    public int getSpell_slot_8() {
        return spell_slot_8;
    }

    public void setSpell_slot_8(int spell_slot_8) {
        this.spell_slot_8 = spell_slot_8;
    }

    public int getSpell_slot_9() {
        return spell_slot_9;
    }

    public void setSpell_slot_9(int spell_slot_9) {
        this.spell_slot_9 = spell_slot_9;
    }

    public int getMax_spell_slot_1() {
        return max_spell_slot_1;
    }

    public void setMax_spell_slot_1(int max_spell_slot_1) {
        this.max_spell_slot_1 = max_spell_slot_1;
    }

    public int getMax_spell_slot_2() {
        return max_spell_slot_2;
    }

    public void setMax_spell_slot_2(int max_spell_slot_2) {
        this.max_spell_slot_2 = max_spell_slot_2;
    }

    public int getMax_spell_slot_3() {
        return max_spell_slot_3;
    }

    public void setMax_spell_slot_3(int max_spell_slot_3) {
        this.max_spell_slot_3 = max_spell_slot_3;
    }

    public int getMax_spell_slot_4() {
        return max_spell_slot_4;
    }

    public void setMax_spell_slot_4(int max_spell_slot_4) {
        this.max_spell_slot_4 = max_spell_slot_4;
    }

    public int getMax_spell_slot_5() {
        return max_spell_slot_5;
    }

    public void setMax_spell_slot_5(int max_spell_slot_5) {
        this.max_spell_slot_5 = max_spell_slot_5;
    }

    public int getMax_spell_slot_6() {
        return max_spell_slot_6;
    }

    public void setMax_spell_slot_6(int max_spell_slot_6) {
        this.max_spell_slot_6 = max_spell_slot_6;
    }

    public int getMax_spell_slot_7() {
        return max_spell_slot_7;
    }

    public void setMax_spell_slot_7(int max_spell_slot_7) {
        this.max_spell_slot_7 = max_spell_slot_7;
    }

    public int getMax_spell_slot_8() {
        return max_spell_slot_8;
    }

    public void setMax_spell_slot_8(int max_spell_slot_8) {
        this.max_spell_slot_8 = max_spell_slot_8;
    }

    public int getMax_spell_slot_9() {
        return max_spell_slot_9;
    }

    public void setMax_spell_slot_9(int max_spell_slot_9) {
        this.max_spell_slot_9 = max_spell_slot_9;
    }

    public int getMax_ivocations_known() {
        return max_ivocations_known;
    }

    public void setMax_ivocations_known(int max_ivocation_known) {
        this.max_ivocations_known = max_ivocation_known;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return race_id == character.race_id && class_id == character.class_id && character_level == character.character_level && max_cantrips_known == character.max_cantrips_known && max_spells_known == character.max_spells_known && spell_slot_1 == character.spell_slot_1 && spell_slot_2 == character.spell_slot_2 && spell_slot_3 == character.spell_slot_3 && spell_slot_4 == character.spell_slot_4 && spell_slot_5 == character.spell_slot_5 && spell_slot_6 == character.spell_slot_6 && spell_slot_7 == character.spell_slot_7 && spell_slot_8 == character.spell_slot_8 && spell_slot_9 == character.spell_slot_9 && max_spell_slot_1 == character.max_spell_slot_1 && max_spell_slot_2 == character.max_spell_slot_2 && max_spell_slot_3 == character.max_spell_slot_3 && max_spell_slot_4 == character.max_spell_slot_4 && max_spell_slot_5 == character.max_spell_slot_5 && max_spell_slot_6 == character.max_spell_slot_6 && max_spell_slot_7 == character.max_spell_slot_7 && max_spell_slot_8 == character.max_spell_slot_8 && max_spell_slot_9 == character.max_spell_slot_9 && max_ivocations_known == character.max_ivocations_known && Objects.equals(id, character.id) && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, race_id, class_id, character_level, name, max_cantrips_known, max_spells_known, spell_slot_1, spell_slot_2, spell_slot_3, spell_slot_4, spell_slot_5, spell_slot_6, spell_slot_7, spell_slot_8, spell_slot_9, max_spell_slot_1, max_spell_slot_2, max_spell_slot_3, max_spell_slot_4, max_spell_slot_5, max_spell_slot_6, max_spell_slot_7, max_spell_slot_8, max_spell_slot_9, max_ivocations_known);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", race_id=" + race_id +
                ", class_id=" + class_id +
                ", character_level=" + character_level +
                ", name='" + name + '\'' +
                ", max_cantrips_known=" + max_cantrips_known +
                ", max_spells_known=" + max_spells_known +
                ", spell_slot_1=" + spell_slot_1 +
                ", spell_slot_2=" + spell_slot_2 +
                ", spell_slot_3=" + spell_slot_3 +
                ", spell_slot_4=" + spell_slot_4 +
                ", spell_slot_5=" + spell_slot_5 +
                ", spell_slot_6=" + spell_slot_6 +
                ", spell_slot_7=" + spell_slot_7 +
                ", spell_slot_8=" + spell_slot_8 +
                ", spell_slot_9=" + spell_slot_9 +
                ", max_spell_slot_1=" + max_spell_slot_1 +
                ", max_spell_slot_2=" + max_spell_slot_2 +
                ", max_spell_slot_3=" + max_spell_slot_3 +
                ", max_spell_slot_4=" + max_spell_slot_4 +
                ", max_spell_slot_5=" + max_spell_slot_5 +
                ", max_spell_slot_6=" + max_spell_slot_6 +
                ", max_spell_slot_7=" + max_spell_slot_7 +
                ", max_spell_slot_8=" + max_spell_slot_8 +
                ", max_spell_slot_9=" + max_spell_slot_9 +
                ", max_ivocations_known=" + max_ivocations_known +
                '}';
    }

}
