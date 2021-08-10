/*Criando Banco de Dados
CREATE DATABASE db_pizzaria_legal;

/*Utilizando o Banco Criado*/
USE db_pizzaria_legal;

/*Criando a tabela categoria com seus atributos*/
CREATE TABLE tb_categoria(
id_categoria bigint auto_increment,
tipo_categoria varchar(255),
tamanho_categoria varchar(10),
promocao_categoria boolean,
primary key (id_categoria)
);

/*Inserindo dados na tabela categoria*/
INSERT INTO tb_categoria(tipo_categoria, tamanho_categoria, promocao_categoria)
VALUES("Doce", "Grande", FALSE);
INSERT INTO tb_categoria(tipo_categoria, tamanho_categoria, promocao_categoria)
VALUES("Salgada", "Grande", TRUE);
INSERT INTO tb_categoria(tipo_categoria, tamanho_categoria, promocao_categoria)
VALUES("Vegetariana", "Pequena", FALSE);
INSERT INTO tb_categoria(tipo_categoria, tamanho_categoria, promocao_categoria)
VALUES("Doce", "Big Grande", FALSE);
INSERT INTO tb_categoria(tipo_categoria, tamanho_categoria, promocao_categoria)
VALUES("Salgada", "Pequena", TRUE);



/*Criando a tabela pizza com seus atributos*/
CREATE TABLE tb_pizza(
id_pizza bigint auto_increment,
sabor_pizza varchar(255),
ingredientes varchar(255),
borda boolean,
quantidade int,
preco decimal(8,2),
estrangeira_categoria bigint,
primary key(id_pizza), 
foreign key (estrangeira_categoria) references tb_categoria(id_categoria)
);

INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Mussarela", "muçarela, tomate e orégano ", true, 2, 60.00, 2);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Calabresa", "calabresa e cebola", true, 1, 30.00, 5);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Brócolis", "brócolis, muçarela e orégano ", false, 4, 35.00, 3);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Morango", "Morango e chocolate", true, 2, 69.00, 4);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Romeu e Julieta", "queijo branco e goiabada ", false, 3, 120.00, 1);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Frango Catupiry", "frango, milho e catupiry", false, 1, 45.00, 2);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Marguerita", "muçarela, manjericão e tomate", true, 1, 55.00, 5);
INSERT INTO tb_pizza(sabor_pizza, ingredientes, borda, quantidade, preco, estrangeira_categoria)
VALUES("Calabresa", "calabresa e cebola", true, 2, 60.00, 2);

/*Buscando produtos em que o preço seja maior que 20*/
select * from tb_pizza where preco >= 20.00;

/*Buscando produtos em que o preço seja entre 29 e 60*/
select * from tb_pizza where preco between 29 and 60;

/*/*Buscando produtos com a letra B*/
select * from tb_pizza where sabor_pizza like 'b%';

/*Buscando com Inner join entre  tabela categoria e pizza.*/
select tb_pizza.sabor_pizza, tb_pizza.borda, tb_categoria.tipo_categoria  as Categoria_Pizza
from  tb_pizza inner join tb_categoria on tb_categoria.id_categoria = tb_pizza.estrangeira_categoria;

/*Buscando todos os produtos de apenas uma categoria*/
select * from tb_pizza where borda in (true) ;
