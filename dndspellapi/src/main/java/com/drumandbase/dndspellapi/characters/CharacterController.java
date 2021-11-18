package com.drumandbase.dndspellapi.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("{id}")
    public Optional<Character> getCharacterById(@PathVariable("id") Long id) {
        return characterService.getCharacter(id);
    }

    @PostMapping
    public void addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
    }

    @PutMapping("{id}")
    public void addCharacter(@PathVariable("id") Long id,
                             @RequestParam(required = false) Integer race_id,
                             @RequestParam(required = false) Integer  class_id ,
                             @RequestParam(required = false) Integer character_level,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer cantrips_known,
                             @RequestParam(required = false) Integer max_cantrips_known,
                             @RequestParam(required = false) Integer spells_known,
                             @RequestParam(required = false) Integer max_spells_known,
                             @RequestParam(required = false) Integer spell_slot_1,
                             @RequestParam(required = false) Integer spell_slot_2,
                             @RequestParam(required = false) Integer spell_slot_3,
                             @RequestParam(required = false) Integer spell_slot_4,
                             @RequestParam(required = false) Integer spell_slot_5,
                             @RequestParam(required = false) Integer spell_slot_6,
                             @RequestParam(required = false) Integer spell_slot_7,
                             @RequestParam(required = false) Integer spell_slot_8,
                             @RequestParam(required = false) Integer spell_slot_9,
                             @RequestParam(required = false) Integer max_spell_slot_1,
                             @RequestParam(required = false) Integer max_spell_slot_2,
                             @RequestParam(required = false) Integer max_spell_slot_3,
                             @RequestParam(required = false) Integer max_spell_slot_4,
                             @RequestParam(required = false) Integer max_spell_slot_5,
                             @RequestParam(required = false) Integer max_spell_slot_6,
                             @RequestParam(required = false) Integer max_spell_slot_7,
                             @RequestParam(required = false) Integer max_spell_slot_8,
                             @RequestParam(required = false) Integer max_spell_slot_9,
                             @RequestParam(required = false) Integer max_ivocations_known) {
        characterService.updateCharacter(id, race_id, class_id, character_level, name,  cantrips_known,  max_cantrips_known,  spells_known,
         max_spells_known,  spell_slot_1,  spell_slot_2,  spell_slot_3,  spell_slot_4,  spell_slot_5,  spell_slot_6,
         spell_slot_7,  spell_slot_8,  spell_slot_9,  max_spell_slot_1,  max_spell_slot_2,  max_spell_slot_3,
         max_spell_slot_4,  max_spell_slot_5,  max_spell_slot_6,  max_spell_slot_7,  max_spell_slot_8,  max_spell_slot_9,
         max_ivocations_known);
    }

    @DeleteMapping("{id}")
    public void deleteCharacter(@PathVariable("id") Long id){
        characterService.deleteCharacter(id);
    }


}
