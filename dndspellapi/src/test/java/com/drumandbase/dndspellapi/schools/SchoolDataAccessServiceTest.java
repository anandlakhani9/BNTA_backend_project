package com.drumandbase.dndspellapi.schools;


import org.junit.jupiter.api.*;
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
//@Sql({"classpath:test.sql"})
//@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  //allows for before all for a non static method
class SchoolDataAccessServiceTest {

    //link to tutorial I used
    //https://www.baeldung.com/spring-jdbctemplate-testing

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    private SchoolDataAccessService underTest;

    //runs this once for the class when tests run rather than before each test
    //important as otherwise it has confusing IDs because of an insert before each test
    //because tests are not run in the order they are defined, so cannot guess the ID for the assertion
    @BeforeAll
     void setup(){
        underTest = new SchoolDataAccessService(jdbcTemplate);
        jdbcTemplate.execute("INSERT INTO schools (school_name, school_description) VALUES ('Evocation', 'jre;iogfj');");
    }

    //@Sql({"classpath:test.sql"})
    @Test
    void selectAllSchools(){
        //given
        //when
        List<School> actual = underTest.selectAllSchools();
        System.out.println(actual);
        List<School> expected = List.of(new School(1, "Evocation", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldSelectSchoolById() {
        //given
        //when
        Optional<School> actual = underTest.selectSchoolById(1);
        System.out.println(actual);
        Optional<School> expected = Optional.of(new School(1,
                "Evocation", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldSelectSchoolByName() {
        //when
        Optional<School> actual = underTest.selectSchoolByName("Evocation");
        Optional<School> expected = Optional.of(new School(1,
                "Evocation", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldInsertSchool() {
        // when
        int actual = underTest.insertSchool("Oliver", "udhfliuaehf");
        List<School> actualDB = underTest.selectAllSchools();
        List<School> expectedDB = List.of(
                new School(1,
                "Evocation", "jre;iogfj"),
                new School(2,
                        "Oliver", "udhfliuaehf"));
        // then
        assertThat(actual).isEqualTo(1);
        assertThat(actualDB).isEqualTo(expectedDB);
    }

    //delete both schools here
    @Test
    void itShouldDeleteASchool() {
        // when
        System.out.println(underTest.selectAllSchools());
        int actualOne = underTest.deleteSchool(1);
        System.out.println(underTest.selectAllSchools());
        List<School> actualDB = underTest.selectAllSchools();
        // then
        assertThat(actualOne).isEqualTo(1);
        assertThat(actualDB).isEqualTo(List.of());
    }

    @Test
    void deleteSchoolWhereIdDoesNotExist(){
        // given
        int actual = underTest.deleteSchool(4);
        // when
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void selectSchoolWhereIdDoesNotExist(){
        // given
        Optional<School> actual = underTest.selectSchoolById(4);
        // when
        assertThat(actual).isEqualTo(Optional.empty());
    }
    @Test
    void selectAllSchoolsWhereTableIsEmpty(){
        //given
        underTest.deleteSchool(1);
        // when
        List<School> actual = underTest.selectAllSchools();
        // then
        assertThat(actual).isEqualTo(List.of());
    }

    @Test
    // normally would expect ID to be 2 here
    // but because of the insert test it is 3
    // each test method seems to be running their test, but resetting the database to what it was before the test
    // so the serial in the db is being tricked into thinking 2 has been used
    void itShouldInsertSchoolAfterAllHaveBeenDeletedWithCorrectID() {
        //given
        System.out.println(underTest.selectAllSchools());
        underTest.deleteSchool(1);
        // when
        int actual = underTest.insertSchool("Oliver", "udhfliuaehf");
        List<School> actualDB = underTest.selectAllSchools();
        List<School> expectedDB = List.of(new School(3,
                "Oliver", "udhfliuaehf"));

        // then
        assertThat(actual).isEqualTo(1);
        assertThat(actualDB).isEqualTo(expectedDB);
    }

    @Test
    void itShouldUpdateSchool() {
        //when
        int actual = underTest.updateSchool(1,
                "Anand",
                "fghdkjafhd;hf");
        int expected = 1;
        List<School> actualDB = List.of(new School(1,
                "Anand",
                "fghdkjafhd;hf" ));
        List<School> expectedDB = underTest.selectAllSchools();
        //then
        assertThat(actual).isEqualTo(expected);
        assertThat(actualDB).isEqualTo(expectedDB);
    }



}