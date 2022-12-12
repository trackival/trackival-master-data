insert into address (id, street, house_number, zip_code, town, country, longitude, latitude)
values ('00000000-0000-0000-0000-000000000000', 'Mönchstrasse', '4', '53881', 'Euskirchen', 'Germany', 50.62491385940961, 6.850119458004332),
       ('00000000-0000-0000-0000-000000000001', 'Waldnieler Straße', '12', '41366', 'Schwalmtal', 'Germany', 51.232078701938946, 6.24997325634712),
       ('00000000-0000-0000-0000-000000000002', 'Gladbacher Str.', '29', '40219', 'Düsseldorf', 'Germany', 51.21217505689216, 6.760475940572797),
       ('00000000-0000-0000-0000-000000000003', 'Am Karbödel', '10', '29699', 'Walsrode', 'Germany', 52.912500497652054, 9.618605769472685),
       ('00000000-0000-0000-0000-000000000004', 'Münchener Str.', '12', '51103', 'Köln', 'Germany', 50.94123442999034, 7.023148955906099);

insert into user_settings (id, show_gender, show_interests, show_date_of_birth)
values ('00000000-0000-0000-0000-000000000000', true, true, true),
       ('00000000-0000-0000-0000-000000000001', true, true, false),
       ('00000000-0000-0000-0000-000000000002', false, true, true),
       ('00000000-0000-0000-0000-000000000003', true, false, true),
       ('00000000-0000-0000-0000-000000000004', false, true, false);

insert into users (id, first_name, last_name, mail, password, username, date_of_birth, biography, address_id, gender, interests, settings_id)
values ('00000000-0000-0000-0000-000000000000', 'Gökhan', 'Topcu', 'goekhan.topcu@trackival.com', 'pwd', 'goekhantopcu', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000000', 'MALE', 'Techno;Hardstyle;Hardocre;Uptempo;Hardtechno', '00000000-0000-0000-0000-000000000000'),
       ('00000000-0000-0000-0000-000000000001', 'Alexa', 'Hansen', 'alexa.hansen@trackival.com', 'pwd', 'alexahansen', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000001', 'FEMALE', 'Hardstyle;Techno;Hardocre;Uptempo;House', '00000000-0000-0000-0000-000000000001'),
       ('00000000-0000-0000-0000-000000000002', 'Etienne', 'Ullm', 'etienne.ullm@trackival.com', 'pwd', 'etienneullm', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000002', 'MALE', 'House;Classic;Mainstream', '00000000-0000-0000-0000-000000000002'),
       ('00000000-0000-0000-0000-000000000003', 'Anthony', 'Böhm', 'kilian.boehm@trackival.com', 'pwd', 'kilianboehm', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000003', 'MALE', 'Rap;RnB', '00000000-0000-0000-0000-000000000003'),
       ('00000000-0000-0000-0000-000000000004', 'Selina', 'Wenig', 'selina.wenig@trackival.com', 'pwd', 'selinawenig', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000004', 'FEMALE', 'Rap;RnB', '00000000-0000-0000-0000-000000000004');

insert into events (id, title, description, event_start, event_end, minimum_age, address_id, organizer_id, event_visibility, tags)
values ('00000000-0000-0000-0000-000000000000', 'Gökhans Hardcore-Festival', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'PUBLIC', 'Techno;Hardstyle;Hardocre;Uptempo;Hardtechno'),
       ('00000000-0000-0000-0000-000000000001', 'Alexas Technobunker', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 'PUBLIC', 'Hardstyle;Techno;Hardocre;Uptempo;House'),
       ('00000000-0000-0000-0000-000000000002', 'Etiennes Saufabend', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 'PRIVATE', 'House;Classic;Mainstream'),
       ('00000000-0000-0000-0000-000000000003', 'Kilians Charthits', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 16, '00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', 'PUBLIC', 'Rap;RnB'),
       ('00000000-0000-0000-0000-000000000004', 'Selinas Geburtstagsparty', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', 'PROTECTED', 'Rap;RnB');

insert into user_event_like (user_id, event_id, liked_at)
values ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000001', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000002', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000003', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000004', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000004', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000003', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000002', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', CURRENT_TIMESTAMP);

insert into contact (id, contact_key, contact_value, user_id, event_id)
values ('00000000-0000-0000-0000-000000000000', 'instagram', '@goekhantopcu', '00000000-0000-0000-0000-000000000000', null),
       ('00000000-0000-0000-0000-000000000001', 'twitter', '@jailbreakereu', '00000000-0000-0000-0000-000000000000', null),
       ('00000000-0000-0000-0000-000000000002', 'discord', '@goekhantopcu', '00000000-0000-0000-0000-000000000000', null);

insert into friend_request (id, receiver_id, sender_id, `timestamp`)
values ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000002', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000004', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000003', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000001', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000000', CURRENT_TIMESTAMP);

insert into friend_relation (first_id, second_id, `timestamp`)
values ('00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000001', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000003', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000004', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000002', CURRENT_TIMESTAMP),
       ('00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000000', CURRENT_TIMESTAMP);
