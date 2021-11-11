package com.drumandbase.dndspellapi.schools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolDAO schoolDAO;


    @Autowired
    public SchoolService(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public List<School> getSchools() {
        return schoolDAO.selectAllSchools();
    }

    public Optional<School> getSchool(int id) {
        return schoolDAO.selectSchoolById(id);
    }

    public Optional<School> getSchool(String name) {
        return schoolDAO.selectSchoolByName(name);
    }

    public void addSchool(School school) {
        schoolDAO.insertSchool(school);
    }

    public void updateSchool(int id, String name, String description) {
        // check school exists
        //
//        schoolDAO.updateSchool(id, name, description);
    }

    public void deleteSchool(int id) {
        schoolDAO.deleteSchool(id);
    }
}
