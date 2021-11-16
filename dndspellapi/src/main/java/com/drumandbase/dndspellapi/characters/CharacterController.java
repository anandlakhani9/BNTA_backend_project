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

    @PutMapping
    public void addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
    }

    @PutMapping("{id}")
    public void addCharacter(@PathVariable("id") Long id,
                             @RequestParam(required = false) /*TODO*/) {
        characterService.updateCharacter(/*TODO:*/);
    }

    @DeleteMapping("{id}")
    public void deleteCharacter(@PathVariable("id") Long id){
        characterService.deleteCharacter(id);
    }


}
