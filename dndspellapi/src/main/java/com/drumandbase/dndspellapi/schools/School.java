package com.drumandbase.dndspellapi.schools;

import java.util.Objects;
/* What is this class: this is a POJO for the different schools of magic that a spell can have.
Each school has an ID, a name and a description for DnD.
Created by Oliver, Sabi, Rose and Anand.
*
* */

public class School {
    private int id;
    private String school_name;
    private String school_description;

//    public School(String school_name, String school_description) {
//        this.school_name = school_name;
//        this.school_description = school_description;
//    }

    public School(int id, String school_name, String school_description) {
        this.id = id;
        this.school_name = school_name;
        this.school_description = school_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_description() {
        return school_description;
    }

    public void setSchool_description(String school_description) {
        this.school_description = school_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return id == school.id && Objects.equals(school_name, school.school_name) && Objects.equals(school_description, school.school_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, school_name, school_description);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", school_name='" + school_name + '\'' +
                ", school_description='" + school_description + '\'' +
                '}';
    }
}
