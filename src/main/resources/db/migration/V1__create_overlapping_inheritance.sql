CREATE SEQUENCE IF NOT EXISTS phone_number_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE author
(
    author_id   VARCHAR(255)  NOT NULL,
    birth_date  date          NOT NULL,
    death_date  date,
    debut_date  date          NOT NULL,
    biography   VARCHAR(1000) NOT NULL,
    nationality VARCHAR(255)  NOT NULL,
    person_id   VARCHAR(255)  NOT NULL,
    CONSTRAINT pk_author PRIMARY KEY (author_id)
);

CREATE TABLE librarian
(
    worker_id       VARCHAR(255) NOT NULL,
    employment_date date         NOT NULL,
    work_change     VARCHAR(255) NOT NULL,
    person_id       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_librarian PRIMARY KEY (worker_id)
);

CREATE TABLE person
(
    person_id VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL,
    surname   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

CREATE TABLE phone_number
(
    id        BIGINT       NOT NULL,
    number    VARCHAR      NOT NULL,
    reader_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_phonenumber PRIMARY KEY (id)
);

CREATE TABLE reader
(
    library_card_number VARCHAR(255) NOT NULL,
    registration_date   date         NOT NULL,
    person_id           VARCHAR(255) NOT NULL,
    CONSTRAINT pk_reader PRIMARY KEY (library_card_number)
);

ALTER TABLE author
    ADD CONSTRAINT uc_author_person UNIQUE (person_id);

ALTER TABLE librarian
    ADD CONSTRAINT uc_librarian_person UNIQUE (person_id);

ALTER TABLE reader
    ADD CONSTRAINT uc_reader_person UNIQUE (person_id);

ALTER TABLE author
    ADD CONSTRAINT FK_AUTHOR_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (person_id);

ALTER TABLE librarian
    ADD CONSTRAINT FK_LIBRARIAN_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (person_id);

ALTER TABLE phone_number
    ADD CONSTRAINT FK_PHONENUMBER_ON_READER FOREIGN KEY (reader_id) REFERENCES reader (library_card_number);

ALTER TABLE reader
    ADD CONSTRAINT FK_READER_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (person_id);