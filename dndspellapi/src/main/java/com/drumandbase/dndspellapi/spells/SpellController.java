package com.drumandbase.dndspellapi.spells;


import com.drumandbase.dndspellapi.schools.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/spells")
public class SpellController {

    private final SpellService spellService;

    @Autowired
    public SpellController(SpellService spellService){
        this.spellService = spellService;
    }

    @GetMapping
    public List<Spell> getSpells(){
        return spellService.getSpells();}

    @GetMapping("{id}")
    public Optional<Spell> getSpellsById(@PathVariable("id") int id){
        return spellService.getSpell(id);
    }

    @GetMapping("name={name}")
    public Optional<Spell> getSpellByName(@PathVariable("name") String name){
        return spellService.getSpell(name);
    }

    @PostMapping
    public void addSpell(@RequestBody Spell spell){
        spellService.addSpell(spell);
    }

    @PutMapping("{id}")
    public void updateSpell(@PathVariable("id") long id,
                            @RequestParam(required = false) String spellName,
                            @RequestParam(required = false) Integer spellLevel,
                            @RequestParam(required = false) Integer schoolId,
                            @RequestParam(required = false) String range,
                            @RequestParam(required = false) String components,
                            @RequestParam(required = false) String duration,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String higherLevel,
                            @RequestParam(required = false) Boolean ritual,
                            @RequestParam(required = false) Boolean canSorcerer,
                            @RequestParam(required = false) Boolean canWizard,
                            @RequestParam(required = false) Boolean canWarlock,
                            @RequestParam(required = false) Boolean canBard,
                            @RequestParam(required = false) Boolean canPaladin,
                            @RequestParam(required = false) Boolean canDruid,
                            @RequestParam(required = false) Boolean canCleric,
                            @RequestParam(required = false) Boolean canRanger
                            ) {
                                // handle nulls in logic
                                spellService.updateSpell(
                                        id,
                                        spellName,
                                        spellLevel,
                                        schoolId,
                                        range,
                                        components,
                                        duration,
                                        description,
                                        higherLevel,
                                        ritual,
                                        canSorcerer,
                                        canWizard,
                                        canWarlock,
                                        canBard,
                                        canPaladin,
                                        canDruid,
                                        canCleric,
                                        canRanger);
                            }

    @DeleteMapping("{id}")
    public void deleteSpell(@PathVariable("id") long id){
        spellService.deleteSpell(id);
    }

}
