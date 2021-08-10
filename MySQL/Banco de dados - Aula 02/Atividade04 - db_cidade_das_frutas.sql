/*Criando Banco de Dados*/
 create database db_cidade_das_frutas;
 
 /*Utilizando o Banco Criado*/
 use db_cidade_das_carnes;

/*Criando a tabela categoria com seus atributos*/
create table tb_categoria(
id bigint auto_increment,
descricao varchar(255) not null, 
ativo boolean not null,
primary key (id)
);

/*Inserindo dados na tabela categoria*/
insert into tb_categoria (descricao, ativo) values ("Frutas", true);
insert into tb_categoria(descricao, ativo) values ("Verduras", true);
insert into tb_categoria(descricao, ativo) values ("Legumes", true);
insert into tb_categoria(descricao, ativo) values ("Sucos", true);
insert into tb_categoria(descricao, ativo) values ("Lácteos", true);

create table tb_produto (
id bigint auto_increment,
produto varchar (255) not null,
preco decimal(6,2) not null,
qtproduto int not null,
dtvencimento date,
categoria_id bigint,
primary key (id),
FOREIGN KEY (categoria_id) REFERENCES tb_categoria (id)
);

insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Banana", 8.90, 12, '2021-08-01', 1);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Chandelle Chocolate", 69.99, 20, '2022-01-01', 5);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Alface Americana", 3.70, 3, '2021-08-07', 2);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Tomate", 6.00, 4, '2021-08-30', 3);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Suco de Laranja 1L", 9.00, 2, '2021-09-25', 4);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Maça", 10.00, 3, '2021-10-01', 1);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Pepino", 4.00, 2, '2021-09-12', 3);
insert into tb_produto (produto, preco, qtproduto, dtvencimento, categoria_id) values ("Brócolis", 8.00, 6, '2021-09-05', 2);

select * from tb_produto where preco > 10;

select * from tb_produto where preco between 1 and 20;

select * from tb_produto where produto like "P%";

select tb_produto.produto, tb_produto.preco, tb_categoria.descricao 
from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_id;

select tb_produto.produto, tb_produto.preco, tb_categoria.descricao 
from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.categoria_id and tb_categoria.descricao = "Verduras";
