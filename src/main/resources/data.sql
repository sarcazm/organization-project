INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active) VALUES
(1, 0, 'Ромашка', 'ООО Ромашка', '9578457445', '440010101', 'Moscow', '4955748596', true),
(2, 0, 'Ангстрем', 'ООО Ангстрем', '9907445724', '444000101', 'Saratov', '8452748596', true),
(3, 0, 'Миландр ЭК', 'АО Миландр ЭК', '1234567890', '400122460', 'St Petersburg', '8125521420', true);


INSERT INTO Office (id, version, organization_id, name, address, phone, is_active) VALUES
(1, 0, 3, 'Миландр ЭК-2', 'St Petersburg, Panfilova, 1', '8127448587', false),
(2, 0, 3, 'Миландр ЭК-1', 'St Petersburg, Proletarskaya, 9', '8127448586', true),
(3, 0, 1, 'Ромашка-1', 'Moscow, Gogolya, 1к2', '4957411230', true),
(4, 0, 2, 'Ангстрем-25', 'Saratov, Popova, 18', '8452748590', true),
(5, 0, 2, 'Ангстрем-27', 'Saratov, Golikova, 13', '8452748591', false);


INSERT INTO Doc (id, version, name, code) VALUES
(1, 0, 'Паспорт гражданина РФ', 21),
(2, 0, 'Вид на жительство РФ', 12),
(3, 0, 'Загранпаспорт гражданина РФ', 22),
(4, 0, 'Военный билет', 07);


INSERT INTO Country (id, version, name, code) VALUES
(1, 0, 'Россия', 643),
(2, 0, 'Венгрия', 348),
(3, 0, 'Израиль', 376),
(4, 0, 'Индия', 356);


INSERT INTO User (id, version, office_id, first_name, second_name, last_name, middle_name, position, phone, is_identified, country_id) VALUES
(1, 0, 2, 'Michael', 'Ivanovich', 'Aristov', '-', 'Java Developer', '9166324512', true, 1),
(2, 0, 4, 'Irina', 'Vladimirovna', 'Konkova', '-', 'C++ Developer', '9096447577', true, 1),
(3, 0, 3, 'Elena', 'Vladimirovna', 'Volkova', '-', 'Manager', '9265541230', true, 1);


INSERT INTO User_Doc (id, version, user_id, doc_id, doc_number, doc_date) VALUES
(1, 0, 1, 1, '4785962235', '2008-10-23'),
(2, 0,  2, 1, '4212589789', '2008-10-23'),
(3, 0,  3, 2, '352935', '2008-10-23');