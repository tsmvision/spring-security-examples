-- users
INSERT INTO USERS (id, username) VALUES (1, 'admin');
INSERT INTO USERS (id, username) VALUES (2, 'manager');
INSERT INTO USERS (id, username) VALUES (3, 'user1');
INSERT INTO USERS (id, username) VALUES (4, 'user2');
INSERT INTO USERS (id, username) VALUES (5, 'user3');

-- roles
INSERT INTO ROLES (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLES (id, role_name) VALUES (2, 'ROLE_MANAGER');
INSERT INTO ROLES (id, role_name) VALUES (3, 'ROLE_USER');

-- user_role
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (2, 2, 2);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (3, 3, 3);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (4, 4, 3);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (5, 5, 3);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (6, 5, 1);
INSERT INTO USER_ROLE (id, user_id, role_id) VALUES (7, 5, 2);