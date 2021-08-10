/*Criando Banco de Dados*/
create database db_construindo_a_nossa_vida;

 /*Utilizando o Banco Criado*/
use db_construindoANossaVida;

/*Criando a tabela categoria com seus atributos*/
create table tb_categoria(
id bigint auto_increment,
descricao varchar(255) not null, 
ativo boolean not null,
primary key (id)
);

insert into tb_categoria (descricao, ativo) values ("Hidráulica", true);
insert into tb_categoria (descricao, ativo) values ("Elétrica", true);
insert into tb_categoria (descricao, ativo) values ("Marcenaria", true);

create table tb_produto (
id bigint auto_increment,
nome varchar (255) not null,
preco double(6,2) not null,
marca varchar(255),
quantidade int not null,
categoria_id bigint,
primary key (id),
FOREIGN KEY (categoria_id) REFERENCES tb_categoria (id)
);

insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Cimento", 25.00, "Caue", 50, 3);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Lampada LED", 30.00, "Luz&Cia", 80, 2);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Junção T", 2.99, "Tigre", 145, 1);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Balcão de madeira", 455.00, "MadeiraMadeira", 20, 5);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Abajur rosé", 72.00, "Imaginarium", 48, 4);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Massa corrida", 45.00, "Caue", 50, 3);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Cano PVC - longo", 55.00, "Tigre", 100, 1);
insert into tb_produto (nome, preco, marca, quantidade, categoria_id) values ("Cano PVC - curto", 40.00, "Tigre", 100, 1);


select * from tb_produto where preco > 40;

select * from tb_produto where preco between 30 and 60;

select * from tb_produto where nome like "A%";

select tb_produto.nome, tb_produto.preco, tb_categoria.descricao 
from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_id;

select tb_produto.nome, tb_produto.preco, tb_categoria.descricao 
from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_id and tb_categoria.descricao = "Elétrica";