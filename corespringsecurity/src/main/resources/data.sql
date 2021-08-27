INSERT INTO role (role_id, role_name, role_desc) VALUES (1, 'ROLE_ADMIN', 'Admin Role');
INSERT INTO role (role_id, role_name, role_desc) VALUES (2, 'ROLE_MANAGER', 'Manager Role');
INSERT INTO role (role_id, role_name, role_desc) VALUES (3, 'ROLE_USER', 'User Role');

INSERT INTO account (id, age, email, password, username) VALUES (1, 20, 'admin@email.com', '1234', 'admin');
INSERT INTO account (id, age, email, password, username) VALUES (2, 21, 'manager@email.com', '1234', 'manager');
INSERT INTO account (id, age, email, password, username) VALUES (3, 22, 'user@email.com', '1234', 'user');

INSERT INTO account_role (id, role_id, account_id) VALUES (1, 1, 1);
INSERT INTO account_role (id, role_id, account_id) VALUES (2, 2, 2);
INSERT INTO account_role (id, role_id, account_id) VALUES (3, 3, 3);



