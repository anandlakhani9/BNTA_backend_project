package com.drumandbase.dndspellapi.characters;

import java.util.List;
import java.util.Optional;

public interface CharacterDAO {

    List<Character> selectAllCharacters();
    Optional<Character> selectCharacterById(Long id);
    int insertCharacter(Character character);
    int deleteCharacter(Long id);
    int updateCharacter(/* TODO*/);
}
