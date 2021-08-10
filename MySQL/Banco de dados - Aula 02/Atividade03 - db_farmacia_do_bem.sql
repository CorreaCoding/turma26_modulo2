/*Criando Banco de Dados*/
create database db_farmacia_do_bem;

/*Utilizando o Banco Criado*/
use db_farmacia_do_bem;

/*Criando a tabela categoria com seus atributos*/
create table tb_categoria(
id_categoria bigint auto_increment,
receita_categoria boolean,
uso_categoria varchar(25),
consulmo_categoria varchar(25),
primary key (id_categoria)
);

/*Inserindo dados na tabela categoria*/
insert into tb_categoria(receita_categoria, uso_categoria, consulmo_categoria)
values(true, "Adulto", "Controlado");
insert into tb_categoria(receita_categoria, uso_categoria, consulmo_categoria)
values(true, "Infantil ", "Temporário ");
insert into tb_categoria(receita_categoria, uso_categoria, consulmo_categoria)
values(true, "Infantil ", "Diário ");
insert into tb_categoria(receita_categoria, uso_categoria, consulmo_categoria)
values(true, "Adulto", "Temporário ");
insert into tb_categoria(receita_categoria, uso_categoria, consulmo_categoria)
values(true, "Adulto", "Diário ");

/*Criando a tabela produtos com seus atributos*/
create table tb_produto(
id_produto bigint auto_increment,
nome_produto varchar(255),
marca_produto varchar(255),
tipo_produto varchar(25),
quant_produto int,
preco decimal(8,2),
estrang_categoria bigint,
primary key(id_produto),
foreign key(estrang_categoria) references tb_categoria(id_categoria)
);

insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Aspirina ", "Genérico ", "Comprimido ", 2 , 10.25, 1);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Paracetamol  ", "Genérico ", "Comprimido ", 2 , 35.25, 3);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Dipirona  ", "Genérico ", "Comprimido ", 2 , 25.25, 2);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Brometo de Ipratrópico ", "Genérico ", "Liquido ", 2 , 10.25, 1);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Alestra 20 ", "Unic ", "Comprimido ", 4 , 45.25, 4);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Atenolol ", "Genérico ", "Liquido ", 2 , 215.25, 5);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Aspirina ", "Genérico ", "Comprimido ", 5 , 20.25, 3);
insert into tb_produto(nome_produto, marca_produto, tipo_produto, quant_produto, preco, estrang_categoria)
values("Aspirina ", "Genérico ", "Liquido ", 10 , 55.25, 5);

/*Buscando produtos em que o preço seja maior que 40*/
select * from tb_produto where preco >= 40.00;

/*Buscando produtos em que o preço seja entre 5 e 70*/
select * from tb_produto where preco between 5 and 70;

/*Buscando produtos com a letra D*/
select * from tb_produto where nome_produto like 'd%';

/*Buscando com Inner join entre  tabela categoria e produto.*/
select tb_produto.nome_produto, tb_produto.tipo_produto, tb_categoria.receita_categoria as Remedios_com_receita
from tb_produto inner join tb_categoria on tb_categoria.id_categoria = tb_produto.estrang_categoria;

/*Faça um select onde traga todos os Produtos de uma categoria específica (exemplo todos os produtos que são cosméticos).*/

select * from tb_produto where preco between 10 and 35 order by  preco;
