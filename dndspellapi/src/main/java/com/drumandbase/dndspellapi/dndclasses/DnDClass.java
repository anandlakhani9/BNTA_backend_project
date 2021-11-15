package com.drumandbase.dndspellapi.dndclasses;

import java.util.Objects;

public class DnDClass {
    private int id;
    private String class_name;
    private String class_description;

    public DnDClass(int id, String class_name, String class_description) {
        this.id = id;
        this.class_name = class_name;
        this.class_description = class_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_description() {
        return class_description;
    }

    public void setClass_description(String class_description) {
        this.class_description = class_description;
    }

    @Override
    public String toString() {
        return "DnDClass{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", class_description='" + class_description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DnDClass dnDClass = (DnDClass) o;
        return id == dnDClass.id && Objects.equals(class_name, dnDClass.class_name) && Objects.equals(class_description, dnDClass.class_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, class_name, class_description);
    }
}
