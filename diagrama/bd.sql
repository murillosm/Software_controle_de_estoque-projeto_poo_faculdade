3/*CREATE TABLE endereco_cliente (
    idEndereco INTEGER PRIMARY KEY not null,
    rua VARCHAR(40),
    complemento TEXT,
    nurero INTEGER,
    nomeBairro VARCHAR(40),
    cidade_idCidade INTEGER,
    cliente_idcliente INTEGER,
    fornecedor_id_fornecedor INTEGER,
    FOREIGN KEY (cidade_idCidade)
        REFERENCES cidade (idCidade)
        ON DELETE RESTRICT
);*/

CREATE TABLE cliente
(
    idcliente                SERIAL PRIMARY KEY,
    nome_cliente             varchar(100)        not null,
    razao_social         	 varchar(200),
    cnpj                 	 varchar(14) not null,
	cpf                  	 varchar(11)not null,
    data_nacimento       	 date not null,
    fonecliente1             varchar(11)not null,
    fonecliente2             varchar(11),
    email                    varchar(100),
    endereco                 VARCHAR(200) not null ,
    bairro                   VARCHAR(40),
	cep                      VARCHAR(9),
    numero                   VARCHAR(100),
    estado_idEstado          INTEGER not null ,
    cidade_idCidade          INTEGER not null ,
    FOREIGN KEY (estado_idEstado)
        REFERENCES estado (idEstado),
    FOREIGN KEY (cidade_idCidade)
        REFERENCES cidade (idCidade)
);

/*CREATE TABLE cliente
(
    idcliente                SERIAL PRIMARY KEY,
    nome_cliente             varchar(100)        not null,
    fonecliente1             varchar(11)         not null,
    fonecliente2             varchar(11),
    email                    varchar(100),
    endereco                 VARCHAR(200) not null ,
    bairro                   VARCHAR(40),
    numero                   VARCHAR(100),
    estado_idEstado          INTEGER not null ,
    cidade_idCidade          INTEGER not null ,
    FOREIGN KEY (estado_idEstado)
        REFERENCES estado (idEstado),
    FOREIGN KEY (cidade_idCidade)
        REFERENCES cidade (idCidade)
);



CREATE TABLE cliente_juridica
(
    fk_cliente_idcliente integer PRIMARY KEY not null,
    razao_social         varchar(200),
    cnpj                 varchar(14) not null,
    FOREIGN KEY (fk_cliente_idcliente)
        REFERENCES cliente (idcliente)
);


CREATE TABLE cliente_fisica
(
    fk_cliente_idcliente integer PRIMARY KEY not null,
    cpf                  varchar(11)         not null,
    data_nacimento       date                not null,
    FOREIGN KEY (fk_cliente_idcliente)
        REFERENCES cliente (idcliente)
);*/



CREATE TABLE fisica (
    idclienteF INTEGER PRIMARY KEY not null,
    fk_cliente_idcliente INTEGER not null,
    data_nacimento DATE,
    cpf VARCHAR(11),
    FOREIGN KEY (fk_cliente_idcliente)
        REFERENCES cliente (idcliente)
        ON DELETE CASCADE
);

/*CREATE TABLE endereco_fornecedor (
    idEndereco INTEGER PRIMARY KEY not null,
    rua VARCHAR(40),
    complemento TEXT,
    nurero INTEGER,
    nomeBairro VARCHAR(40),
    cidade_idCidade INTEGER,
    cliente_idcliente INTEGER,
    fornecedor_id_fornecedor INTEGER,
    FOREIGN KEY (cidade_idCidade)
        REFERENCES cidade (idCidade)
        ON DELETE RESTRICT
);

CREATE TABLE fornecedor (
    id_fornecedor integer PRIMARY KEY not null,
    nome_fornecedor varchar(100) not null,
    cnpj_fornecedor varchar(14) not null,
    razao_social varchar(200),
    fonefornecedor_3 varchar(11),
    fonefornecedor_2 varchar(11),
    fk_idEndereco integer not null,
    FOREIGN KEY (fk_idEndereco)
        REFERENCES endereco_fornecedor (idEndereco)
        ON DELETE RESTRICT
);*/

CREATE TABLE fornecedor
(
    id_fornecedor   SERIAL  PRIMARY KEY,
    nome_fornecedor varchar(100)        not null,
    cnpj_fornecedor varchar(14)         not null,
    email           varchar(100),
    razao_social    varchar(200),
    fonefornecedor1 varchar(11)         not null,
    fonefornecedor2 varchar(11),
    endereco        VARCHAR(200)        not null,
    bairro          VARCHAR(40),
    numero          VARCHAR(100),
	cep             VARCHAR(9),
    estado_idEstado INTEGER             not null,
    cidade_idCidade INTEGER             not null,
    FOREIGN KEY (estado_idEstado)
        REFERENCES estado (idEstado),
    FOREIGN KEY (cidade_idCidade)
        REFERENCES cidade (idCidade)
);

CREATE TABLE usuario (
    idusuario integer PRIMARY KEY not null,
    nome_usuario varchar(200) not null,
    cpf varchar(11) not null,
    senha varchar(20) not null,
    login varchar(20) not null
);


CREATE TABLE cadastra_cliente
(
    fk_usuario_idusuario integer,
    fk_cliente_idcliente integer,
    data_cadastro        date,
    FOREIGN KEY (fk_usuario_idusuario)
        REFERENCES usuario (idusuario)
        ON DELETE RESTRICT,
    FOREIGN KEY (fk_cliente_idcliente)
        REFERENCES cliente (idcliente)
);


CREATE TABLE cadastra_fornecedor
(
    fk_usuario_idusuario        integer,
    fk_fornecedor_id_fornecedor integer,
    data_cadastro               date,
    FOREIGN KEY (fk_usuario_idusuario)
        REFERENCES usuario (idusuario)
        ON DELETE SET NULL,
    FOREIGN KEY (fk_fornecedor_id_fornecedor)
        REFERENCES fornecedor (id_fornecedor)
);

CREATE TABLE estoque (
    id_item SERIAL PRIMARY KEY,
	preco decimal(10,2)  not null,
    quantidade_item int  not null,
    nome_item varchar(40)  not null,
    marca_item varchar(40)  not null,
	descricao_item TEXT
	idfornecedor integer,
	FOREIGN KEY (idfornecedor)
        REFERENCES fornecedor (id_fornecedor)
);


CREATE TABLE venda (
    id_venda SERIAL PRIMARY KEY ,
    valor_venda decimal(10,2),
    data_venda date,
    idusuario integer,
    idcliente integer,
    FOREIGN KEY (idusuario)
        REFERENCES usuario (idusuario),
    FOREIGN KEY (idcliente)
        REFERENCES cliente (idcliente)
);

/*CREATE TABLE item_vendido(
    id_venda integer not null,
	id_item integer not null,
    quantidade integer not null,
	CONSTRAINT pk_item_vendido PRIMARY KEY (id_venda, id_item),
    FOREIGN KEY (id_item)
        REFERENCES estoque (id_item)
		ON DELETE CASCADE,
	FOREIGN KEY (id_venda)
        REFERENCES venda (id_venda)
		ON DELETE CASCADE
);*/

CREATE TABLE item_vendido(
    id_venda integer not null,
	id_item integer not null,
    quantidade integer not null,
    FOREIGN KEY (id_item)
        REFERENCES estoque (id_item)
		ON DELETE CASCADE,
	FOREIGN KEY (id_venda)
        REFERENCES venda (id_venda)
		ON DELETE CASCADE
);

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////


