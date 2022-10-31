insert into address (id, street, house_number, zip_code, town, country, longitude, latitude)
values ('00000000-0000-0000-0000-000000000000', 'Mönchstrasse', '4', '53881', 'Euskirchen', 'Germany', 0.0, 0.0),
       ('00000000-0000-0000-0000-000000000001', 'Waldnieler Straße', '12', '41366', 'Schwalmtal', 'Germany', 0.0, 0.0),
       ('00000000-0000-0000-0000-000000000002', 'Gladbacher Str.', '29', '40219', 'Düsseldorf', 'Germany', 0.0, 0.0),
       ('00000000-0000-0000-0000-000000000003', 'Am Karbödel', '10', '29699', 'Walsrode', 'Germany', 0.0, 0.0),
       ('00000000-0000-0000-0000-000000000004', 'Münchener Str.', '12', '51103', 'Köln', 'Germany', 0.0, 0.0);

insert into contact (id, phone, mail, twitter, instagram, facebook, website)
values ('00000000-0000-0000-0000-000000000000', '+49 151 59199380', 'goekhan.topcu@trackival.com', '@goekhantopcu', '@goekhantopcu', 'goekhantopcu', 'https://goekhantopcu.de'),
       ('00000000-0000-0000-0000-000000000001', '+49 174 7693976', 'alexa.hansen@trackival.com', '@alexahansen', '@alexahansen', 'alexahansen', 'https://alexahansen.de'),
       ('00000000-0000-0000-0000-000000000002', '+49 160 3797853', 'etienne.ullm@trackival.com', '@etienneullm', '@etienneullm', 'etienneullm', 'https://etienneullm.de'),
       ('00000000-0000-0000-0000-000000000003', '+49 174 7265531', 'kilian.boehm@trackival.com', '@kilianboehm', '@kilianboehm', 'kilianboehm', 'https://kilianboehm.de'),
       ('00000000-0000-0000-0000-000000000004', '+49 175 1963157', 'selina.wenig@trackival.com', '@selinawenig', '@selinawenig', 'selinawenig', 'https://selinawenig.de');

insert into user_settings (id, show_gender, show_interests, show_date_of_birth)
values ('00000000-0000-0000-0000-000000000000', true, true, true),
       ('00000000-0000-0000-0000-000000000001', true, true, false),
       ('00000000-0000-0000-0000-000000000002', false, true, true),
       ('00000000-0000-0000-0000-000000000003', true, false, true),
       ('00000000-0000-0000-0000-000000000004', false, true, false);

insert into users (id, first_name, last_name, mail, password, username, date_of_birth, biography, address_id, contact_id, gender, interests, settings_id)
values ('00000000-0000-0000-0000-000000000000', 'Gökhan', 'Topcu', 'goekhan.topcu@trackival.com', 'pwd', 'goekhantopcu', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'MALE', 'Techno;Hardstyle;Hardocre;Uptempo;Hardtechno', '00000000-0000-0000-0000-000000000000'),
       ('00000000-0000-0000-0000-000000000001', 'Alexa', 'Hansen', 'alexa.hansen@trackival.com', 'pwd', 'alexahansen', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 'FEMALE', 'Hardstyle;Techno;Hardocre;Uptempo;House', '00000000-0000-0000-0000-000000000001'),
       ('00000000-0000-0000-0000-000000000002', 'Etienne', 'Ullm', 'etienne.ullm@trackival.com', 'pwd', 'etienneullm', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 'MALE', 'House;Classic;Mainstream', '00000000-0000-0000-0000-000000000002'),
       ('00000000-0000-0000-0000-000000000003', 'Kilian', 'Böhm', 'kilian.boehm@trackival.com', 'pwd', 'kilianboehm', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', 'MALE', 'Rap;RnB', '00000000-0000-0000-0000-000000000003'),
       ('00000000-0000-0000-0000-000000000004', 'Selina', 'Wenig', 'selina.wenig@trackival.com', 'pwd', 'selinawenig', CURRENT_TIMESTAMP, null, '00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', 'FEMALE', 'DrummN''''Bass;Industrial', '00000000-0000-0000-0000-000000000004');

insert into events (id, title, description, event_start, event_end, minimum_age, address_id, contact_id, organizer_id, event_visibility)
values ('00000000-0000-0000-0000-000000000000', 'Gökhans Hardcore-Festival', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'PUBLIC'),
       ('00000000-0000-0000-0000-000000000001', 'Alexas Technobunker', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 'PUBLIC'),
       ('00000000-0000-0000-0000-000000000002', 'Etiennes Saufabend', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 'PRIVATE'),
       ('00000000-0000-0000-0000-000000000003', 'Kilians Charthits', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 16, '00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', 'PUBLIC'),
       ('00000000-0000-0000-0000-000000000004', 'Selinas Nuttenfeier', '-', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 18, '00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', 'PROTECTED');

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
