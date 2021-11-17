package com.drumandbase.dndspellapi.spells;

import com.drumandbase.dndspellapi.schools.School;
import com.drumandbase.dndspellapi.schools.SchoolDataAccessService;
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
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJdbcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpellDataAccessServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SpellDataAccessService underTest;


    @BeforeAll
    void setup() {
        underTest = new SpellDataAccessService(jdbcTemplate);
        jdbcTemplate.execute(" INSERT INTO spells (spell_name, spell_level, school_id, range, components, duration, description, higher_level, ritual, canSorcerer, canWizard, canWarlock, canBard, canPaladin, canDruid, canCleric, canRanger) VALUES ('Evocation', 1, 1, 'Very far', 'Hg', '2019', 'Magical', 'yes', true, true, false, false, false, false, false, false, false); ");
    };

    @Test
    void itShouldSelectAllSpells() {
        List<Spell> actual = underTest.selectAllSpells();
        List<Spell> expected = List.of(new Spell(
                1,
                "Evocation",
                1,
                1,
                "Very far",
                "Hg",
                "2019",
                "Magical",
                "yes",
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
                ));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldSelectSpellByID() {
        //given
        Optional<Spell> actual = underTest.selectSpellByID(1);
        //when
        Optional<Spell> expected = Optional.of(new Spell(
                1,
                "Evocation",
                1,
                1,
                "Very far",
                "Hg",
                "2019",
                "Magical",
                "yes",
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        ));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldSelectSpellByName() {
        //when
        Optional<Spell> actual = underTest.selectSpellByName("Evocation");
        Optional<Spell> expected = Optional.of(new Spell(
                1,
                "Evocation",
                1,
                1,
                "Very far",
                "Hg",
                "2019",
                "Magical",
                "yes",
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        ));
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ItShouldUpdateASpell() {

        int actual = underTest.updateSpell(
                1,
                "Sabi",
                1,
                1,
                "Very far",
                "Hg",
                "2019",
                "Magical",
                "yes",
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void ItShouldInsertSpell() {
        // when
        int actual = underTest.insertSpell(

                new Spell(
                2,
                "Oliver",
                1,
                1,
                "Very far",
                "Hg",
                "2019",
                "Magical",
                "yes",
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        ));

        List<Spell> expectedDB = List.of(new Spell(
                        1,
                        "Evocation",
                        1,
                        1,
                        "Very far",
                        "Hg",
                        "2019",
                        "Magical",
                        "yes",
                        true,
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false
                ),
                new Spell(
                        2,
                        "Oliver",
                        1,
                        1,
                        "Very far",
                        "Hg",
                        "2019",
                        "Magical",
                        "yes",
                        true,
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false
                ));
        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void itShouldDeleteASpell() {
        int actualOne = underTest.deleteSpell(1);
        // then
        assertThat(actualOne).isEqualTo(1);
    }
}