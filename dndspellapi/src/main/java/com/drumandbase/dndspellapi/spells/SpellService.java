package com.drumandbase.dndspellapi.spells;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import com.drumandbase.dndspellapi.schools.School;
import com.drumandbase.dndspellapi.spells.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
//            @NotBlank(message = "name cannot be blank")
//            @NotNull(message = "name cannot be null")
//            String name,
//            @NotNull(message = "level cannot be null")
//            int level,
//            @NotNull(message = "school_id cannot be null")
//            int schoolId,
//            @NotBlank(message = "range cannot be blank")
//            @NotNull(message = "range cannot be null")
//            String range,
//            @NotBlank(message = "components cannot be blank")
//            @NotNull(message = "components cannot be null")
//            String components,
//            @NotBlank(message = "duration cannot be blank")
//            @NotNull(message = "duration cannot be null")
//            String duration,
//            @NotBlank(message = "description cannot be blank")
//            @NotNull(message = "description cannot be null")
//            String description,
//            @NotBlank(message = "higher_level cannot be blank")
//            @NotNull (message = "higher_level cannot be null")
//            String higherLevel,
//            @NotNull(message = "ritual cannot be blank")
//            Boolean ritual,
//            @NotNull(message = "canSorcerer cannot be null")
//            Boolean canSorcerer,
//            @NotNull(message = "canWizard cannot be null")
//            Boolean canWizard,
//            @NotNull(message = "canWarlock cannot be null")
//            Boolean canWarlock,
//            @NotNull(message = "canBard cannot be null")
//            Boolean canBard,
//            @NotNull(message = "canBard cannot be null")
//            Boolean canPaladin,
//            @NotNull(message = "canDruid cannot be null")
//            Boolean canDruid,
//            @NotNull(message = "canCleric cannot be null")
//            Boolean canCleric,
//            @NotNull(message = "canRanger cannot be null")
//            Boolean canRanger) {

        /*if (
                name != null && name.trim().length() > 0 &&
                        level!= null && level.trim().length() > 0 &&
                        range!= null && range.trim().length() > 0 &&
                        components!= null && components.trim().length() > 0 &&
                        duration!= null && duration.trim().length() > 0 &&
                        ritual!= null &&
                        canSorcerer!= null &&
                        canWizard!= null &&
        ) {*/

//        if (spell.getSpellName().trim().length() == 0) {
//          throw new IllegalStateException("Spell name cannot be blank");
//        } if (spell.getSpellName().trim().length() == 0) {
//            throw new IllegalStateException("Spell name cannot be blank");
//        }
//        if (spellLevel != null) {
//            spell.setSpellName(spellName);
//        }
//        if (schoolId != null){
//            spell.setSchoolID(schoolId);
//        }
//        if (range != null && range.length() > 0) {
//            spell.setRange(range);
//        }
//        if(components != null && components.length() > 0 ){
//            spell.setComponents(components);
//        }
//        if(duration != null && duration.length() > 0 ){
//            spell.setComponents(components);
//        }
//        if(description != null && description.length() > 0 ){
//            spell.setComponents(components);
//        }
//        if(higherLevel != null && higherLevel.length() > 0 ){
//            spell.setComponents(components);
//        }
        spellDAO.insertSpell(spell);

/*        } else {
            throw new NullPointerException("Must have a valid name and description");
        }*/
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
