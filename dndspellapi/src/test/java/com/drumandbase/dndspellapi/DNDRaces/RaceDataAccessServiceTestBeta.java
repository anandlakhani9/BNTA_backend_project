package com.drumandbase.dndspellapi.DNDRaces;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@DataJdbcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class RaceDataAccessServiceTestBeta {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RaceDataAccessService underTest;


    @BeforeAll
    void setup() {
        underTest = new RaceDataAccessService(jdbcTemplate);
        jdbcTemplate.execute("INSERT INTO dndraces (race_name, race_description) VALUES ('Dwarf','small');");}

    @Test
    void itShouldSelectAllRaces(){
        List<Race> actual = underTest.selectAllRaces();
        List<Race> expected = List.of(new Race("Dwarf", "Short"),
        new Race("Halfling", "Small"),
        new Race("Half-Elf", "Diplomats"),
        new Race("Human", "Powerful"),
        new Race("Elf", "Slender"),
       new Race("Dragonborn", "Dragon"),
        new Race("Half-Orc","Strong"),
        new Race("Tiefling","Suspicious"),
        new Race("Gnome","Vibrant"),
        new Race("Dwarf", "small"

                    ));
        assertThat(actual).isEqualTo(expected);
        }

    @Test
    void itShouldSelectRaceById() {
        //given
        //when
        Optional<Race> actual = underTest.selectRaceById(1);
        System.out.println(actual);
        Optional<Race> expected = Optional.of(new Race("Dwarf", "Short"));
        //then

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void itShouldSelectRaceByName() {
        Optional<Race> actual = underTest.selectRaceByName("Elf");
        Optional<Race> expected = Optional.of(new Race("Elf", "Slender"));
        assertThat(actual).isEqualTo(expected); }

    @Test
    void ItShouldUpdateARace() {

        int actual = underTest.updateRace(1,"Sabi","hodja"
        );
        assertThat(actual).isEqualTo(1);
    }

//    @Test
//    void ItShouldInsertRace() {
//        // when
//        int actual = underTest.insertRace(new Race("fnsej", "fmdlfm"));
//        List<Race> expectedDB = List.of(new Race("Dwarf", "Short"),
//                new Race("Halfling", "Small")
//        );
//        assertThat(actual).isEqualTo(1);
//    }
    @Test
    void itShouldDeleteARace() {
        int actualOne = underTest.deleteRace(1);
        // then
        assertThat(actualOne).isEqualTo(1);
    }
}