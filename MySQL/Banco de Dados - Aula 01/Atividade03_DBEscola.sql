-- Criando Banco de Dados
create database db_registro_escola;

-- Utilizando Banco de Dados criado
use db_registro_escola;

-- Criando tabela estudante com variáveis
create table tb_estudante(
id bigint auto_increment,
nomeDoAluno varchar(255),
turma varchar(255),
contatoDoResponsavel varchar(255),
nota decimal,
aprovado boolean,
primary key (id)
);

-- Modificando nota para aparecer casas decimais ao invés de arredondar
alter table tb_estudante modify nota decimal (3,1); 

-- Inserindo informações na tabela
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Jean", "3º Ano A", "maedojean@contato.com", 8.9, true);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Letícia", "1º Ano B", "maedaleticia@contato.com", 6.0, false);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Lia", "9º Ano A", "maedalia@contato.com", 7.5, true);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Antônio", "5º Ano A", "maedoantonio@contato.com", 4.9, false);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Breno", "8º Ano A", "maedobreno@contato.com", 9.5, true);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Enzo", "2º Ano A", "maedoenzo@contato.com", 6.5, false);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Caio", "7º Ano A", "maedocaio@contato.com", 8.7, true);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Nicholas", "6º Ano A", "maedonicholas@contato.com", 3.5, false);
insert into tb_estudante (nomeDoAluno, turma, contatoDoResponsavel, nota, aprovado) values ("Hannah", "1º Ano A", "maedahannah@contato.com", 10.0, true);

-- Selecionando a tabela
select * from tb_estudante;

-- Selecionando informações onde a nota é maior do que 7
select*from tb_estudante where nota > 7;

-- Selecionando informações onde a nota é menor do que 7
select*from tb_estudante where nota < 7;

-- Atualizando informação no id 7
update tb_estudante set nota = 9.0 where id = 7;
