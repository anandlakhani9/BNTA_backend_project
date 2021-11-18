//package com.drumandbase.dndspellapi.DNDRaces;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@ExtendWith(SpringExtension.class)
//@DataJdbcTest
////@Sql({"classpath:test.sql"})
////@ActiveProfiles("test")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class RaceDataAccessServiceTest {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private RaceDataAccessService underTest;
//
//    @BeforeAll
//    void setup(){
//        underTest = new RaceDataAccessService(jdbcTemplate);
//        jdbcTemplate.execute(
//                "INSERT INTO dndraces (race_name, race_description) VALUES ('Dwarf','Short and Stout');");
//    }
//    @Test
//        void selectAllRaces() {
//        //given
//        //when
//        List<Race> actual = underTest.selectAllRaces();
//        System.out.println(actual);
//        List<Race> expected = List.of(new Race(1,"Dwarf", ""),
//                new Race(2,"Halfling", ""),
//                new Race(3, "Half-Elf", ""),
//                new Race(4, "Human", ""),
//                new Race(5, "Elf", ""),
//                new Race(6, "Dragonborn", ""),
//                new Race(7, "Half-Orc",""),
//                new Race(8, "Tiefling",""),
//                new Race(9, "Gnome",""),
//        new Race(10,"Dwarf", "Short and Stout"));
//        //then
//        assertThat(actual).isEqualTo(expected);
//
//    }
//    @Test
//    void itShouldSelectRaceById() {
//        //given
//        //when
//        Optional<Race> actual = underTest.selectRaceById(1);
//        System.out.println(actual);
//        Optional<Race> expected = Optional.of(new Race(1, "Dwarf", ""));
//        //then
//
//        assertThat(actual).isEqualTo(expected);
//    }
//    @Test
//    void itShouldSelectRaceByName() {
//        //when
//        Optional<Race> actual = underTest.selectRaceByName("Dwarf");
//        Optional<Race> expected = Optional.of(new Race(1,
//                "Dwarf", ""));
//        //then
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    void itShouldInsertRace() {
//        // when
//        int actual = underTest.insertRace("Dwarf", "");
//        List<Race> actualDB = underTest.selectAllRaces();
//        List<Race> expectedDB = List.of(
//                new Race(1,"Dwarf", ""),
//                new Race(2,"Halfling", ""),
//                new Race(3, "Half-Elf", ""),
//                new Race(4, "Human", ""),
//                new Race(5, "Elf", ""),
//                new Race(6, "Dragonborn", ""),
//                new Race(7, "Half-Orc",""),
//                new Race(8, "Tiefling",""),
//                new Race(9, "Gnome",""),
//                new Race(10,"Dwarf", "Short and Stout"),
//               new Race(11, "Dwarf", ""));
//        // then
//        assertThat(actual).isEqualTo(1);
//        assertThat(actualDB).isEqualTo(expectedDB);
//    }
//
//    //delete both Races here
//    @Test
//    void itShouldDeleteARace() {
//        // when
//        System.out.println(underTest.selectAllRaces());
//        int actualOne = underTest.deleteRace(1);
//        System.out.println(underTest.selectAllRaces());
//        List<Race> actualDB = underTest.selectAllRaces();
//        // then
//        assertThat(actualOne).isEqualTo(1);
//        assertThat(actualDB).isEqualTo(List.of());
//    }
//
//    @Test
//    void deleteRaceWhereIdDoesNotExist(){
//        // given
//        int actual = underTest.deleteRace(4);
//        // when
//        assertThat(actual).isEqualTo(0);
//    }
//
//    @Test
//    void selectRaceWhereIdDoesNotExist(){
//        // given
//        Optional<Race> actual = underTest.selectRaceById(4);
//        // when
//        assertThat(actual).isEqualTo(Optional.empty());
//    }
//    @Test
//    void selectAllRacesWhereTableIsEmpty(){
//        //given
//        underTest.deleteRace(1);
//        // when
//        List<Race> actual = underTest.selectAllRaces();
//        // then
//        assertThat(actual).isEqualTo(List.of());
//    }
//
//    @Test
//        // normally would expect ID to be 2 here
//        // but because of the insert test it is 3
//        // each test method seems to be running their test, but resetting the database to what it was before the test
//        // so the serial in the db is being tricked into thinking 2 has been used
//    void itShouldInsertRaceAfterAllHaveBeenDeletedWithCorrectID() {
//        //given
//        System.out.println(underTest.selectAllRaces());
//        underTest.deleteRace(1);
//        // when
//        int actual = underTest.insertRace("Oliver", "udhfliuaehf");
//        List<Race> actualDB = underTest.selectAllRaces();
//        List<Race> expectedDB = List.of(new Race(3,
//                "Oliver", "udhfliuaehf"));
//
//        // then
//        assertThat(actual).isEqualTo(1);
//        assertThat(actualDB).isEqualTo(expectedDB);
//    }
//
//    @Test
//    void itShouldUpdateRace() {
//        //when
//        int actual = underTest.updateRace(1,
//                "Dwarf",
//                "");
//        int expected = 1;
//        List<Race> expectedDB = List.of(new Race(1,
//                "Dwarf",
//                "" ));
//        List<Race> actualDB = underTest.selectAllRaces();
//        //then
//        assertThat(actual).isEqualTo(expected);
//        assertThat(actualDB).isEqualTo(expectedDB);
//    }
//}