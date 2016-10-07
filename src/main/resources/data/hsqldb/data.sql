/*
 * HSQLDB script.
 * Load the database with reference data and unit test data.
 */
-- password is 'password'
INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'operations'
INSERT INTO Account (referenceId, username, password, enabled, credentialsexpired, expired, locked, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', true, false, false, false, 0, 'user', NOW(), NULL, NULL);

INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (1, 'ROLE_USER', 'User', 0, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (2, 'ROLE_ADMIN', 'Admin', 1, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO Role (id, code, label, ordinal, effectiveAt, expiresAt, createdAt) VALUES (3, 'ROLE_SYSADMIN', 'System Admin', 2, '2015-01-01 00:00:00', NULL, NOW());

INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'user' and r.id = 1;
INSERT INTO AccountRole (accountId, roleId) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'operations' and r.id = 3;

INSERT INTO Greeting (referenceId, text, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('1e0d5287-67fd-4043-9ac4-b8d358d6d7ce', 'Hello World!', 0, 'user', NOW(), NULL, NULL);
INSERT INTO Greeting (referenceId, text, version, createdBy, createdAt, updatedBy, updatedAt) VALUES ('37c3178d-3b49-47b6-99d1-277b1a3e8df8', 'Hola Mundo!', 0, 'user', NOW(), NULL, NULL);

insert into Item(description, ean13, price, type, shortDesc) values('Foot Powder','931350115808', 7, 'N', 'Foot Powder');
insert into Item(description, ean13, price, type, shortDesc) values('Recover Chocolate coconut','931177059100', 6, 'N', 'Rec Choc Coconut');
insert into Item(description, ean13, price, type, shortDesc) values('Neralda Camomile 40','931055100029', 14, 'N', 'Nerald Camomile40');
insert into Item(description, ean13, price, type, shortDesc) values('Mackerel Fillets','930046234071', 5, 'N', 'Mackerel Fillets');
insert into Item(description, ean13, price, type, shortDesc) values('Brendan Pepercorn sauce','931148500125', 8, 'N', 'Brendan PeperCo Sou');
insert into Item(description, ean13, price, type, shortDesc) values('Italian Herbs','930063392784', 2.50, 'N', 'Italian Herbs sel');
insert into Item(description, ean13, price, type, shortDesc) values('White board marker','932472600170',2,'N','Whiteboard Marker');
insert into Item(description, ean13, price, type, shortDesc) values('James Boag''s Premium Lager','931869100832',6.2,'N','James Boags Prem');
insert into Item(description, ean13, price, type, shortDesc) values('kettle Potato Chips Chilli','931098801262',4.7,'N','kettle chilli chi');
insert into Item(description, ean13, price, type, shortDesc) values('Cool Ridge spring water','931559630210',2,'N','Cool Ridge Spring');
insert into Item(description, ean13, price, type, shortDesc) values('Kikkoman soy sauce','490151511858',7.5,'N','Kikk soice sauce');
insert into Item(description, ean13, price, type, shortDesc) values('Cayenne pepper Extra hot','930060156941',2.8,'N','Cayenne peper');
insert into Item(description, ean13, price, type, shortDesc) values('Vodka Cruiser Pineapple','932998201657',4.8,'N','Vodka Cruis pina');
insert into Item(description, ean13, price, type, shortDesc) values('Hoyts Basil leaves 15gr','930072500103',1.2,'N','Hoyts Basil 15g');
insert into Item(description, ean13, price, type, shortDesc) values('Nescafe expresso 150gr','930060511422',10.5,'N','Nescafe Exp 150gr');
insert into Item(description, ean13, price, type, shortDesc) values('Kraft Grated Parmesan cheese strong flavour','930065038061',15.5,'N','kraft Parmesan 250gr');
insert into Item(description, ean13, price, type, shortDesc) values('Fanta 1.25l grape flavour','930067505041',3.5,'N','Fanta 1.25l grape');