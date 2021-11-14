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
    void selectSchoolById() {
        //given
        //when
        Optional<School> actual = underTest.selectSchoolById(1);
        System.out.println(actual);
        Optional<School> expected = Optional.of(new School(1, "Evocation", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void selectSchoolByName() {
        //when
        Optional<School> actual = underTest.selectSchoolByName("Evocation");
        Optional<School> expected = Optional.of(new School(1, "Evocation", "jre;iogfj"));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled
    void insertSchool() {
    }

    @Test
    @Disabled
    void deleteSchool() {
    }

    @Test
    @Disabled
    void updateSchool() {
    }
}