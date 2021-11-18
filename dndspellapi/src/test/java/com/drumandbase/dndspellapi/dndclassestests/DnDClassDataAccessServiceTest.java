package com.drumandbase.dndspellapi.dndclassestests;

import com.drumandbase.dndspellapi.dndclasses.DnDClass;
import com.drumandbase.dndspellapi.dndclasses.DnDClassDataAccessService;
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

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJdbcTest
//@Sql({"classpath:test.sql"})
//@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DnDClassDataAccessServiceTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private DnDClassDataAccessService underTest;

    @BeforeAll
    void setup(){
        underTest = new DnDClassDataAccessService(jdbcTemplate);
        jdbcTemplate.execute(
                "INSERT INTO dndclasses (class_name, class_description) VALUES ('Rogue','fgsdu');");
    }
    @Test
    List<DnDClass> selectAllDnDClasss() {
        //given
        //when
        List<DnDClass> actual = underTest.selectAllDnDClasses();
        System.out.println(actual);
        List<DnDClass> expected = List.of(new DnDClass(8, "Rogue", "fgsdu"));
        //then
        assertThat(actual).isEqualTo(expected);
        return actual;
    }
    @Test
    void itShouldSelectDnDClassById() {
        //given
        //when
        Optional<DnDClass> actual = underTest.selectDnDClassById(1);
        System.out.println(actual);
        Optional<DnDClass> expected = Optional.of(new DnDClass(1, "Rogue", "fgsdu"));
        //then

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void itShouldSelectDnDClassByName() {
        //when
        Optional<DnDClass> actual = underTest.selectDnDClassByName("Rogue");
        Optional<DnDClass> expected = Optional.of(new DnDClass(1,
                "Rogue", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldInsertDnDClass() {
        // when
        int actual = underTest.insertDnDClass("Oliver", "udhfliuaehf");
        List<DnDClass> actualDB = underTest.selectAllDnDClasses();
        List<DnDClass> expectedDB = List.of(
                new DnDClass(1,
                        "Evocation", "jre;iogfj"),
                new DnDClass(2,
                        "Oliver", "udhfliuaehf"));
        // then
        assertThat(actual).isEqualTo(1);
        assertThat(actualDB).isEqualTo(expectedDB);
    }

    //delete both DnDClasss here
    @Test
    void itShouldDeleteADnDClass() {
        // when
        System.out.println(underTest.selectAllDnDClasses());
        int actualOne = underTest.deleteDnDClass(1);
        System.out.println(underTest.selectAllDnDClasses());
        List<DnDClass> actualDB = underTest.selectAllDnDClasses();
        // then
        assertThat(actualOne).isEqualTo(1);
        assertThat(actualDB).isEqualTo(List.of());
    }

    @Test
    void deleteDnDClassWhereIdDoesNotExist(){
        // given
        int actual = underTest.deleteDnDClass(4);
        // when
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void selectDnDClassWhereIdDoesNotExist(){
        // given
        Optional<DnDClass> actual = underTest.selectDnDClassById(4);
        // when
        assertThat(actual).isEqualTo(Optional.empty());
    }
    @Test
    void selectAllDnDClasssWhereTableIsEmpty(){
        //given
        underTest.deleteDnDClass(1);
        // when
        List<DnDClass> actual = underTest.selectAllDnDClasses();
        // then
        assertThat(actual).isEqualTo(List.of());
    }

    @Test
        // normally would expect ID to be 2 here
        // but because of the insert test it is 3
        // each test method seems to be running their test, but resetting the database to what it was before the test
        // so the serial in the db is being tricked into thinking 2 has been used
    void itShouldInsertDnDClassAfterAllHaveBeenDeletedWithCorrectID() {
        //given
        System.out.println(underTest.selectAllDnDClasses());
        underTest.deleteDnDClass(1);
        // when
        int actual = underTest.insertDnDClass("Fighter", "udhfliuaehf");
        List<DnDClass> actualDB = underTest.selectAllDnDClasses();
        List<DnDClass> expectedDB = List.of(new DnDClass(3,
                "Fighter", "udhfliuaehf"));

        // then
        assertThat(actual).isEqualTo(1);
        assertThat(actualDB).isEqualTo(expectedDB);
    }

    @Test
    void itShouldUpdateDnDClass() {
        //when
        int actual = underTest.updateDnDClass(1,
                "Fighter",
                "fghdkjafhd;hf");
        int expected = 1;
        List<DnDClass> expectedDB = List.of(new DnDClass(1,
                "Fighter",
                "fghdkjafhd;hf" ));
        List<DnDClass> actualDB = underTest.selectAllDnDClasses();
        //then
        assertThat(actual).isEqualTo(expected);
        assertThat(actualDB).isEqualTo(expectedDB);
    }
}
