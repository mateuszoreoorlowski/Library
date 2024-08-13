CREATE SEQUENCE IF NOT EXISTS address_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE address
(
    address_id      BIGINT       NOT NULL,
    street          VARCHAR(255) NOT NULL,
    building_number INTEGER      NOT NULL,
    flat_number     INTEGER      NOT NULL,
    city            VARCHAR(255) NOT NULL,
    postal_code     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (address_id)
);

ALTER TABLE reader
    ADD CONSTRAINT FK_READER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (address_id);