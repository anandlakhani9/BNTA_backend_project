package com.drumandbase.dndspellapi.DNDRaces;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("races")
public class RaceDataAccessService implements RaceDAO {

    private JdbcTemplate jdbcTemplate;

    public RaceDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Race> selectAllRaces() {
        String sql = """
                     SELECT * FROM dndraces;
                     """;

        return jdbcTemplate.query(sql, new RaceRowMapper());
    }

    @Override
    public Optional<Race> selectRaceById(int id) {

        String sql = """
                     SELECT * FROM dndraces WHERE id = ?; 
                     """;

        return jdbcTemplate.query(sql, new RaceRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Race> selectRaceByName(String name) {

        String sql = """
                    SELECT * FROM dndraces WHERE race_name = ?; 
                """;

        return jdbcTemplate.query(sql, new RaceRowMapper(), name).stream().findFirst();
    }

    @Override
    public int insertRace(String name, String description) {
        String sql = """
                    INSERT INTO dndraces (race_name, race_description) VALUES (?,?);
                """;

        return jdbcTemplate.update(sql, name, description);
    }

    @Override
    public int deleteRace(int id) {
        String sql = """
                    DELETE FROM dndraces WHERE id = ?; 
                """;

        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateRace(int id, String name, String description) {
        String sql = """
                UPDATE dndraces 
                SET race_name = ?, race_description = ?
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sql, name, description, id);
    }
}

