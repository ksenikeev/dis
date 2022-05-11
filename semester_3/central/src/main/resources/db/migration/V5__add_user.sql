insert into users (id, password, username, status) values
    ((select nextval('users_seq')),'$2a$10$RdSjfquHfOS4Vh8EeUTbKODVZvD0GDs9spBnDwnuL06bilul2k2Xm', 'admin','CONFIRMED');

insert into users_dict_userrole (user_id, roles_id) values (1, 1);