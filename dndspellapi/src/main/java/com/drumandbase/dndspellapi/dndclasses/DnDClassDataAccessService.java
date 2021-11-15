package com.drumandbase.dndspellapi.dndclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("dnDClass")
public class DnDClassDataAccessService implements DnDClassDAO{

    private JdbcTemplate jdbcTemplate;

    public DnDClassDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<DnDClass> selectAllDnDClasses() {
        String sql = """
                SELECT * FROM dndclasses;
                """;
        return jdbcTemplate.query(sql, new DnDClassRowMapper());
    }

    @Override
    public Optional<DnDClass> selectDnDClassById(int id) {

        String sql = """
                SELECT * FROM dndclasses WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new DnDClassRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<DnDClass> selectDnDClassByName(String class_name) {
        String sql = """
                SELECT * FROM dndclasses WHERE class_name = ?;
                """;
        return jdbcTemplate.query(sql, new DnDClassRowMapper(), class_name).stream().findFirst();
    }

    @Override
    public int insertDnDClass(String class_name, String class_description) {
        String sql = """
                INSERT INTO dndclasses (class_name, class_description) VALUES (?,?);
                """;
        return jdbcTemplate.update(sql, class_name, class_description);
    }

    @Override
    public int deleteDnDClass(int id) {
        String sql = """
                    DELETE FROM dndclasses WHERE id = ?; 
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateDnDClass(int id, String class_name, String class_description) {
        String sql = """
                UPDATE dndclasses 
                SET class_name = ?, class_description = ?
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sql, class_name, class_description, id);
    }
}
