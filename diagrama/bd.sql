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
    valor_venda decimal(10,2) not null,
    data_venda date not null,
    idusuario integer,
    idcliente integer,
    FOREIGN KEY (idusuario)
        REFERENCES usuario (idusuario),
    FOREIGN KEY (idcliente)
        REFERENCES cliente (idcliente)
);

CREATE TABLE item_vendido (
    id_venda SERIAL PRIMARY KEY,
    quantidade integer not null,
    id_item integer,
    FOREIGN KEY (id_item)
        REFERENCES estoque (id_item)
);

CREATE TABLE item_vendido2(
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
);

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE compra (
                        codigo_compra integer PRIMARY KEY not null,
                        data_compra date not null,
                        valor_compra decimal(10,2) not null,
                        fk_usuario_idusuario integer,
                        fk_fornecedor_id_fornecedor integer,
                        FOREIGN KEY (fk_usuario_idusuario)
                            REFERENCES usuario (idusuario)
                            ON DELETE CASCADE,
                        FOREIGN KEY (fk_fornecedor_id_fornecedor)
                            REFERENCES fornecedor (id_fornecedor)
                            ON DELETE CASCADE
);

/*CREATE TABLE marca (
                       id_marca integer PRIMARY KEY not null,
                       nome_marca integer not null
);*/

/*CREATE TABLE item (
                      id_item integer PRIMARY KEY not null,
                      nome_item varchar(40) not null,
                      modelo varchar(100),
                      fk_modelo_cod_modelo integer,
                      fk_marca_id_marca integer,
                      FOREIGN KEY (fk_marca_id_marca)
                          REFERENCES marca (id_marca)
                          ON DELETE RESTRICT
);*/

CREATE TABLE item_compra (
                             id_item_compra integer PRIMARY KEY not null,
                             quantidade integer not null,
                             preco_unitario decimal(10,2) not null,
                             fk_compra_codigo_compra integer,
                             fk_item_id_item integer,
                             FOREIGN KEY (fk_compra_codigo_compra)
                                 REFERENCES compra (codigo_compra)
                                 ON DELETE RESTRICT,
                             FOREIGN KEY (fk_item_id_item)
                                 REFERENCES item (id_item)
                                 ON DELETE CASCADE
);



CREATE TABLE reduz (
                       fk_estoque_id_item integer,
                       fk_id_item_venda integer,
                       FOREIGN KEY (fk_estoque_id_item)
                           REFERENCES estoque (id_item)
                           ON DELETE RESTRICT,
                       FOREIGN KEY (fk_id_item_venda)
                           REFERENCES item_vendido(id_item_venda)
                           ON DELETE RESTRICT
);

CREATE TABLE parcela (
                         cod_parcelameto integer PRIMARY KEY,
                         valor_parcelas decimal(20,2),
                         quantidade_parcelar int,
                         fk_venda_codigo_venda integer,
                         FOREIGN KEY (fk_venda_codigo_venda)
                             REFERENCES venda (codigo_venda)
                             ON DELETE RESTRICT
);
