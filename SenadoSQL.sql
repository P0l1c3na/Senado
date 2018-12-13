DROP DATABASE IF EXISTS senado;
create database senado;
use senado;

DROP TABLE IF EXISTS escritorio;
CREATE TABLE escritorio (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    estado VARCHAR(5),    
    setor VARCHAR(100),
    endereco VARCHAR(500),
    telefone VARCHAR(15),
    fax VARCHAR(15)
);

DROP TABLE IF EXISTS imovel;
CREATE TABLE imovel (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    auxilio_moradia VARCHAR(4),
    imovel_funcional VARCHAR(4)
);

DROP TABLE IF EXISTS despesa;
create table despesa(
	id int not null auto_increment,
	ano int,
	mes tinyint,
	senador varchar(50),
	tipo_despesa varchar(500),
	cnpj_cpf varchar(30),
	fornecedor varchar(100),
	documento varchar(50),
	data_ varchar(15),
	detalhamento varchar(5000),
	valor_reembolsado DOUBLE,
	primary key (id)
);

DROP TABLE IF EXISTS aposentadoria;
CREATE TABLE aposentadoria (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    tipo VARCHAR(30),
    data_ini VARCHAR(15),
    data_fim VARCHAR(15),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS contratos;
CREATE TABLE contratos (
    numerocontratos VARCHAR(30) PRIMARY KEY NOT NULL,
    unidadegestoria VARCHAR(100),
    contratada VARCHAR(100),
    cnpj VARCHAR(500),
    objeto VARCHAR(3000),
    dataassinatura VARCHAR(1000),
    datapublicacao VARCHAR(500),
    iniciovigencia VARCHAR(1000),
    fimvigencia VARCHAR(1000),
    modalidade VARCHAR(100),
    numerolicitacao VARCHAR(100),
    processo VARCHAR(50)
);

DROP TABLES IF EXISTS aditivos;
CREATE TABLE aditivos (
    numerocontratos VARCHAR(40),
    numeroaditivo VARCHAR(40),
    processo TEXT(5000),
    descricao TEXT(20000),
    dataassinatura VARCHAR(500),
    datapublicacao VARCHAR(500),
    CONSTRAINT PK_aditivos PRIMARY KEY (numerocontratos , numeroaditivo)
);

DROP TABLE IF EXISTS itens;
CREATE TABLE itens (
    numerocontrato VARCHAR(50),
    numeroitem VARCHAR(50),
    descricao TEXT(20000),
    quantidadecontratada VARCHAR(500),
    CONSTRAINT PK_Itens PRIMARY KEY (numerocontrato , numeroitem)
);

DROP TABLE IF EXISTS comentario;
CREATE TABLE comentario(
	id INT AUTO_INCREMENT PRIMARY KEY,
	idUsuario INT NOT NULL,
	url varchar(100) NOT NULL,
	commentUser VARCHAR(50) NOT NULL,
	commentData DATETIME,
	commentText VARCHAR(500) NOT NULL,
	CONSTRAINT FK_coment_user FOREIGN KEY (IdUsuario)
		REFERENCES usuario(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
	id INT AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,
    createTime datetime,
	tentativas int,
	bloqueado BOOLEAN,
    PRIMARY KEY (id,email)
);

DROP TABLE IF EXISTS log;
CREATE TABLE log(
	id INT AUTO_INCREMENT,
	createTime datetime,
	msg VARCHAR(100),
	PRIMARY KEY (id)
);

CREATE USER 'usuario'@'localhost' IDENTIFIED BY '123456';
GRANT SELECT, INSERT, DELETE ON senado.comentario TO 'usuario'@'localhost' IDENTIFIED BY '123456';
GRANT SELECT, INSERT, DELETE ON senado.usuario TO 'usuario'@'localhost' IDENTIFIED BY '123456';

