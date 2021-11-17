package com.drumandbase.dndspellapi.spells;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import com.drumandbase.dndspellapi.schools.School;
import com.drumandbase.dndspellapi.spells.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
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

    public Optional<Spell> getSpell(long id) {
        return spellDAO.selectSpellByID(id);
    }

    public Optional<Spell> getSpell(String name) {
        return spellDAO.selectSpellByName(name);
    }

    public void addSpell(Spell spell){

        if (spell.getSpellName().trim().length() == 0) {
          throw new IllegalStateException("The spell name input cannot be blank");
        } if (spell.getRange().length() == 0) {
            throw new IllegalStateException("The range input cannot be blank");
        } if (spell.getComponents().trim().length() == 0) {
            throw new IllegalStateException("The component input cannot be blank");
        } if (spell.getDuration().trim().length() == 0) {
            throw new IllegalStateException("The duration input cannot be blank");
        } if (spell.getDescription().trim().length() == 0) {
            throw new IllegalStateException("The duration cannot be blank");
        } if (spell.getHigherLevel().trim().length() == 0) {
            throw new IllegalStateException("The higher level cannot be blank");
        }

        spellDAO.insertSpell(spell);

    }

    public void deleteSpell(long id) {
        Spell spell = getSpell(id)
                .orElseThrow(() ->
                        new ResourceNotFound("spell with this id:" + id + " doesn't exist")
                );
        spellDAO.deleteSpell(id);
    }

    public void updateSpell(long id, String spellName, Integer spellLevel, Integer schoolId, String range, String components, String duration,
                            String description, String higherLevel, Boolean ritual, Boolean canSorcerer, Boolean canWizard,
                            Boolean canWarlock, Boolean canBard, Boolean canPaladin, Boolean canDruid,
                            Boolean canCleric, Boolean canRanger) {

        Spell spell = getSpell(id)
                .orElseThrow(() ->
                        new ResourceNotFound("spell with this id:" + id + " doesn't exist")
                );
        if (spellName != null && spellName.length() > 0) {
            spell.setSpellName(spellName);
        }
        if (spellLevel != null) {
            spell.setSpellName(spellName);
        } if (schoolId != null){
            spell.setSchoolID(schoolId);
        } if (range != null && range.length() > 0) {
            spell.setRange(range);
        } if(components != null && components.length() > 0 ){
            spell.setComponents(components);
        } if(duration != null && duration.length() > 0 ){
            spell.setComponents(components);
        } if(description != null && description.length() > 0 ){
            spell.setComponents(components);
        } if(higherLevel != null && higherLevel.length() > 0 ){
            spell.setComponents(components);
        } if(ritual != null){
            spell.setRitual(ritual);
        } if(canSorcerer != null){
            spell.setCanSorcerer(canSorcerer);
        } if(canWizard != null){
            spell.setCanWizard(canWizard);
        } if(canWarlock != null){
            spell.setCanWarlock(canWarlock);
        } if(canBard!= null){
            spell.setCanBard(canBard);
        } if(canPaladin!= null){
            spell.setCanPaladin(canPaladin);
        }  if(canDruid != null){
            spell.setCanDruid(canDruid);
        }  if(canCleric != null){
            spell.setCanCleric(canCleric);
        } if(canRanger != null){
            spell.setCanRanger(canRanger);
        }

        spellDAO.updateSpell(
                spell.getId(),
                spell.getSpellName(),
                spell.getSpellLevel(),
                spell.getSchoolID(),
                spell.getRange(),
                spell.getComponents(),
                spell.getDuration(),
                spell.getDescription(),
                spell.getHigherLevel(),
                spell.getRitual(),
                spell.getCanSorcerer(),
                spell.getCanWizard(),
                spell.getCanWarlock(),
                spell.getCanBard(),
                spell.getCanPaladin(),
                spell.getCanDruid(),
                spell.getCanCleric(),
                spell.getCanRanger());
    }
}
