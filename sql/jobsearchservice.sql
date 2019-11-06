CREATE TABLE "user" (
    id   BIGSERIAL,
    email VARCHAR,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE "employer" (
    id BIGINT NOT NULL,
    company_name VARCHAR NOT NULL,
    feedback VARCHAR,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE "worker" (
    id BIGINT NOT NULL,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES "user" (id) ON DELETE CASCADE
);

create table user_role
(
    user_id BIGINT NOT NULL,
    roles   VARCHAR(255),
    foreign key (user_id) REFERENCES "user" (id)
);

create table "summary"
(
	id BIGSERIAL,
	worker_id BIGINT,
	mobile_phone VARCHAR(255),
	city VARCHAR(255),
	date_of_birth TIMESTAMP,
	sex VARCHAR(255),
	work_experience VARCHAR(255),
	educational_institution VARCHAR(255),
	career_objective VARCHAR(255),
	desired_salary INTEGER,
	date TIMESTAMP,
	state VARCHAR(20),
	PRIMARY KEY (id),
	FOREIGN KEY (worker_id) REFERENCES "worker"(id)
);

create table skills
(
    title      VARCHAR(255) NOT NULL,
    summary_id BIGINT,
    primary key (title),
    foreign key (summary_id) REFERENCES "summary"(id)
);

create table "vacancy"
(
	id BIGSERIAL,
	employer_id BIGINT,
	category VARCHAR(255),
	necessary_experience VARCHAR(255),
	salary INTEGER,
	date TIMESTAMP,
	state VARCHAR(20),
	PRIMARY KEY(id),
	FOREIGN KEY(employer_id) REFERENCES "employer"(id)
);

create table "requirements"
(
    title      VARCHAR(255) NOT NULL,
    vacancy_id BIGINT,
    primary key (title),
    foreign key (vacancy_id) REFERENCES "vacancy"(id)
);




