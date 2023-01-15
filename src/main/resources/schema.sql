--DROP TABLE user_roles IF EXISTS;
DROP TABLE IF EXISTS dish;
DROP TABLE IF EXISTS voite;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurant;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id   BIGINT DEFAULT NEXT VALUE FOR global_seq PRIMARY KEY,
    name VARCHAR NOT NULL
);
-- CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

-- CREATE TABLE user_roles
-- (
--     user_id INTEGER NOT NULL,
--     role    VARCHAR NOT NULL,
--     CONSTRAINT user_roles_idx UNIQUE (user_id, role),
--     FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
-- );

CREATE TABLE restaurant
(
    id   BIGINT DEFAULT NEXT VALUE FOR global_seq PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE dish
(
    id   BIGINT DEFAULT NEXT VALUE FOR global_seq PRIMARY KEY,
    name          VARCHAR   NOT NULL,
    restaurant_id INTEGER   NOT NULL,
    dish_date     TIMESTAMP NOT NULL,
    price         INT       NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE
);
--CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals (user_id, date_time);

CREATE TABLE voite
(
    id   BIGINT DEFAULT NEXT VALUE FOR global_seq PRIMARY KEY,
    restaurant_id INTEGER   NOT NULL,
    user_id       INTEGER   NOT NULL,
    date_time     TIMESTAMP NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
--CREATE INDEX meals_unique_user_datetime_idx ON meals (user_id, date_time);
