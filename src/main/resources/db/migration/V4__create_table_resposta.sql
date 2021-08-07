create table resposta(
	id bigint not NULL auto_increment,
	mensagem varchar(300) NOT NULL,
	data_criacao datetime NOT NULL,
	topico_id bigint NOT NULL,
	autor_id bigint NOT NULL,
	solucao int(1) NOT NULL,
	primary key(id),
	FOREIGN KEY(autor_id) REFERENCES usuario(id),
	FOREIGN KEY(topico_id) REFERENCES topico(id)
);