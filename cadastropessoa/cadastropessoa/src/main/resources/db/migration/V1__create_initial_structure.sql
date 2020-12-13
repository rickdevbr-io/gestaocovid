CREATE sequence sq_symptom_symp;
CREATE sequence sq_region_regi;
CREATE sequence sq_person_pers;
CREATE sequence sq_person_symptom_pesy;

create table tb_symptom_symp(
	id_symptom int8 NOT NULL,
	st_description varchar(100) NOT NULL,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_symptoms_pkey PRIMARY KEY (id_symptom)
);

create table tb_region_regi(
	id_region int8 NOT NULL,
	st_description varchar(100) NOT NULL,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_region_pkey PRIMARY KEY (id_region)
);

create table tb_person_pers(
	id_person int8 NOT NULL,
	st_name varchar(100) NOT NULL,
	st_identification varchar(11) NOT NULL,
	st_gender char(1) NOT NULL,
	dt_born date,
	id_region int8,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_person_pkey PRIMARY KEY (id_person)
);

create table tb_person_symptom_pesy(
	id_person_symptom int8 NOT NULL,
	id_person int8 NOT NULL,
	id_symptom int8 NOT NULL,
	dt_created_date timestamp NOT NULL,
	CONSTRAINT tb_person_symptom_pkey PRIMARY KEY (id_person_symptom)
);