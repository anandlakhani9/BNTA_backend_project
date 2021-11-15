package com.drumandbase.dndspellapi.DNDRaces;

import java.util.Objects;

public class Race{
    private int id;
    private String race_name;
    private String race_description;


    public Race(int id, String race_name, String race_description) {
        this.id = id;
        this.race_name = race_name;
        this.race_description = race_description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public String getRace_description() {
        return race_description;
    }

    public void setRace_description(String race_description) {
        this.race_description = race_description;
    }

    public Race() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", race_name='" + race_name + '\'' +
                ", race_description='" + race_description + '\'' +
                '}';
    }
}
