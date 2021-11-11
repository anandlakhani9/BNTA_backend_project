package com.drumandbase.dndspellapi.schools;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class SchoolDataAccessService implements SchoolDAO{

    private JdbcTemplate jdbcTemplate;

    public SchoolDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<School> selectAllSchools() {
        String sql = """
                     SELECT * FROM schools;
                     """;

       return jdbcTemplate.query(sql, new SchoolRowMapper());
    }

    @Override
    public Optional<School> selectSchoolById(int id) {

        String sql = """
                     SELECT * FROM schools WHERE id = ?; 
                     """;

        return jdbcTemplate.query(sql, new SchoolRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<School> selectSchoolByName(String name) {

        String sql = """
                    SELECT * FROM schools WHERE name = ?; 
                """;

        return jdbcTemplate.query(sql, new SchoolRowMapper(), name).stream().findFirst();
    }

    @Override
    public int insertSchool(School school) {
        String sql = """
                    INSERT INTO schools (id, name, description) VALUES (?,?,?);
                """;

        return jdbcTemplate.update(sql, school.getId(), school.getSchool_name(), school.getSchool_description());
    }

    @Override
    public int deleteSchool(int id) {
        String sql = """
                    DELETE FROM schools WHERE id = ?; 
                """;

        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateSchool(int id, String name, String description) {
        String sql = """
                UPDATE schools 
                SET name = ?, description = ?
                WHERE id = ?;
                """;

        return jdbcTemplate.update(sql, id, name, description);
    }
}
