insert into role (name, description) values ('ADMIN', 'admin');
insert into role (name, description) values ('USER', 'user');

insert into utilisateur (id, password, email, role_name) values (2, '$2a$04$UPoerHOC/Dq5t5ibvMqxsOtmvd5ArmLw273xXedmfOZ33DO.QrO0K','user@gmail.com','USER');
insert into utilisateur (id, password, email, role_name) values (1, '$2a$04$81OPRIVIXhXMFbr9Tz/b2eXqc2eWvJjl0ETdXejZ574T2s7P86Gp.', 'admin@gamil.com','ADMIN'); 