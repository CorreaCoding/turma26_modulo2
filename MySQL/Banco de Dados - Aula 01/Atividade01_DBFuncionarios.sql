-- Criando Banco de Dados do RH da Empresa
create database db_rh;

-- Utilizando o Banco de Dados criado
use db_rh;

-- Criando tabela de funcionários e atribuindo seus respectivos valores
create table tb_funcionaries (
-- ID para automático
id bigint auto_increment, /*Cria automaticamente*/
nome varchar (255),
cargo varchar(255),
salario decimal,
contatoEmail varchar(255),
contratoAtivo boolean,
-- Adicionando Chave-Primária
primary key (id)
);

-- Inserindo valores para as variáveis
insert into tb_funcionaries(nome, cargo, salario, contatoEmail, contratoAtivo) values ("Aline", "Auxiliar Administrativo", 1750.00, "aline@contato.com", true);
insert into tb_funcionaries(nome, cargo, salario, contatoEmail, contratoAtivo) values ("Leandro", "Gerente", 3000.00, "leandro@contato.com", true);
insert into tb_funcionaries(nome, cargo, salario, contatoEmail, contratoAtivo) values ("Jean", "Tech Lead", 4500.00, "jean@contato.com", true);
insert into tb_funcionaries(nome, cargo, salario, contatoEmail, contratoAtivo) values ("Raissa", "CTO", 10000.00, "raissa@contato.com", true);
insert into tb_funcionaries(nome, cargo, salario, contatoEmail, contratoAtivo) values ("Nayra", "Desenvolvedora Jr.", 1950.00, "nayra@contato.com", false);

-- Selecionando todos as variáveis da tabela
select * from tb_funcionaries;

-- Selecionando as variáveis da tabela que recebem mais de 2000
select * from tb_funcionaries where salario > 2000;

-- Selecionando as variáveis da tabela que recebem menos de 2000
select*from tb_funcionaries where salario < 2000;

-- Atualizando o contrato da funcionária Nayra para ativo.
update tb_funcionaries set contratoAtivo = true where id = 5;