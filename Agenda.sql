create database bdAgenda;

Create Table tabela_cadastro(
	id int auto_increment primary key,
    nome varchar(100),
    telefone varchar(15),
    email varchar(100),
    endereco varchar (100),
    nascimento varchar(10),
    filhos varchar(3)
);