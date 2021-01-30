create database teste_luby_software

use teste_luby_software

create table tabela_pessoa(
	id int primary key identity(1, 1),
	nome varchar(300)
)

create table tabela_evento(
	id int primary key identity(1, 1),
	evento varchar(300),
	pessoa_id int,
	foreign key (pessoa_id) references tabela_pessoa(id)
)

insert into tabela_pessoa values 
('John Doe'),
('Jane Doe'),
('Alice Jones'),
('Bobby Louis'),
('Lisa Romero')

insert into tabela_evento values
('Evento A', 2),
('Evento B', 3),
('Evento C', 2),
('Evento D', null)

-- 2.1
select p.id IdPessoa, p.nome NomePessoa, e.id IdEvento, e.evento Evento from tabela_pessoa p join tabela_evento e on p.id = e.id

-- 2.2
select * from tabela_pessoa where nome like '%Doe'

-- 2.3
insert into tabela_evento values ('Evento E', 5)

-- 2.4
update tabela_evento set pessoa_id = 1 where id = 4

-- 2.5 
delete from tabela_evento where id = 2

-- 2.6 
delete from tabela_pessoa where id not in
(select pessoa_id from tabela_evento)

-- 2.7
alter table tabela_pessoa add idade int

-- 2.8
create table tabela_telefone(
	id int,
	telefone varchar(200),
	pessoa_id int,
	primary key (id),
	foreign key (pessoa_id) references tabela_pessoa(id)
)

-- 2.9
alter table tabela_telefone add constraint AK_Telefone unique (telefone)

-- 2.10
drop table tabela_telefone