create database db_cursoDaMinhaVida;
use db_cursoDaMinhaVida;

create table  tb_categoria(
	id bigint auto_increment,
    categoria varchar(255),
    ativo boolean,
    primary key(id)
);
insert into tb_categoria(categoria,ativo) values("data-science",ativo);
insert into tb_categoria(categoria,ativo) values("back-end",ativo);
insert into tb_categoria(categoria,ativo) values("front-end",ativo);

create table tb_curso(
	id bigint auto_increment,
    nome varchar(50),
    duracao varchar(10),
    EAD boolean,
    quantidadeDeAlunos tinyint,
    id_categoria bigint,
    preco decimal(6,2),
    primary key(id),
    foreign key(id_categoria)references tb_categoria(id)
);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco,id_categoria) values("Java", "3 meses", 1, 50,33.99, 2);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco,id_categoria) values("python", "2 meses", 1, 40,32.99, 1);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco,id_categoria) values("SQL", "1 meses", 0, 30, 60.25,1);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco, id_categoria) values("Html", "2 meses", 0, 50,25.99, 3);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco, id_categoria) values("Css","4 meses", 0, 45,39.99, 3);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco, id_categoria) values("C++", "5 meses", 1, 40,45.99, 2);
insert into tb_curso(nome,duracao, EAD, quantidadeDeAlunos,preco, id_categoria) values("Ruby", "3 meses", 1,35, 59.99, 1);

select*from tb_curso;
select *from  tb_curso where preco>50;
select *from  tb_curso where preco between 3 and 30;
select*from tb_curso where nome like "%j%";

select tb_curso.id,tb_curso.nome, tb_curso.duracao, tb_curso.EAD,tb_curso.quantidadeDeAlunos, tb_curso.preco
from tb_curso inner join tb_categoria on tb_curso.id_categoria = tb_categoria.id and tb_curso.nome like "%j%";