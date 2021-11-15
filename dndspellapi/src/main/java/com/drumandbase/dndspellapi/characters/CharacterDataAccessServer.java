package com.drumandbase.dndspellapi.characters;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("character")
public class CharacterDataAccessServer  implements CharacterDAO{

    private JdbcTemplate jdbcTemplate;

    public CharacterDataAccessServer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =jdbcTemplate;
    }
    @Override
    public List<Character> selectAllCharacters() {
        return null;
    }

    @Override
    public Optional<Character> selectCharacterById() {
        return Optional.empty();
    }

    @Override
    public int insertCharacter() {
        return 0;
    }

    @Override
    public int deleteCharacter() {
        return 0;
    }

    @Override
    public int updateCharacter() {
        return 0;
    }
}
