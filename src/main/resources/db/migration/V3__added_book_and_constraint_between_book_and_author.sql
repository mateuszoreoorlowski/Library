CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS genre_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS language_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE book
(
    book_id          BIGINT       NOT NULL,
    isbn             BIGINT       NOT NULL,
    title            VARCHAR(255) NOT NULL,
    pages            INTEGER      NOT NULL,
    publication_date date         NOT NULL,
    jezyk            VARCHAR(255) NOT NULL,
    language_id      BIGINT,
    description      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (book_id)
);

CREATE TABLE book_author
(
    author_id VARCHAR(255) NOT NULL,
    book_id   BIGINT       NOT NULL
);

CREATE TABLE genre
(
    genre_id BIGINT       NOT NULL,
    name     VARCHAR(255) NOT NULL,
    book_id  BIGINT,
    CONSTRAINT pk_genre PRIMARY KEY (genre_id)
);

CREATE TABLE language
(
    language_id BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);

ALTER TABLE book
    ADD CONSTRAINT uc_book_language UNIQUE (language_id);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_LANGUAGE FOREIGN KEY (language_id) REFERENCES language (language_id);

ALTER TABLE genre
    ADD CONSTRAINT FK_GENRE_ON_BOOK FOREIGN KEY (book_id) REFERENCES book (book_id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_author FOREIGN KEY (author_id) REFERENCES author (author_id);

ALTER TABLE book_author
    ADD CONSTRAINT fk_booaut_on_book FOREIGN KEY (book_id) REFERENCES book (book_id);