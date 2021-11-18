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
    higher_level TEXT,
    canSorcerer BOOLEAN,
    canWizard BOOLEAN,
    canWarlock BOOLEAN,
    canBard BOOLEAN,
    canPaladin BOOLEAN,
    canDruid BOOLEAN,
    canCleric BOOLEAN,
    canRanger BOOLEAN
    );

CREATE TABLE dndclasses (id SERIAL PRIMARY KEY, class_name TEXT, class_description TEXT);
CREATE TABLE dndraces (id SERIAL PRIMARY KEY, race_name TEXT, race_description TEXT);

CREATE TABLE characters (id BIGSERIAL PRIMARY KEY ,
    class_id INT NOT NULL REFERENCES dndclasses(id),
    race_id INT NOT NULL REFERENCES dndraces(id),
    character_level INT NOT NULL,
    name TEXT NOT NULL,
    cantrips_known INT NOT NULL,
    max_cantrips_known INT NOT NULL,
    spells_known INT NOT NULL,
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
    max_spell_slot_9 INT NOT NULL,
    max_ivocations_known INT NOT NULL

    );

CREATE TABLE character_spells (id BIGSERIAL PRIMARY KEY,
    character_id BIGINT NOT NULL REFERENCES characters(id),
    spell_id BIGINT NOT NULL REFERENCES spells(id),
    spell_is_known BOOLEAN NOT NULL
    );

INSERT INTO schools (school_name, school_description)
VALUES ('Abjuration','Spells are protective in  nature, though some of them  have aggressive uses. They create magical barriers, negate harmful effects,  harm trespassers, or banish creatures to other planes of existence.');
INSERT INTO schools (school_name, school_description)
VALUES ('Conjuration','Spells involve the transportation of objects and creatures from one location to another. Some spells summon creatures or objects to the caster’s side, whereas others allow the caster to teleport to another location. Some conjurations create objects or effects out of nothing. Divination spells reveal information, whether in the form of secrets long forgotten, glimpses of the future, the locations of hidden things, the truth behind illusions, or visions of distant people or places.');
INSERT INTO schools (school_name, school_description)
VALUES ('Enchantment','Spells affect the minds of others, influencing or controlling their behavior. Such spells can  make enemies see the caster as a friend, force creatures to take a course of action, or even control another creature like a puppet.');
INSERT INTO schools (school_name, school_description)
VALUES ('Evocation','Spells manipulate magical energy to produce a desired effect. Some call  up blasts of fire or lightning. Others channel positive energy to heal wounds.');
INSERT INTO schools (school_name, school_description)
VALUES ('Illusion','Spells deceive the senses or minds of others. They cause people to see things that are not there, to miss things that are there, to hear phantom noises, or to remember things that never happened. Some illusions create phantom images that any creature can see,  but the most insidious illusions plant an image directly in the mind of a creature.');
INSERT INTO schools (school_name, school_description)
VALUES ('Necromancy','Spells manipulate the energies of life and death. Such spells can grant an extra reserve of life force, drain the life energy from another creature, create the undead, or even  bring the dead back to life. Creating the undead through the use of necromancy spells such as animate dead is not a good act, and only evil casters use such spells frequently.');
INSERT INTO schools (school_name, school_description)
VALUES ('Transmutation','Spells change the properties of a creature, object, or environment. They might turn an enemy into a harmless creature, bolster the strength of an ally, make an object move at the caster’s command, or enhance a creature’s innate healing abilities to rapidly recover from injury.');

INSERT INTO dndclasses (class_name, class_description)
VALUES ('Bard','An inspiring magician whose power echoes the music of creation.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Cleric','A priestly champion who wields divine magic in service of a higher power.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Druid','A priest of the Old  Faith, wielding the powers of nature, moonlight and plant growth, fire and lightning, and adopting animal forms.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Paladin','A holy warrior bound to a sacred oath.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Sorcerer','A spellcaster who draws on inherent magic from a gift or bloodline.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Warlock','A wielder of magic that is derived from a bargain with an extraplanar entity');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Wizard','A scholarly magic-user capable of manipulating the structures of reality.');
INSERT INTO dndclasses (class_name, class_description)
VALUES ('Ranger','A warrior who uses  martial prowess and nature magic to combat threats on the edges of civilization.');

INSERT INTO dndraces (race_name, race_description)
VALUES ('Dwarf','Short');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Halfling','Small');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Half-Elf','Diplomats');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Human','Powerful');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Elf','Slender');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Dragonborn','Dragon');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Half-Orc','Strong');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Tiefling','Suspicious');
INSERT INTO dndraces (race_name, race_description)
VALUES ('Gnome','Vibrant');







