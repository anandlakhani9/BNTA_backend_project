package com.drumandbase.dndspellapi.schools;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/* This is the School controller class, which has the rest methods for the schools table
* Created by Oliver, Sabi, Rose and Anand.
* NOTES: for the method GET, if you want to filter by ID use the url: api/v1/schools/id where ID is a number
* Whereas to filter by name you use url: api/v1/schools/name=x, where x is a school name.
* */
@RestController
@RequestMapping(path = "api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getSchools(){
        return schoolService.getSchools();
    }

    // Make sure to document why we did this -- to stop ambiguous coding
    @GetMapping("{id}")
    public Optional<School> getSchoolById(@PathVariable("id") int id){
        return schoolService.getSchool(id);
    }

    @GetMapping("name={name}")
    public Optional<School> getSchoolByName(@PathVariable("name") String name){
        return schoolService.getSchool(name);
    }

    @PostMapping
    public void addSchool(@RequestBody School school){
        schoolService.addSchool(school);
    }

    @PutMapping("{id}")
    public void updateSchool(@PathVariable("id") int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String description){
        // handle nulls in logic
        schoolService.updateSchool(id, name, description);
    }

    @DeleteMapping("{id}")
    public void deleteSchool(@PathVariable("id") int id){
        schoolService.deleteSchool(id);
    }
}
