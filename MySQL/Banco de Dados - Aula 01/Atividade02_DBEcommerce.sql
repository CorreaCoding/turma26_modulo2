/*1.Criando Banco de Dados*/
create database db_ecommerce; 

/*2. Utilizando Banco de Dados criado*/ 
use db_ecommerce;

/*Criando tabela*/
create table tb_produtos (
id bigint auto_increment,
nome_produto varchar(255),
preco decimal,
categoria varchar(255),
garantia boolean,
dataFabricacao varchar(255),
primary key (id)
);
-- Alterando para os números decimais não serem arredondados
alter table tb_produtos modify preco decimal (6,2);  /* Corrige estrutura --> 6 digitos onde as 2 últimas casas dicam depois da vírgula*/

-- Inserindo valores na tabela
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Iphone X", 5000.59, "Eletrônicos", true, "22/05/2019");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Kindle Paperwhite", 474.99, "Eletrônico", true, "30/03/2020");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Echo Dot", 331.89, "Eletrônicos", true, "11/06/2021");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Acer Aspire", 3800.00, "Eletrônicos", true, "05/02/2019");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Smart TV Led LG", 1800.00, "Eletrônicos", true, "01/06/2018");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Carrie, a estranha - Stephen King", 35.99, "Livraria", false, "19/04/1996");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Foreo", 700.00, "Beleza", true, "06/05/2018");
insert into tb_produtos(nome_produto, preco, categoria, garantia, dataFabricacao) values ("Polaroid - Instax Mini", 480.00, "Eletrônicos", true, "17/02/2019");

-- Mostrando todos os valores da tabela
select * from tb_funcionaries tb_produtos;

-- Mostrando todos os valores da tabela em que seus valores são maiores do que 500
select * from tb_produtos where preco > 500;

-- Mostrando todos os valores da tabela em que seus valores são menores do que 500
select * from tb_produtos where preco < 500;

-- Atualização da garantia do livro Carrie, a estranha.
update tb_produtos set garantia = true where id = 6;
