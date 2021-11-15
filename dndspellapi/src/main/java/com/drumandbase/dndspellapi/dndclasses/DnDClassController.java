package com.drumandbase.dndspellapi.dndclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/dndclasses")
public class DnDClassController {

    private final DnDClassService dndClassService;

    @Autowired
    public DnDClassController(DnDClassService dndClassService) {
        this.dndClassService = dndClassService;
    }

    @GetMapping
    public List<DnDClass> getDnDClasses(){
        return dndClassService.getDnDClasses();
    }

    @GetMapping("{id}")
    public Optional<DnDClass> getDnDClassesById(@PathVariable("id") int id) {
        return dndClassService.getDnDClass(id);
    }

    @GetMapping("name={name}")
    public Optional<DnDClass> getDnDClassesByName(@PathVariable("name") String name) {
        return dndClassService.getDnDClass(name);
    }
    @PostMapping public void addDnDClass(@RequestBody DnDClass dnDClass) {
        dndClassService.addDnDClass(dnDClass.getClass_name(), dnDClass.getClass_description());
    }
    @PutMapping("{id}")
    public void updateDnDClass(@PathVariable("id") int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String description){
        // handle nulls in logic
        dndClassService.updateDnDClass(id, name, description);
    }

    @DeleteMapping("{id}")
    public void deleteSchool(@PathVariable("id") int id){
        dndClassService.deleteDnDClass(id);
    }

}
