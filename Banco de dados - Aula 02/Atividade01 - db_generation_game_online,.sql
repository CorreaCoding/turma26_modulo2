-- Criando Banco de Dados da loja de games.
create database db_generation_game_online;

-- Utilizando o Banco de Dados criado.
use db_generation_game_online;

-- Criando tabela de classes
CREATE TABLE tb_classe (
    id BIGINT AUTO_INCREMENT,
    nome_classe VARCHAR(255),
    equipamento VARCHAR(255),
    habilidade VARCHAR(255),
    PRIMARY KEY (id)
);

-- Inserindo 5 dados na tabela de classes
insert into tb_classe (nome_classe, equipamento, habilidade) values ("Guerreiro", "Espada", "Força");
insert into tb_classe (nome_classe, equipamento, habilidade) values ("Viking", "Machado", "Resistência");
insert into tb_classe (nome_classe, equipamento, habilidade) values ("Mago", "Cajado Dourado", "Percepção");
insert into tb_classe (nome_classe, equipamento, habilidade) values ("Necromante", "Armadura de Ossos", "Proteção");
insert into tb_classe (nome_classe, equipamento, habilidade) values ("Animago", "Nenhuma", "Agilidade");

create table tb_personagem(
id bigint auto_increment,
nome varchar(255) not null,
forca int,
velocidade int,
classe_id bigint,
resistencia int,
primary key (id),
FOREIGN KEY (classe_id) REFERENCES tb_classe (id)
);


insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("John", 5000, 300, 8000, 1);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id)  
values ("Ragnar", 5100, 400, 8100, 2);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Dumbledore", 350, 600, 1000, 3);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Hades", 1500, 500, 9000, 4);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Julian", 350, 600, 1000, 3);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Liceu", 5100, 400, 8100, 2);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Sirius", 4300, 2000, 8000, 5);

insert into tb_personagem (nome, forca, velocidade, resistencia, classe_id) 
values ("Nico", 1500, 500, 9000, 4);

select * from tb_personagem where forca > 2000;

select * from tb_personagem where velocidade between 1000 and 2000;


SELECT 
    *
FROM
    tb_personagem
WHERE
    nome LIKE 'c%';
    
 select tb_classe.nome_classe as Classes, tb_classe.equipamento as Equipamento, tb_classe.habilidade as Habilidades from  
tb_personagem inner join tb_classe on tb_classe.id = tb_personagem.classe_id;

select tb_classe.nome_classe as Classes, tb_personagem.nome, tb_classe.equipamento as Equipamento, tb_personagem.forca, tb_personagem.velocidade,tb_personagem.resistencia from  
tb_personagem inner join tb_classe on tb_classe.id = tb_personagem.classe_id
 where tb_personagem.classe_id = 3;


