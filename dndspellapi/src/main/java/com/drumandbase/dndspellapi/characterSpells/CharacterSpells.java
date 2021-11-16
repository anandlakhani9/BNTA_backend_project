package com.drumandbase.dndspellapi.characterSpells;

import java.util.Objects;

public class CharacterSpells {
    private long id;
    private long characterID;
    private long spellID;

    public CharacterSpells(long id, long characterID, long spellID) {
        this.id = id;
        this.characterID = characterID;
        this.spellID = spellID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public long getSpellID() {
        return spellID;
    }

    public void setSpellID(long spellID) {
        this.spellID = spellID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSpells that = (CharacterSpells) o;
        return id == that.id && characterID == that.characterID && spellID == that.spellID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, characterID, spellID);
    }
}
