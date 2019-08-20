insert into role (name, description) values ('ADMIN', 'admin');
insert into role (name, description) values ('USER', 'user');

insert into utilisateur (id, age, password, salary, username, role_name) values (2, 12, '$2a$04$UPoerHOC/Dq5t5ibvMqxsOtmvd5ArmLw273xXedmfOZ33DO.QrO0K', 123, 'user','USER');
insert into utilisateur (id, age, password, salary, username, role_name) values (1, 12, '$2a$04$81OPRIVIXhXMFbr9Tz/b2eXqc2eWvJjl0ETdXejZ574T2s7P86Gp.', 123, 'admin','ADMIN'); 