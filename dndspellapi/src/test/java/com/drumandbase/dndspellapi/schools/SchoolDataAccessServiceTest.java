package com.drumandbase.dndspellapi.schools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJdbcTest
@ActiveProfiles("test")
class SchoolDataAccessServiceTest {
/*
    @Autowired
    private SchoolDataAccessService underTest;


    private List<School> entities() {
        return List.of(
                new School(1, "Evocation", "jre;iogfj"),
                new School(2, "Necromancy", "iu;j;irjn")
        );
    }

    @Test
    void selectAllSchools() {
        //given
        underTest.insertSchool(entities().get(0));
        underTest.insertSchool(entities().get(1));
        //when
        List<School> expected = entities();
        List<School> actual = underTest.selectAllSchools();
        //then
        assertThat(actual).isEqualTo(expected);

    }*/

    @Test
    void selectSchoolById() {
    }

    @Test
    void selectSchoolByName() {
    }

    @Test
    void insertSchool() {
    }

    @Test
    void deleteSchool() {
    }

    @Test
    void updateSchool() {
    }
}