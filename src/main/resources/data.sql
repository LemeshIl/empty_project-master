INSERT INTO House (id, version, address) VALUES (1, 0, 'ул.Цюрупы, 16');

INSERT INTO House (id, version, address) VALUES (2, 0, 'ул.Лунина, 7');

INSERT INTO Person (id, version, first_name, age) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Person (id, version, first_name, age) VALUES (2, 0, 'John', 25);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 1);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 2);

INSERT INTO ORGANIZATION (ID, NAME, FULL_NAME, INN, KPP, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_ORGANIZATION.nextval, 'starOrg', 'Саратовские авиалинии', '454555', '5600114', 'г.Саратов, ул.Ленина,57', '884526558', 1);

INSERT INTO ORGANIZATION (ID, NAME, FULL_NAME, INN, KPP, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_ORGANIZATION.nextval, 'tourOut', 'Туристическая компания', '111222', '5896321', 'г. Москва, ул. Набережная,20', '945225488', 1);

INSERT INTO ORGANIZATION (ID, NAME, FULL_NAME, INN, KPP, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_ORGANIZATION.nextval, 'teploTek', 'Комерческая фирма', '224466', '5554441', 'г. Орел, ул. Победы,2', '888666521', 1);

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '1', 'SarOfficeOne', 'г. Саратов ул. Пушкина, 51',
'256333', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '1', 'SarOfficeTwo', 'г. Саратов ул. Кирова, 66',
'256111', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '2', 'MosOffice', 'г. Москва ул. Верхняя, 66',
'205555', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '2', 'MosOfficeTwo', 'г. Москва ул. Попова, 74',
'555656', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '2', 'MosOfficeThree', 'г. Москва ул. Рахова, 20',
'474747', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '3', 'OrOfficeOne', 'г. Орел ул. Зимняя, 26',
'222111', '1');

INSERT INTO OFFICE (ID, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE) VALUES (SEQ_OFFICE.nextval, '3', 'OrOfficeTwo', 'г. Орел ул. Михайлова, 7',
'777666', '1');

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('1', 'Сергей', 'Иванович', 'Сочнев', 'менеджер', '999999',
'паспорт', '702', '25.07.90', 'Россия', '64', '1', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('2', 'Александр', 'Александр', 'Киселев', 'диспетчер',
'999991', 'паспорт', '701', '24.05.87', 'Россия', '63', '1', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('3', 'Михаил', 'Сергеевич', 'Светлов', 'менеджер',
'999990', 'паспорт', '609', '23.05.76', 'Россия', '60', '2', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('4', 'Андрей', 'Иванович', 'Свердлов', 'менеджер',
'666669', 'паспорт', '608', '15.08.68', 'Россия', '22', '2', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('5', 'Владимир', 'Владимирович', 'Емелин', 'менеджер',
'666668', 'паспорт', '607', '22.06.80', 'Россия', '23', '3', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('6', 'Сергей', 'Анатольевыич', 'Кац', 'менеджер', '666667',
'паспорт', '606', '15.11.83', 'Россия', '26', '3', 1);

INSERT INTO  USER_BELL  (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('7', 'Стас', 'Алексеевич', 'Милов', 'менеджер', '666665',
'паспорт', '601', '15.08.81', 'Россия', '54', '4', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('8', 'Алексей', 'Михайлович', 'Пономарев', 'менеджер',
'666664', 'паспорт', '509', '25.11.86', 'Россия', '55', '5', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('9', 'Андрей', 'Петрович', 'Вилков', 'менеджер', '666663',
'паспорт', '508', '24.12.82', 'Россия', '50', '5', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('10', 'Евгений', 'Ильич', 'Сорокин', 'менеджер', '666662',
'паспорт', '507', '28.04.77', 'Россия', '53', '6', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('11', 'Руслан', 'Иванович', 'Попов', 'менеджер', '555559',
'паспорт', '505', '28.11.79', 'Россия', '52', '6', 1);

INSERT INTO USER_BELL (ID, FIRST_NAME, SECOND_NAME, MIDDLE_NAME, POSITION, PHONE, DOC_NAME, DOC_NUMBER, DOC_DATE,
CITIZENSHIP_NAME, CITIZENSHIP_CODE, OFFICE_ID, IS_IDENTIFIED) VALUES ('12', 'Игорь', 'Владимирович', 'Давлетов', 'менеджер',
'555558', 'паспорт', '504', '25.05.85', 'Россия', '51', '7', 1);

