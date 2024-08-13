CREATE SEQUENCE IF NOT EXISTS publishment_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE publishment
(
    publishment_id   BIGINT       NOT NULL,
    publishment_name VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL,
    phone_number_id  BIGINT,
    publishment_date date         NOT NULL,
    CONSTRAINT pk_publishment PRIMARY KEY (publishment_id)
);

ALTER TABLE phone_number
    ADD publishment_id BIGINT;

ALTER TABLE phone_number
    ALTER COLUMN publishment_id SET NOT NULL;

ALTER TABLE phone_number
    ADD CONSTRAINT uc_phonenumber_publishment UNIQUE (publishment_id);

ALTER TABLE publishment
    ADD CONSTRAINT uc_publishment_phone_number UNIQUE (phone_number_id);

ALTER TABLE phone_number
    ADD CONSTRAINT FK_PHONENUMBER_ON_PUBLISHMENT FOREIGN KEY (publishment_id) REFERENCES publishment (publishment_id);

ALTER TABLE publishment
    ADD CONSTRAINT FK_PUBLISHMENT_ON_PHONE_NUMBER FOREIGN KEY (phone_number_id) REFERENCES phone_number (id);