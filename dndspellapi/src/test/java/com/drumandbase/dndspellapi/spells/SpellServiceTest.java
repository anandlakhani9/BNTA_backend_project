package com.drumandbase.dndspellapi.spells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SpellServiceTest {

    private SpellDAO spellDAO;
    private SpellService underTest;

    @BeforeEach
    void setUp() {
        spellDAO = mock(SpellDAO.class);
        underTest = new SpellService(spellDAO);
    }

    @Test
    void itShouldGetSpells() {
        // given
        Spell anotherSpell = new Spell(1,
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
                false);

        List<Spell> spells = List.of(anotherSpell);
        // when
        when(spellDAO.selectAllSpells()).thenReturn(spells);
        // then
        assertThat(underTest.getSpells()).isEqualTo(spells);

    }

    @Test
    void itShouldGetSpellById() {
        // given
        Spell newSpell = new Spell(2,
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
                false);
        List<Spell> spells = List.of(newSpell);
        // We need to ONLY mock spellDAO dependency
        when(spellDAO.selectSpellByID(2)).thenReturn(Optional.of(newSpell));
        // when
        Optional<Spell> actual = underTest.getSpell(2);
        // then
        assertThat(actual).isEqualTo(Optional.of(newSpell));
    }

    @Test
    void itShouldAddSpell() {

        Spell spell = new Spell(1,
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
                false);

        when(spellDAO.insertSpell(spell)).thenReturn(1);

        int result = underTest.addSpell(spell);

        assertThat(result).isEqualTo(1);

        // Captor

        ArgumentCaptor<Spell> personArgumentCaptor =
                ArgumentCaptor.forClass(Spell.class);

        verify(spellDAO)
                .insertSpell(personArgumentCaptor.capture());

        Spell capturedPerson = personArgumentCaptor.getValue();

        assertThat(capturedPerson).isEqualTo(spell);
    }

    @Test
    void itShouldGetSpellByName() {
        // given
        Spell newSpell = new Spell(2,
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
                false);
        List<Spell> spells = List.of(newSpell);
        // We need to ONLY mock spellDAO dependency
        when(spellDAO.selectSpellByName("Evocation")).thenReturn(Optional.of(newSpell));
        // when
        Optional<Spell> actual = underTest.getSpell("Evocation");
        // then
        assertThat(actual).isEqualTo(Optional.of(newSpell));
    }

    @Test
    void itShouldDeleteSpell() {
       Spell spell = new Spell(2,
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
                false);

        List<Spell> spells = List.of(spell);
        // We need to ONLY mock spellDAO dependency
        when(spellDAO.selectAllSpells()).thenReturn(spells);
        when(spellDAO.deleteSpell(2)).thenReturn(1);

        // when
        int actual = underTest.deleteSpell(2);
        System.out.println(actual);
        // then
        assertThat(actual).isEqualTo(1);

        // Captor
        ArgumentCaptor<Long> idArgumentCaptor =
                ArgumentCaptor.forClass(Long.class);

        verify(spellDAO)
                .deleteSpell(idArgumentCaptor.capture());

       Long capturedInt = idArgumentCaptor.getValue();

        assertThat(capturedInt).isEqualTo(2);
    }
}