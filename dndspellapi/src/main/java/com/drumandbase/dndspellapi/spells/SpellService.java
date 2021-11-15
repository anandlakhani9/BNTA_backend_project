package com.drumandbase.dndspellapi.spells;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import com.drumandbase.dndspellapi.spells.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpellService {

    private final SpellDAO spellDAO;

    @Autowired
    public SpellService(@Qualifier("spells") SpellDAO spellDAO){
        this.spellDAO = spellDAO;
    }

    public List<Spell> getSpells() {
        return spellDAO.selectAllSpells();
    }

    public Optional<Spell> getSpell(int id) {
        return spellDAO.selectSpellByID(id);
    }

    public Optional<Spell> getSpell(String name) {
        return spellDAO.selectSpellByName(name);
    }

    public void addSpell(String name, String description) {

        if (name != null && name.trim().length() > 0 && description != null && description.trim().length() >0) {
            //.insertSpell(name, description);
        } else {
            throw new NullPointerException("Must have a valid name and description");
        }
    }

/*    public void updateSpell(int id, String name, String description) {
        // check spell exists
        //
//        spellDAO.updatespell(id, name, description);
        Spell spell = getSpell(id)
                .orElseThrow(() ->
                        new ResourceNotFound("spell with this id:" + id + " doesn't exist")
                );
        if (name != null && name.length() > 0 && !spell.getSpell_name().equals(name)) {
            spell.setSpell_name(name);
        }
        if (description != null && description.length() > 0 && !spell.getSpell_description().equals(description)) {
            spell.setSpell_description(description);

        }

        spellDAO.updateSpell(spell.getId(), spell.getSpell_name(), spell.getSpell_description());

    }*/


    public void deleteSpell(int id) {
        Spell spell = getSpell(id)
                .orElseThrow(() ->
                        new ResourceNotFound("spell with this id:" + id + " doesn't exist")
                );
        spellDAO.deleteSpell(id);
    }
}
