package com.drumandbase.dndspellapi.dndclasses;

import java.util.List;
import java.util.Optional;

public interface DnDClassDAO {
    List<DnDClass> selectAllDnDClasses();
    Optional<DnDClass> selectDnDClassById(int id);
    Optional<DnDClass> selectDnDClassByName(String class_name);
    int insertDnDClass(String name, String description);
    int deleteDnDClass(int id);
    int updateDnDClass(int id, String class_name, String class_description);
}
