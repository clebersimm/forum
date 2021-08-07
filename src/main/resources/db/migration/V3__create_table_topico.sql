create table topico(
	id bigint not NULL auto_increment,
	titulo varchar(50) NOT NULL,
	mensagem varchar(300) NOT NULL,
	data_criacao datetime NOT NULL,
	status varchar(20) NOT NULL,
	curso_id bigint NOT NULL,
	autor_id bigint NOT NULL,
	primary key(id),
	FOREIGN KEY(curso_id) REFERENCES curso(id),
	FOREIGN KEY(autor_id) REFERENCES usuario(id)
);