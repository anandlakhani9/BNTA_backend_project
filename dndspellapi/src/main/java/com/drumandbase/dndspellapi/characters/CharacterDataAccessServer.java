package com.drumandbase.dndspellapi.characters;

import com.drumandbase.dndspellapi.dndclasses.DnDClass;
import com.drumandbase.dndspellapi.dndclasses.DnDClassController;
import com.drumandbase.dndspellapi.exceptions.ResourceNotFound;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository("character")
public class CharacterDataAccessServer  implements CharacterDAO{


    private HashMap<Integer,Integer[]> spellMap;
    private int max_cantrips_known;
    private int max_spells_known;
    private int spell_slot_1;
    private int spell_slot_2;
    private int spell_slot_3;
    private int spell_slot_4;
    private int spell_slot_5;
    private int spell_slot_6;
    private int spell_slot_7;
    private int spell_slot_8;
    private int spell_slot_9;
    private int max_spell_slot_1;
    private int max_spell_slot_2;
    private int max_spell_slot_3;
    private int max_spell_slot_4;
    private int max_spell_slot_5;
    private int max_spell_slot_6;
    private int max_spell_slot_7;
    private int max_spell_slot_8;
    private int max_spell_slot_9;

    private DnDClassController dnDClassController;

    private JdbcTemplate jdbcTemplate;

    //private CharacterService cs;
    public CharacterDataAccessServer(JdbcTemplate jdbcTemplate, DnDClassController dnDClassController) {
        this.jdbcTemplate = jdbcTemplate;
        this.dnDClassController = dnDClassController;

    }

    // Remember to do inner join
    @Override
    public List<Character> selectAllCharacters() {
        String sql = """
                SELECT * FROM characters;
                """;
        return jdbcTemplate.query(sql,new CharacterRowMapper());
    }

    @Override
    public Optional<Character> selectCharacterById(Long id) {
        return Optional.empty();
    }

    @Override
    public int insertCharacter(Character character) {
        putSpellSlots(character);
        String sql = """
                INSERT INTO characters (race_id, class_id, character_level, name, max_cantrips_known, max_spells_known,
                spell_slot_1, spell_slot_2, spell_slot_3, spell_slot_4, spell_slot_5, spell_slot_6, spell_slot_7, spell_slot_8, spell_slot_9,
                max_spell_slot_1, max_spell_slot_2, max_spell_slot_3, max_spell_slot_4, max_spell_slot_5, max_spell_slot_6, max_spell_slot_7, max_spell_slot_8, max_spell_slot_9)
                VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(sql, character.getRace_id(), character.getClass_id(), character.getCharacter_level(), character.getName(), this.getMax_cantrips_known(), this.getMax_spells_known(),
                this.getSpell_slot_1(), this.getSpell_slot_2(), this.getSpell_slot_3(), this.getSpell_slot_4(), this.getSpell_slot_5(), this.getSpell_slot_6(), this.getSpell_slot_7(),
                this.getSpell_slot_8(), this.getSpell_slot_9(), this.getMax_spell_slot_1(), this.getMax_spell_slot_2(), this.getMax_spell_slot_3(), this.getMax_spell_slot_4(), this.getMax_spell_slot_5(), this.getMax_spell_slot_6(),
                this.getMax_spell_slot_7(),this.getMax_spell_slot_8(), this.getMax_spell_slot_9());
    }

    @Override
    public int deleteCharacter(Long id) {
        String sql = """
                DELETE FROM characters WHERE id = ?;
                """;
        return jdbcTemplate.update(sql,id);
    }

//    @Override
//    public int updateCharacter() {
//        return 0;
//    }


    public int getMax_cantrips_known() {
        return max_cantrips_known;
    }

    @Override
    public void setMax_cantrips_known(int cantrips) {
        this.max_cantrips_known = max_cantrips_known;
    }

//    @Override
    public int getMax_spells_known() {
        return max_spells_known;
    }

    @Override
    public void setMax_spells_known(int max_spells_known) {
        this.max_spells_known = max_spells_known;
    }

//    @Override
    public int getSpell_slot_1() {
        return spell_slot_1;
    }

    @Override
    public void setSpell_slot_1(int spell_slot_1) {
        this.spell_slot_1 = spell_slot_1;
    }

//    @Override
    public int getSpell_slot_2() {
        return spell_slot_2;
    }

    @Override
    public void setSpell_slot_2(int spell_slot_2) {
        this.spell_slot_2 = spell_slot_2;
    }

//    @Override
    public int getSpell_slot_3() {
        return spell_slot_3;
    }

    @Override
    public void setSpell_slot_3(int spell_slot_3) {
        this.spell_slot_3 = spell_slot_3;
    }

//    @Override
    public int getSpell_slot_4() {
        return spell_slot_4;
    }

    @Override
    public void setSpell_slot_4(int spell_slot_4) {
        this.spell_slot_4 = spell_slot_4;
    }

    //@Override
    public int getSpell_slot_5() {
        return spell_slot_5;
    }

    @Override
    public void setSpell_slot_5(int spell_slot_5) {
        this.spell_slot_5 = spell_slot_5;
    }

    //@Override
    public int getSpell_slot_6() {
        return spell_slot_6;
    }

    @Override
    public void setSpell_slot_6(int spell_slot_6) {
        this.spell_slot_6 = spell_slot_6;
    }

    //@Override
    public int getSpell_slot_7() {
        return spell_slot_7;
    }

    @Override
    public void setSpell_slot_7(int spell_slot_7) {
        this.spell_slot_7 = spell_slot_7;
    }

   //@Override
    public int getSpell_slot_8() {
        return spell_slot_8;
    }
    @Override
    public void setSpell_slot_8(int spell_slot_8) {
        this.spell_slot_8 = spell_slot_8;
    }

    //@Override
    public int getSpell_slot_9() {
        return spell_slot_9;
    }

    @Override
    public void setSpell_slot_9(int spell_slot_9) {
        this.spell_slot_9 = spell_slot_9;
    }

    //@Override
    public int getMax_spell_slot_1() {
        return max_spell_slot_1;
    }

    @Override
    public void setMax_spell_slot_1(int max_spell_slot_1) {
        this.max_spell_slot_1 = max_spell_slot_1;
    }

    //@Override
    public int getMax_spell_slot_2() {
        return max_spell_slot_2;
    }

    @Override
    public void setMax_spell_slot_2(int max_spell_slot_2) {
        this.max_spell_slot_2 = max_spell_slot_2;
    }

    //@Override
    public int getMax_spell_slot_3() {
        return max_spell_slot_3;
    }

    @Override
    public void setMax_spell_slot_3(int max_spell_slot_3) {
        this.max_spell_slot_3 = max_spell_slot_3;
    }

    //@Override
    public int getMax_spell_slot_4() {
        return max_spell_slot_4;
    }


    @Override
    public void setMax_spell_slot_4(int max_spell_slot_4) {
        this.max_spell_slot_4 = max_spell_slot_4;
    }

    //@Override
    public int getMax_spell_slot_5() {
        return max_spell_slot_5;
    }

    @Override
    public void setMax_spell_slot_5(int max_spell_slot_5) {
        this.max_spell_slot_5 = max_spell_slot_5;
    }

    //@Override
    public int getMax_spell_slot_6() {
        return max_spell_slot_6;
    }

    @Override
    public void setMax_spell_slot_6(int max_spell_slot_6) {
        this.max_spell_slot_6 = max_spell_slot_6;
    }

    //@Override
    public int getMax_spell_slot_7() {
        return max_spell_slot_7;
    }

    @Override
    public void setMax_spell_slot_7(int max_spell_slot_7) {
        this.max_spell_slot_7 = max_spell_slot_7;
    }

//    @Override
    public int getMax_spell_slot_8() {
        return max_spell_slot_8;
    }

    @Override
    public void setMax_spell_slot_8(int max_spell_slot_8) {
        this.max_spell_slot_8 = max_spell_slot_8;
    }


//    @Override
    public int getMax_spell_slot_9() {
        return max_spell_slot_9;
    }

    @Override
    public void setMax_spell_slot_9(int max_spell_slot_9) {
        this.max_spell_slot_9 = max_spell_slot_9;
    }
    public void putSpellSlots(Character character){
        createSpellSlotHashMap(character);
        Integer[] spellSlots = spellMap.get(character.getCharacter_level());
        System.out.println(character.getCharacter_level());
        System.out.println(spellMap);
        this.setMax_cantrips_known(spellSlots[0]);
        this.setMax_spells_known(spellSlots[1]);

        this.setMax_spell_slot_1(spellSlots[2]);
        this.setSpell_slot_1(spellSlots[2]);
        this.setMax_spell_slot_2(spellSlots[3]);
        this.setSpell_slot_2(spellSlots[3]);
        this.setMax_spell_slot_3(spellSlots[4]);
        this.setSpell_slot_3(spellSlots[4]);
        this.setMax_spell_slot_4(spellSlots[5]);
        this.setSpell_slot_4(spellSlots[5]);
        this.setMax_spell_slot_5(spellSlots[6]);
        this.setSpell_slot_5(spellSlots[6]);
        this.setMax_spell_slot_6(spellSlots[7]);
        this.setSpell_slot_6(spellSlots[7]);
        this.setMax_spell_slot_7(spellSlots[8]);
        this.setSpell_slot_7(spellSlots[8]);
        this.setMax_spell_slot_8(spellSlots[9]);
        this.setSpell_slot_8(spellSlots[9]);
        this.setMax_spell_slot_9(spellSlots[10]);
        this.setSpell_slot_9(spellSlots[10]);

    }
    private void createSpellSlotHashMap(Character character){

        this.spellMap = new HashMap<Integer,Integer[]>();


        DnDClass dnDClass = dnDClassController.getDnDClassesById(character.getClass_id())
                .orElseThrow(() ->
                        new ResourceNotFound("class_id does not match any class")
                );

        String name = dnDClass.getClass_name();


        if (name.equals("Sorcerer")) {
            spellMap.put(1, new Integer[]{4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0});
            spellMap.put(2, new Integer[]{4,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{4,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{5,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{5,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{5,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{5,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{5,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{5,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{6,11,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{6,12,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{6,13,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{6,14,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{6,15,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{6,15,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{6,15,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{6,15,4,3,3,3,3,2,2,1,1});

        } else if (name.equals("Bard")) {
            spellMap.put(1, new Integer[]{2,4,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,5,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,6,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,7,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,8,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,9,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,10,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,11,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,12,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{4,14,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{4,15,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{4,16,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{4,18,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{4,19,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{4,20,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{4,22,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{4,22,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{4,22,4,3,3,3,3,2,2,1,1});
        } else if (name.equals("Warlock")) {
            //Might have to add another row to characters for evocations
            spellMap.put(1, new Integer[]{2,2,1,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,3,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,4,0,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,5,0,2,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,6,0,0,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,7,0,0,2,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,8,0,0,0,2,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,9,0,0,0,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,10,0,0,0,0,2,0,0,0,0});
            spellMap.put(10, new Integer[]{4,10,0,0,0,0,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
            spellMap.put(12, new Integer[]{4,11,0,0,0,0,3,0,0,0,0});
            spellMap.put(13, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
            spellMap.put(14, new Integer[]{4,12,0,0,0,0,3,0,0,0,0});
            spellMap.put(15, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
            spellMap.put(16, new Integer[]{4,13,0,0,0,0,3,0,0,0,0});
            spellMap.put(17, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
            spellMap.put(18, new Integer[]{4,14,0,0,0,0,4,0,0,0,0});
            spellMap.put(19, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});
            spellMap.put(20, new Integer[]{4,15,0,0,0,0,4,0,0,0,0});

        } else if (name.equals("Ranger")) {
            spellMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{0,2,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{0,3,3,0,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{0,4,4,2,0,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(8, new Integer[]{0,5,4,3,0,0,0,0,0,0,0});
            spellMap.put(9, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(10, new Integer[]{0,6,4,3,2,0,0,0,0,0,0});
            spellMap.put(11, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(12, new Integer[]{0,7,4,3,3,0,0,0,0,0,0});
            spellMap.put(13, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(14, new Integer[]{0,8,4,3,3,1,0,0,0,0,0});
            spellMap.put(15, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(16, new Integer[]{0,9,4,3,3,2,0,0,0,0,0});
            spellMap.put(17, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(18, new Integer[]{0,10,4,3,3,3,1,0,0,0,0});
            spellMap.put(19, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});
            spellMap.put(20, new Integer[]{0,11,4,3,3,3,2,0,0,0,0});


        } else if (name.equals("Cleric")) {
            spellMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,1});
            spellMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});


        } else if (name.equals("Druid")) {
            spellMap.put(1, new Integer[]{2,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{2,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{2,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{3,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{3,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{3,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{3,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{3,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{3,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{4,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{4,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{4,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{4,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(18, new Integer[]{4,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{4,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{4,0,4,3,3,3,3,2,2,1,1});

        } else if (name.equals("Paladin")) {
            spellMap.put(1, new Integer[]{0,0,0,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{0,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{0,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{0,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(8, new Integer[]{0,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(9, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(10, new Integer[]{0,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(11, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(12, new Integer[]{0,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(13, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(14, new Integer[]{0,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(15, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(16, new Integer[]{0,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(17, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(18, new Integer[]{0,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(19, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(20, new Integer[]{0,0,4,3,3,3,2,0,0,0,0});

        } else if (name.equals("Wizard")) {
            spellMap.put(1, new Integer[]{3,0,2,0,0,0,0,0,0,0,0});
            spellMap.put(2, new Integer[]{3,0,3,0,0,0,0,0,0,0,0});
            spellMap.put(3, new Integer[]{3,0,4,2,0,0,0,0,0,0,0});
            spellMap.put(4, new Integer[]{4,0,4,3,0,0,0,0,0,0,0});
            spellMap.put(5, new Integer[]{4,0,4,3,2,0,0,0,0,0,0});
            spellMap.put(6, new Integer[]{4,0,4,3,3,0,0,0,0,0,0});
            spellMap.put(7, new Integer[]{4,0,4,3,3,1,0,0,0,0,0});
            spellMap.put(8, new Integer[]{4,0,4,3,3,2,0,0,0,0,0});
            spellMap.put(9, new Integer[]{4,0,4,3,3,3,1,0,0,0,0});
            spellMap.put(10, new Integer[]{5,0,4,3,3,3,2,0,0,0,0});
            spellMap.put(11, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(12, new Integer[]{5,0,4,3,3,3,2,1,0,0,0});
            spellMap.put(13, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(14, new Integer[]{5,0,4,3,3,3,2,1,1,0,0});
            spellMap.put(15, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(16, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(17, new Integer[]{5,0,4,3,3,3,2,1,1,1,0});
            spellMap.put(18, new Integer[]{5,0,4,3,3,3,3,1,1,1,1});
            spellMap.put(19, new Integer[]{5,0,4,3,3,3,3,2,1,1,1});
            spellMap.put(20, new Integer[]{5,0,4,3,3,3,3,2,2,1,1});

        } else {
            System.out.println("This is the problem");
        }


    }
}
