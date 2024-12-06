-- example data (only used in the tests)
INSERT INTO Car(id, model, brand)
VALUES(nextval('car_sequence'), 'AMG GT', 'Mercedes');
INSERT INTO Car(id, model, brand)
VALUES(nextval('car_sequence'), 'A8', 'Audi');
INSERT INTO Car(id, model, brand)
VALUES(nextval('car_sequence'), 'Wraith', 'Rolls Royce');