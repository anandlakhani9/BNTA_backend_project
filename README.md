# BNTA_backend_project

## Schedule

Thursday Morning - Set up basic Spring project and sql tables (+ design) - Rose, Oliver, Anand, Sabi (mob code)

Thursday Afternoon - Set up School Package and all of the School, SchoolController, SchoolService exr. - Oliver, Rose, Anand, Sabi (Mob code)

Friday Morning - Finished School Package and tested functionality within ThunderClient - Oliver, Rose, Anand, Sabi (Mob Code

Friday Afternoon - Attempted unit testing, to be continued... / created documentation

Monday Morning - Unit Test for SchoolsDataAccess Service Completed(pair coded - Anand/Oliver). DndClasses(Rose) and DndRaces(Sabi) also completed.

Mornday Afternoon - Null pointer exceptions added (mob coded - Rose, Sabi, Anand and Oliver) as well as the Spells(pair coded - Anande/Oliver) and Character classes (pair coded - Sabi/Rose).

Tuesday Morning - 

Tuesday Afternoon - Anand solo coding character_spells package

Wednesday Morning - Anand continued solo coding character_spells package

Wednesday Afternoon -


##SET-UP

FIRST THING YOU MUST DO: CHANGE V2_INSERT_SPELLS IN RESOURCES/DB.MIGRATION TO DIRECT TO WHERE SPELL_DATA2.CSV DIRRECTS IN YOUR LOCAL FOLDER DO THIS BY RIGHT CLICKING ON DPELL_DATA2.CSV AND COPYING ABSOLUTE FILE PATH.

## Our API
### Schools
Get all schools: api/v1/schools

Get school by id: api/v1/schools/1

Get school by name: api/v1/schools/name=necromancy

Post to schools database: send json to eg. 

Update schools by: name url eg. api/v1/schools/name=necromancy

Delete schools by: 

#### DNDClasses api
GET: localhost:8080/api/v1/dndclasses

GET BY ID: localhost:8080/api/v1/dndclasses/1

GET BY NAME: localhost:8080/api/v1/dndclasses/name=Bard

POST: localhost:8080/api/v1/dndclasses

Provide JSON in form: 
{
"class_name": "Fighter",
"class_description": "Strengths include weapons"
}


PUT: localhost:8080/api/v1/dndclasses/1?class_name=Fighter&class_description=one%20fighty%20boy

PUT: localhost:8080/api/v1/dndclasses/1?class_description=one%20fighty%20boy

PUT: localhost:8080/api/v1/dndclasses/1?class_name=Fighter

DELETE: PUT: (by id) localhost:8080/api/v1/dndclasses/1 where 1 is the id

#### DNDRaces api

GET BY ID: localhost:8080/api/v1/races

GET BY NAME: localhost:8080/api/v1/races/1

GET:localhost:8080/api/v1/races/name=Dwarf

POST: localhost:8080/api/v1/races


Provide JSON in the form

{
"race_name": "Goblin",
"race_description": 
}

DELETE: (by id) localhost:8080/api/v1/races/1 where 1 is the id

#### DNDSchools api
GET: localhost:8080/api/v1/schools

GET BY ID: localhost:8080/api/v1/schools/1

GET BY NAME: localhost:8080/api/v1/schools/name=Divination

POST: localhost:8080/api/v1/schools

Provide JSON in form:

{
"school_name": "Sparkly",
"school_description": "It sparkles"
}

PUT: localhost:8080/api/v1/schools/1?school_name=Sparkly&school_description=It%20sparkles where 1 is id

PUT: localhost:8080/api/v1/schools/1?school_description=It%20sparkles where 1 is id

PUT: localhost:8080/api/v1/schools/1?school_name=Sparkly where 1 is id

DELETE by ID: localhost:8080/api/v1/schools/1 where 1 is id

#### DND Spells api

GET: localhost:8080/api/v1/spells

GET BY ID: localhost:8080/api/v1/spells/1

GET BY NAME: localhost:8080/api/v1/spells/name=Conjure%20Fey


#### DNDCharacters api

GET BY ID: localhost:8080/api/v1/characters

GET BY NAME:localhost:8080/api/v1/characters/1

POST: localhost:8080/api/v1/dndclasses

Provide JSON in form:

{
"race_id": 3,
"class_id": 5,
"name": "Clarisse",
"character_level": 4

}
Note bug to do with updating character level DOES NOT update spell slots

#### DND spellbook api
GET (by character id): localhost:8080/spellbook/1 where 1 is the character id

POST: localhost:8080/spellbook

provide JSON in form:

{
"characterID": 1,
"spellID": 17,
"spellIsKnown": true
}

DELETE: (by character_spell id): localhost:8080/spellbook/1 where 1 is the character_spell id