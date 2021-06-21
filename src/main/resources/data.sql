insert into users(id,email,name,password,created_at) values (1,'kaiodf@gmail.com','kaio','$2a$12$OEGZM8zoG8CW/z.F35aJ.ezNw3qgN.xPGhDfydVQkXc0rJ/bTAeuu','2021-06-20 13:10:02.047');
insert into users(id,email,name,password,created_at) values (2,'maria@gmail.com','maria','$2a$12$OEGZM8zoG8CW/z.F35aJ.ezNw3qgN.xPGhDfydVQkXc0rJ/bTAeuu','2021-06-20 13:11:02.047');

insert into Adress (id, logradouro, numero, bairro, cidade, cep, user_id) values (1,'rua aldino','30','vila formosa','são paulo','03377040',1);
insert into Adress (id, logradouro, numero, bairro, cidade, cep, user_id) values (2,'rua adriano augusto','74','jardim timbauhy','barueri','06440040',2);

commit;