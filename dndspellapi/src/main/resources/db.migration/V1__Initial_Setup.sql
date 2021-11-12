CREATE TABLE schools (id SERIAL PRIMARY KEY, school_name TEXT NOT NULL, school_description TEXT NOT NULL);

CREATE TABLE spells (id BIGSERIAL PRIMARY KEY,
    spell_name TEXT NOT NULL,
    spell_level INT NOT NULL,
    school_id INT NOT NULL REFERENCES schools(id),
    range TEXT,
    components TEXT,
    duration TEXT,
    ritual BOOLEAN,
    description TEXT,
    higher_level TEXT
    );

CREATE TABLE dndclasses (id SERIAL PRIMARY KEY, class_name TEXT, class_description TEXT);
CREATE TABLE dndraces (id SERIAL PRIMARY KEY, race_name TEXT, race_description TEXT);

CREATE TABLE characters (id BIGSERIAL PRIMARY KEY ,
    class_id INT NOT NULL REFERENCES dndclasses(id),
    race_id INT NOT NULL REFERENCES dndraces(id),
    character_level INT NOT NULL,
    name TEXT NOT NULL,
    max_cantrips_known INT NOT NULL,
    max_spells_known int NOT NULL,
    spell_slot_1 INT NOT NULL,
    spell_slot_2 INT NOT NULL,
    spell_slot_3 INT NOT NULL,
    spell_slot_4 INT NOT NULL,
    spell_slot_5 INT NOT NULL,
    spell_slot_6 INT NOT NULL,
    spell_slot_7 INT NOT NULL,
    spell_slot_8 INT NOT NULL,
    spell_slot_9 INT NOT NULL,
    max_spell_slot_1 INT NOT NULL,
    max_spell_slot_2 INT NOT NULL,
    max_spell_slot_3 INT NOT NULL,
    max_spell_slot_4 INT NOT NULL,
    max_spell_slot_5 INT NOT NULL,
    max_spell_slot_6 INT NOT NULL,
    max_spell_slot_7 INT NOT NULL,
    max_spell_slot_8 INT NOT NULL,
    max_spell_slot_9 INT NOT NULL
    );

CREATE TABLE character_spells (id BIGSERIAL PRIMARY KEY,
    character_id BIGINT NOT NULL REFERENCES characters(id),
    spell_id BIGINT NOT NULL REFERENCES spells(id)
    );


