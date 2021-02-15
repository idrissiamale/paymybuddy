-- -----------------------------------------------------------------------------
---              INITIALIZATION OF USER TABLE                               ---
-- -----------------------------------------------------------------------------
insert into user(name, address, city, email, password) values('John Boyd', '1509 Culver St', 'Culver', 'jaboyd@email.com', 'jb1234');
insert into user(name, address, city, email, password) values('Felicia Carman', '834 Binoc Ave', 'London', 'feliciacarman@email.com', 'felicia_1234');
insert into user(name, address, city, email, password) values('Jonathan Marrack', '29 15th St', 'Manchester', 'jmarrack@email.com', 'jMarrack_56_78');
insert into user(name, address, city, email, password) values('Lily Cooper', '489 Manchester St', 'Manchester', 'lily@email.com', 'james_bond_007');
insert into user(name, address, city, email, password) values('Sophia Zemicks', '892 Downing Ct', 'Liverpool', 'soph@email.com', '892meganMarkel892');

-- -----------------------------------------------------------------------------
---              INITIALIZATION OF ACCOUNT TABLE                             ---
-- -----------------------------------------------------------------------------
insert into account(balance, user_id) values(57, 1);
insert into account(balance, user_id) values(10.50, 2);
insert into account(balance, user_id) values(155.98, 3);
insert into account(balance, user_id) values(79.99, 4);
insert into account(balance, user_id) values(4.99, 5);


-- -----------------------------------------------------------------------------
---              INITIALIZATION OF BANK ACCOUNT TABLE                        ---
-- -----------------------------------------------------------------------------
insert into bank_account(iban, name, account_id) values('GB29 JNBD 6016 1331 9268 19', 'John Boyd', 1);
insert into bank_account(iban, name, account_id) values('GB29 FACN 8000 2021 0001 31', 'Felicia Carman', 2);
insert into bank_account(iban, name, account_id) values('GB29 JNMK 0712 1991 1056 07', 'Jonathan Marrack', 3);
insert into bank_account(iban, name, account_id) values('GB29 LYCR 3105 1987 5657 12', 'Lily Cooper', 4);
insert into bank_account(iban, name, account_id) values('GB29 SAZS 0302 0006 4444 99', 'Sophia Zemicks', 5);


-- -----------------------------------------------------------------------------
---              INITIALIZATION OF CONTACT TABLE                             ---
-- -----------------------------------------------------------------------------
insert into contact(name, email, user_id) values('Smith', 'mrsmith@email.com', 1);
insert into contact(name, email, user_id) values('Clara', 'clarab@email.com', 1);
insert into contact(name, email, user_id) values('Hayley', 'hayleysmith@email.com', 1);
insert into contact(name, email, user_id) values('Matt Carman', 'mcarman@email.com', 2);
insert into contact(name, email, user_id) values('Lily Rose', 'lilrose@email.com', 2);
insert into contact(name, email, user_id) values('Jay', 'jay.marrack@email.com', 3);
insert into contact(name, email, user_id) values('James Bond', 'jb007@email.com', 3);
insert into contact(name, email, user_id) values('Beyonce', 'beyonce@email.com', 4);
insert into contact(name, email, user_id) values('Gaby Zemicks', 'gaby.zemicks@email.com', 5);


-- -----------------------------------------------------------------------------
---              INITIALIZATION OF TRANSACTION TABLE                         ---
-- -----------------------------------------------------------------------------
insert into transaction(date, amount, transaction_type, user_id) values('2020-05-07 22:01:22', 100, 'CREDIT', 1);
insert into transaction(date, amount, transaction_type, user_id) values('2020-12-07 15:28:22', 8, 'PAYMENT', 1);
insert into transaction(date, amount, transaction_type, user_id) values('2021-01-21 04:41:09', 25, 'PAYMENT', 1);
insert into transaction(date, amount, transaction_type, user_id) values(now(), 10, 'PAYMENT', 1);
insert into transaction(date, amount, transaction_type, user_id) values('2020-12-01 13:12:13', 50.5, 'CREDIT', 2);
insert into transaction(date, amount, transaction_type, user_id) values('2021-02-11 10:41:09', 25, 'PAYMENT', 2);
insert into transaction(date, amount, transaction_type, user_id) values(now(), 15, 'PAYMENT', 2);
insert into transaction(date, amount, transaction_type, user_id) values('2020-12-30 13:12:13', 200, 'CREDIT', 3);
insert into transaction(date, amount, transaction_type, user_id) values('2020-12-31 20:41:09', 20, 'PAYMENT', 3);
insert into transaction(date, amount, transaction_type, user_id) values(now(), 24.02, 'PAYMENT', 3);
insert into transaction(date, amount, transaction_type, user_id) values('2020-12-30 18:30:00', 85, 'CREDIT', 4);
insert into transaction(date, amount, transaction_type, user_id) values(now(), 5.01, 'PAYMENT', 4);
insert into transaction(date, amount, transaction_type, user_id) values('2020-08-30 18:30:18', 30, 'CREDIT', 5);
insert into transaction(date, amount, transaction_type, user_id) values(now(), 25.01, 'PAYMENT', 5);



-- -----------------------------------------------------------------------------
---              INITIALIZATION OF CONTACT TRANSACTION TABLE                 ---
-- -----------------------------------------------------------------------------
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(2, 1,'Smith', 'Movie Tickets');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(3, 2, 'Clara', 'Trip money');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(4, 3, 'Hayley', 'Restaurant bill share');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(6, 4, 'Matt Carman', 'Race car club bill share');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(7, 5, 'Lily Rose', 'Make-up money');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(9, 6,'Jay', 'Opera Tickets');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(10, 7,'James Bond', 'Movie Tickets');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(12, 8, 'Beyonce', 'Shopping money');
insert into contact_transaction(transaction_id, contact_id, contact_name, description) values(14, 9,'Gaby Zemicks', 'Restaurant bill');