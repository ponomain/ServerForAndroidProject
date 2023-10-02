--liquibase formatted sql

--changeset Nikolai Ponomarev:1
-- Delete the record with title 'Дед инсайд'
DELETE FROM WORD_MODEL_ENTITY WHERE title = 'Дед инсайд';

-- Delete the record with title 'POV, или ПОВ'
DELETE FROM WORD_MODEL_ENTITY WHERE title = 'POV, или ПОВ';