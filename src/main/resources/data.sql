TRUNCATE TABLE dish;
TRUNCATE TABLE vote;
DELETE FROM users;
DELETE FROM restaurant;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name)
VALUES ('User1'),--100000
       ('User2'),--100001
       ('User3'),--100002
       ('Admin');
--100003

-- INSERT INTO user_roles (role, user_id)
-- VALUES ('USER', 100000),
--        ('ADMIN', 100001);

INSERT INTO restaurant (name)
VALUES ('Thai Rest'),--100004
       ('Matreshka'),--100005
       ('Italian street');--100006

INSERT INTO dish (name, price, dish_date, restaurant_id)
VALUES ('Tom Yum Gung', 120, '2023-01-13 10:00:00', 100004),
       ('Som tam boo', 80, '2023-01-13 10:00:00', 100004),
       ('Mango sticky rice', 30, '2023-01-13 10:00:00', 100004),
       ('Tom Yum Gung', 120, '2023-01-15 10:00:00', 100004),
       ('Som tam boo', 80, '2023-01-15 10:00:00', 100004),
       ('Mango sticky rice', 30, '2023-01-15 10:00:00', 100004),
       ('Gang Som Pak Ruam', 180, CURRENT_TIMESTAMP, 100004),
       ('Pad Thai', 100, CURRENT_TIMESTAMP, 100004),
       ('Gang Keow Wan', 50, CURRENT_TIMESTAMP, 100004),

       ('Borch', 150, '2023-01-13 10:00:00', 100005),
       ('Fried potato', 80, '2023-01-13 10:00:00', 100005),
       ('Moscow cake', 130, '2023-01-13 10:00:00', 100005),
       ('Borch', 150, '2023-01-15 10:00:00', 100005),
       ('Fried potato', 80, '2023-01-15 10:00:00', 100005),
       ('Moscow cake', 130, '2023-01-15 10:00:00', 100005),
       ('Ocroshka', 130, CURRENT_TIMESTAMP, 100005),
       ('Baked pumpkin', 110, CURRENT_TIMESTAMP, 100005),
       ('Pancake with salmon', 250, CURRENT_TIMESTAMP, 100005),

       ('Minestrone', 90, '2023-01-13 10:00:00', 100006),
       ('Pasta carbonara', 120, '2023-01-13 10:00:00', 100006),
       ('Pizza', 170, '2023-01-13 10:00:00', 100006),
       ('Ravioli', 130, CURRENT_TIMESTAMP, 100006),
       ('Lasagna', 100, CURRENT_TIMESTAMP, 100006),
       ('Tiramisu', 150, CURRENT_TIMESTAMP, 100006);

INSERT INTO vote (date_time, restaurant_id, user_id)
VALUES ('2023-01-13 10:00:00', 100004, 100000),
       ('2023-01-13 12:00:00', 100005, 100001),
       ('2023-01-13 11:00:00', 100006, 100002),
       ('2023-01-13 11:30:00', 100005, 100003),
       ('2023-01-15 10:00:00', 100004, 100000),
       ('2023-01-15 12:10:00', 100005, 100001),
       ('2023-01-15 11:00:00', 100005, 100002),
       ('2023-01-15 11:10:00', 100005, 100003),
       (CURRENT_TIMESTAMP, 100004, 100000),
       (CURRENT_TIMESTAMP, 100004, 100001),
       (CURRENT_TIMESTAMP, 100006, 100002),
       (CURRENT_TIMESTAMP, 100006, 100003);

