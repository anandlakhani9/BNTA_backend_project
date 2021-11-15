package com.drumandbase.dndspellapi.schools;

import java.util.List;
import java.util.Optional;
/* Created by Oliver, Sabi, Rose and Anand.
*
* */

public interface SchoolDAO {

    List<School> selectAllSchools();
    Optional<School> selectSchoolById(int id);
    Optional<School> selectSchoolByName(String name);
    int insertSchool(String name, String description);
    int deleteSchool(int id);
    int updateSchool(int id, String name, String description);

}
