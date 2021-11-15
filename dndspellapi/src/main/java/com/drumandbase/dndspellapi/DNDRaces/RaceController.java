package com.drumandbase.dndspellapi.DNDRaces;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path = "api/v1/races")
public class RaceController {
    private final RaceService raceService;


    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> getRaces(){
        return raceService.getRaces();
    }

    // Make sure to document why we did this -- to stop ambiguous coding
    @GetMapping("{id}")
    public Optional<Race> getRaceById(@PathVariable("id") int id){
        return raceService.getRace(id);
    }

    @GetMapping("name={name}")
    public Optional<Race> getRaceByName(@PathVariable("name") String name){
        return raceService.getRace(name);
    }

    @PostMapping
    public void addRace(@RequestBody Race race){
        raceService.addRace(race.getRace_name(), race.getRace_description());
    }

    @PutMapping("{id}")
    public void updateRace(@PathVariable("id") int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String description){
        // handle nulls in logic
        raceService.updateRace(id, name, description);
    }

    @DeleteMapping("{id}")
    public void deleteRace(@PathVariable("id") int id){
        raceService.deleteRace(id);
    }
}
