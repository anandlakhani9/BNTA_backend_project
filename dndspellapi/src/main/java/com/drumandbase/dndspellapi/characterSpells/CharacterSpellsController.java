package com.drumandbase.dndspellapi.characterSpells;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/spellbook")
public class CharacterSpellsController {
    private final CharacterSpellsService csService;

    @Autowired
    public CharacterSpellsController(CharacterSpellsService csService) {
        this.csService = csService;
    }

    @GetMapping("{id}")
    public List<SpellbookDisplay> getCharacterSpellsByID(@PathVariable("id") long id){
        return csService.getACharactersSpellsByID(id);
    }

    @PostMapping
    public void addCharacterSpell(@RequestBody CharacterSpells cs){
        csService.addSpell4(cs);
    }

}
