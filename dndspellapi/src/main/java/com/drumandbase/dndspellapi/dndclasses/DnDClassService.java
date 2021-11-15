package com.drumandbase.dndspellapi.dndclasses;

import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DnDClassService {

    private final DnDClassDAO dnDClassDAO;

    @Autowired
    public DnDClassService(@Qualifier("dnDClass") DnDClassDAO dnDClassDAO) {
        this.dnDClassDAO = dnDClassDAO;
    }

    public List<DnDClass> getDnDClasses() {
        return  dnDClassDAO.selectAllDnDClasses();
    }

    public Optional<DnDClass> getDnDClass(int id) {
        return dnDClassDAO.selectDnDClassById(id);
    }

    public Optional<DnDClass> getDnDClass(String name) {
        return dnDClassDAO.selectDnDClassByName(name);
    }

    public void addDnDClass(String name, String description) {
        dnDClassDAO.insertDnDClass(name, description);
    }

    public void updateDnDClass(int id, String name, String description) {
        DnDClass dnDClass = getDnDClass(id)
                .orElseThrow(() ->
                        new ResourceNotFound("School with this id: "+ id + " doesn't exist")
                );
        if (name != null && name.length() > 0 && !dnDClass.getClass_name().equals(description)) {
            dnDClass.setClass_name(name);
        }
        if (description != null && description.length() > 0 && !dnDClass.getClass_description().equals(description)) {
            dnDClass.setClass_description(description);
        }

        dnDClassDAO.updateDnDClass(dnDClass.getId(), dnDClass.getClass_name(), dnDClass.getClass_description());
    }

    public void deleteDnDClass(int id) {
        DnDClass dnDClass = getDnDClass(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Class with this id: " + id + "doesn't exist")
                );
        dnDClassDAO.deleteDnDClass(id);
    }
}
