/*
 * MySQL script.
 * Load the database with reference data and unit test data.
 */
insert into User(username, password) values('admin', 'admin');
insert into User(username, password) values('user', 'user');
insert into User(username, password) values('alex', 'alex');
insert into User(username, password) values('jo', 'jo');
insert into User(username, password) values('stephano', 'stephano');

insert into Client(name, address, phone1, phone2) values('Bert Klug', '10/ 6-8 Hercules rd, Brighton le sands NSW 2216', '0427313048', null);
insert into Client(name, address, phone1, phone2) values('Shellie Grimsley', '25/333 Bulwara rd, Ultimo NSW 2007', '0429513443', '(02) 9333 6141');
insert into Client(name, address, phone1, phone2) values('Katherin Grewell', '15 Ocean Street, Sydney South NSW 2000', '(02) 8583 7503', null);
insert into Client(name, address, phone1, phone2) values('Gale Likens', '27 Brown Street, Norh Sydney NSW 2055', '(02) 9455 7258', null);
insert into Client(name, address, phone1, phone2) values('Evan Donlan', '82 Brown Street, North Sydney  NSW 2060', '(02) 9149 7887', null);
insert into Client(name, address, phone1, phone2) values('Duncan Ulmer', '62 Trelawney Street, Mascot NSW 2020', '(02) 9902 6130', null);
insert into Client(name, address, phone1, phone2) values('Ozell Hamblin', '2 Edgecliff Road, Chippendale NSW 2008', '0426534907', '(02) 8243 5420');
insert into Client(name, address, phone1, phone2) values('Jeannie Dantzler', '65 Wallis Street, Clovelly West NSW 2031', '(02) 9718 6681', null);
insert into Client(name, address, phone1, phone2) values('Kathe Voight', '97 Wallis Street Rose, Bay NSW 2029', '(02) 9379 6711', null);

insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 07:00:00','%d-%m-%Y %h:%i:%s'), 1, 3, '10/ 6-8 Hercules rd, Brighton le sands NSW 2216', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 08:00:00','%d-%m-%Y %h:%i:%s'), 2, 3, '25/333 Bulwara rd, Ultimo NSW 2007', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 09:30:00','%d-%m-%Y %h:%i:%s'), 3, 3, '15 Ocean Street, Sydney South NSW 2000', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 11:00:00','%d-%m-%Y %h:%i:%s'), 4, 3, '27 Brown Street, North Sydney NSW 2055', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 12:00:00 PM','%d-%m-%Y %h:%i:%s %p'), 5, 3, '82 Brown Street, North Sydney  NSW 2060', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 1:00:00 PM','%d-%m-%Y %h:%i:%s %p'), 6, 3, '62 Trelawney Street, Mascot NSW 2020', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 3:30:00 PM','%d-%m-%Y %h:%i:%s %p'), 7, 3, '2 Edgecliff Road, Chippendale NSW 2008', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 4:30:00 PM','%d-%m-%Y %h:%i:%s %p'), 8, 3, '65 Wallis Street, Clovelly West NSW 2031', 0);
insert into Schedule(date, clientId, userId, address, status) values(STR_TO_DATE('27-04-2016 6:00:00 PM','%d-%m-%Y %h:%i:%s %p'), 9, 3, '97 Wallis Street Rose, Bay NSW 2029', 0);

insert into Work(scheduleId, description, notes, status) values(1, 'Relace Venetian blinds', '', 0);
insert into Work(scheduleId, description, notes, status) values(2, 'Replace range hood light bulbs', '', 0);
insert into Work(scheduleId, description, notes, status) values(2, 'Fix main door', '', 0);
insert into Work(scheduleId, description, notes, status) values(3, 'Fix Fence', '', 0);
insert into Work(scheduleId, description, notes, status) values(4, 'Repair Toilet', '', 0);
insert into Work(scheduleId, description, notes, status) values(4, 'Repair letterbox', '', 0);
insert into Work(scheduleId, description, notes, status) values(5, 'Fix batroom: tap leaks', '', 0);
insert into Work(scheduleId, description, notes, status) values(6, 'Fix gate', '', 0);
insert into Work(scheduleId, description, notes, status) values(7, 'Ceiling repair', '', 0);
insert into Work(scheduleId, description, notes, status) values(7, 'Change Mainroom lock', '', 0);
insert into Work(scheduleId, description, notes, status) values(8, 'Replace downlights', '', 0);
insert into Work(scheduleId, description, notes, status) values(9, 'Replace ovenlights', '', 0);

