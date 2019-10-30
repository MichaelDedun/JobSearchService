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
	desired_salary INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (worker_id) REFERENCES "worker"(id)
);


