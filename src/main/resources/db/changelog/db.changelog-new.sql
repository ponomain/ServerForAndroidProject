--liquibase formatted sql

--changeset Nikolai Ponomarev:1
DROP TABLE WORD_MODEL_ENTITY;

CREATE TABLE IF NOT EXISTS WORD_MODEL_ENTITY (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    word_description VARCHAR(255) NOT NULL,
    liked_by_me BOOLEAN DEFAULT FALSE,
    image VARCHAR(255) NOT NULL,
    word_type VARCHAR(20) NOT NULL
);

--changeset Nikolai Ponomarev:2
INSERT INTO WORD_MODEL_ENTITY (title, liked_by_me, word_description, image, word_type)
VALUES ('Кринж', false, 'описание', 'описание', 'ZOOMERS'),
       ('Имба', false, 'описание', 'описание', 'ZOOMERS'),
       ('Рофлить', false, 'описание', 'описание', 'ZOOMERS'),
       ('Краш', false, 'описание', 'описание', 'ZOOMERS'),
       ('Флексить', false, 'описание', 'описание', 'ZOOMERS'),
       ('Ауф', false, 'описание', 'описание', 'ZOOMERS'),
       ('Форсить', false, 'описание', 'описание', 'ZOOMERS'),
       ('Дед инсайд', false, 'описание', 'описание', 'ZOOMERS'),
       ('Агриться', false, 'описание', 'описание', 'ZOOMERS'),
       ('Буллинг', false, 'описание', 'описание', 'ZOOMERS'),
       ('Скам', false, 'описание', 'описание', 'ZOOMERS'),
       ('Шипперить', false, 'описание', 'описание', 'ZOOMERS'),
       ('POV, или ПОВ', false, 'описание', 'описание', 'ZOOMERS'),
       ('Рофл', false, 'описание', 'описание', 'ZOOMERS'),
       ('Сабж', false, 'описание', 'описание', 'ZOOMERS'),
       ('Свэг', false, 'описание', 'описание', 'ZOOMERS'),
       ('Симп', false, 'описание', 'описание', 'ZOOMERS'),
       ('Стэнить', false, 'описание', 'описание', 'ZOOMERS'),
       ('Тильт', false, 'описание', 'описание', 'ZOOMERS'),
       ('Треш', false, 'описание', 'описание', 'ZOOMERS'),
       ('Хайп', false, 'описание', 'описание', 'ZOOMERS');