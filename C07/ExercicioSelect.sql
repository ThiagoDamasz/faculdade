create database bancodedados;
use bancodedados;

create table heroi (
idHeroi int primary key,
nome varchar(45) not null,
endereco varchar(45),
nascimento date,
habilidade varchar(45),
email varchar(45)
);

alter table heroi
modify idHeroi int auto_increment;

create table vilao (
idVilao int primary key auto_increment,
num_crimes int not null
);

alter table vilao
add column nome varchar(45) not null;

create table missao (
idMissao int primary key auto_increment,
nome varchar(45) not null,
`data` date not null,
`local` varchar(45),
duracao int,
Vilao_idvilao INT,
foreign key (vilao_idvilao) references vilao(idVilao)
);

create table Heroi_has_Misssao (
Heroi_idHeroi int,
Missao_idMissao int,
primary key (Heroi_idheroi, Missao_idMissao),
foreign key (Heroi_idHeroi) references heroi(idHeroi),
foreign key (Missao_idMissao) references missao(idMissao)
);

-- 2

insert into heroi (nome, endereco, nascimento, habilidade, email) values
('Clark Kent', 'Metrópolis', '1978-06-18', 'Super força', 'clark@dailyplanet.com'),
('Bruce Wayne', 'Gotham', '1972-02-19', 'Inteligência e recursos', 'bruce@waynecorp.com'),
('Diana Prince', 'Themyscira', '1985-03-22', 'Força divina', 'diana@amazon.com'),
('Barry Allen', 'Central City', '1990-09-30', 'Super velocidade', 'barry@ccpd.com'),
('Hal Jordan', 'Coast City', '1983-01-15', 'Anel energético', 'hal@greenlantern.org');

Select * from heroi;

insert into vilao (nome, num_crimes) values
('Lex Luthor', 50),
('Joker', 900),
('Ares', 0),
('Capitâo Frio', 100),
('Sinestro', 40);

Select * from vilao;

INSERT INTO missao (nome, `data`, `local`, duracao, Vilao_idvilao) VALUES
('Salvar Metrópolis', '2025-05-10', 'Metrópolis', 3, 1),
('Resgate em Gotham', '2025-05-11', 'Gotham', 5, 2),
('Invasão Amazona', '2025-05-12', 'Themyscira', 4, 3),
('Roubo no Banco Central', '2025-05-13', 'Central City', 2, 4),
('Crise em Coast City', '2025-05-14', 'Coast City', 6, 5);

Select * from missao;

-- 3

-- Inserir herói_has_missao
INSERT INTO Heroi_has_Misssao (Heroi_idHeroi, Missao_idMissao)
VALUES
(1, 1),  -- Herói 1 com Missão 1
(2, 2),  -- Herói 2 com Missão 2
(3, 3),  -- Herói 3 com Missão 3
(4, 4),  -- Herói 4 com Missão 4
(5, 5);  -- Herói 5 com Missão 5

-- 4

SELECT 
    h.nome AS nome_heroi,
    m.duracao AS duracao_missao,
    v.nome AS nome_vilao
FROM 
    heroi h
JOIN 
    missao m ON h.idHeroi = m.idMissao
JOIN 
    missao m ON hm.Missao_idMissao = m.idMissao
JOIN 
    vilao v ON m.Vilao_idvilao = v.idVilao
ORDER BY 
    h.nome;
    
-- 5

SELECT 
    h.nome AS nome_heroi,
    SUM(m.duracao) AS duracao_total_missoes,  -- Soma da duração das missões
    COUNT(m.idMissao) AS quantidade_missoes  -- Contagem das missões
FROM heroi h
JOIN Heroi_has_Misssao hm ON h.idHeroi = hm.Heroi_idHeroi
JOIN missao m ON hm.Missao_idMissao = m.idMissao
GROUP BY h.idHeroi  -- Agrupar por herói para contar e somar corretamente
ORDER BY h.nome;  -- Ordenar pelo nome do herói

-- 6

SELECT 
    m.nome AS nome_missao,
    h.nome AS nome_heroi,
    v.num_crimes AS numero_crimes_vilao
FROM missao m
JOIN vilao v ON m.Vilao_idvilao = v.idVilao
JOIN Heroi_has_Misssao hm ON m.idMissao = hm.Missao_idMissao
JOIN heroi h ON hm.Heroi_idHeroi = h.idHeroi
ORDER BY m.nome;

    
          