package com.drumandbase.dndspellapi.schools;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/* This is all the business logic, where data validation happens for methods like inserting, updating and deleting a school.
* Created by Oliver, Sabi, Rose and Anand.
*
* */
@Service
public class SchoolService {

    private final SchoolDAO schoolDAO;


    @Autowired
    public SchoolService(@Qualifier("school") SchoolDAO schoolDAO) {
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

    public void addSchool(String name, String description) {

        if (name != null && name.trim().length() > 0 && description != null && description.trim().length() >0) {
            schoolDAO.insertSchool(name, description);
        } else {
            throw new NullPointerException("Must have a valid name and description");
        }
    }

    public void updateSchool(int id, String name, String description) {
        // check school exists
        //
//        schoolDAO.updateSchool(id, name, description);
        School school = getSchool(id)
                .orElseThrow(() ->
                        new ResourceNotFound("School with this id:" + id + " doesn't exist")
                );
        if (name != null && name.length() > 0 && !school.getSchool_name().equals(name)) {
            school.setSchool_name(name);
        }
        if (description != null && description.length() > 0 && !school.getSchool_description().equals(description)) {
            school.setSchool_description(description);

        }

        schoolDAO.updateSchool(school.getId(), school.getSchool_name(), school.getSchool_description());

    }


    public void deleteSchool(int id) {
        School school = getSchool(id)
                .orElseThrow(() ->
                        new ResourceNotFound("School with this id:" + id + " doesn't exist")
                );
        schoolDAO.deleteSchool(id);
    }
}
