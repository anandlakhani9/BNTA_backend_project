package com.drumandbase.dndspellapi.DNDRaces;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceDAO raceDAO;

   @Autowired
    public RaceService(@Qualifier("races") RaceDAO raceDAO) {this.raceDAO = raceDAO;}
    public List<Race> getRaces() {
        return raceDAO.selectAllRaces();
    }

    public Optional<Race> getRace(int id) {
        return raceDAO.selectRaceById(id);
    }

    public Optional<Race> getRace(String name) {
        return raceDAO.selectRaceByName(name);
    }

    public void addRace(String name, String description) {
        raceDAO.insertRace(name, description);
    }

    public void updateRace(int id, String name, String description) {
        // check school exists
        //
//        schoolDAO.updateSchool(id, name, description);
        Race race = getRace(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Race with this id:" + id + " doesn't exist")
                );
        if (name != null && name.length() > 0 && !race.getRace_name().equals(name)) {
            race.setRace_name(name);
        }
        if (description != null && description.length() > 0 && !race.getRace_description().equals(description)) {
            race.setRace_description(description);

        }


        raceDAO.updateRace(race.getId(), race.getRace_name(), race.getRace_description());
    }
    public void deleteRace(int id) {
       Race race = getRace(id)
               .orElseThrow(() ->
                       new ResourceNotFound("Race with this id:" + id + " doesn't exist"));
       raceDAO.deleteRace(id);
    }


}
