package com.drumandbase.dndspellapi.DNDRaces;

import java.util.List;
import java.util.Optional;

public interface RaceDAO {
    List<Race> selectAllRaces();
    Optional<Race>selectRaceById(int id);
    Optional<Race> selectRaceByName(String name);
    int insertRace(String name, String description);
    int deleteRace(int id);
    int updateRace(int id, String name, String description);
}
