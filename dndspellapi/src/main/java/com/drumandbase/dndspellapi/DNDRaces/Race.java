package com.drumandbase.dndspellapi.DNDRaces;

import java.util.Objects;

public class Race{
    private int id;
    private String race_name;
    private String race_description;


    public Race(String race_name, String race_description) {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id == race.id && Objects.equals(race_name, race.race_name) && Objects.equals(race_description, race.race_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, race_name, race_description);
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
