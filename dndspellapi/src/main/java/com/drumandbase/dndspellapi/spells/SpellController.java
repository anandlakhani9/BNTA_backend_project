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
    /*public void updateSpell(@PathVariable("id") int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String description){
        // handle nulls in logic
        spelllService.updateSpell(id, name, description);
    }*/

    @DeleteMapping("{id}")
    public void deleteSpell(@PathVariable("id") int id){
        spellService.deleteSpell(id);
    }

}
