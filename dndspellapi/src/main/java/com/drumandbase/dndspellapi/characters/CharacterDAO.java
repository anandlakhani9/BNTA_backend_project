package com.drumandbase.dndspellapi.characters;

import java.util.List;
import java.util.Optional;

public interface CharacterDAO {

    List<Character> selectAllCharacters();
    Optional<Character> selectCharacterById();
    int insertCharacter(/* TODO*/);
    int deleteCharacter(/* TODO*/);
    int updateCharacter(/* TODO*/);
}
