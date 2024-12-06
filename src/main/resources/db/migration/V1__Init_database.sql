CREATE SEQUENCE car_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE car
(
    id         BIGINT NOT NULL PRIMARY KEY,
    model      VARCHAR(255),
    brand      VARCHAR(255),
    created_at TIMESTAMPTZ
);