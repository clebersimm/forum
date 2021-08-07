create table usuario(
	id bigint not NULL auto_increment,
	nome varchar(50) not null,
	email varchar(50) not null,
	primary key(id)
);

insert into usuario values(1,'teste','teste@example.com');