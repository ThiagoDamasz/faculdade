DROP DATABASE IF EXISTS AV2;
CREATE DATABASE IF NOT EXISTS AV2;
USE AV2;

SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS Aventureiro;
CREATE TABLE IF NOT EXISTS Aventureiro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    classe VARCHAR(50),
    nivel INT,
    experiencia INT DEFAULT 0
);

DROP TABLE IF EXISTS Missao;
CREATE TABLE IF NOT EXISTS Missao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    dificuldade VARCHAR(20),
    recompensa INT
);

DROP TABLE IF EXISTS Habilidade;
CREATE TABLE IF NOT EXISTS Participacao (
    aventureiro_id INT,
    missao_id INT,
    status VARCHAR(50),
    FOREIGN KEY (aventureiro_id) REFERENCES Aventureiro(id),
    FOREIGN KEY (missao_id) REFERENCES Missao(id),
    PRIMARY KEY (aventureiro_id, missao_id)
);

-- A) Crie um trigger 'nivel_experiencia' que, antes de inserir um aventureiro, verifica sua experiência e define um nível a ele
-- Se for menor que 1000, o nível deve ser 1
-- Se for maior ou igual a 1000 e menor que 5000, o nível deve ser 2
-- Se for maior ou igual a 5000, o nível deve ser 3
-- Dica: Utilize ELSEIF
-- Resposta:

DELIMITER $$
CREATE TRIGGER nivel_experiencia
BEFORE INSERT ON Aventureiro
FOR EACH ROW
Begin

IF NEW.experiencia < 1000 THEN
SET NEW.nivel = 1;
ELSEIF NEW.experiencia >= 1000 AND NEW.experiencia < 5000 THEN
SET NEW.nivel = 2;
ELSEIF NEW.experiencia >= 5000 THEN
SET NEW.nivel = 3;

END IF;

END;
DELIMITER;

-- B) Crie uma procedure 'registrar_aventureiro' que recebe um nome, uma classe e uma experiência, e insere um novo aventureiro
-- Resposta:

DELIMITER $$
CREATE PROCEDURE registrar_aventureiro()
BEGIN
    INSERT INTO Aventureiro (nome, classe, experiencia)
    VALUES
      ('Joao', 'Mago', 1000),
      ('Thiago', 'Marechal', 5030),
      ('Rodrigo', 'Monge', 3500);
END $$
DELIMITER ;

-- C) Crie uma function 'descricao_missao' que recebe o título e a dificuldade de uma missão e retorna uma única string formatada 'Missão <titulo>: Dificuldade <dificuldade>'
-- Resposta:
DELIMITER //

CREATE FUNCTION descricao_missao(titulo VARCHAR(45), dificuldade INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
    DECLARE formato VARCHAR(100);
    RETURN CONCAT('Missão', titulo, ' Dificuldade', dificuldade);
END //

DELIMITER ;

-- D) Use a procedure 'registrar_aventureiro' para inserir 3 aventureiros com diferentes níveis de experiência
-- Resposta:

CALL registrar_aventureiro(); 

-- E) Insira 3 missões com diferentes dificuldades e recompensas, depois, chame a function 'descricao_missao' para cada uma delas
-- Resposta:

INSERT INTO Missao (titulo, dificuldade, recompensa) VALUES
('Highway to Hell ', 1 , 1000),
('Hells Bells ', 2 , 10000),
('Thunderstruck ', 3 , 1000000);
SELECT descricao_missao('Highway to Hell ', 1);
SELECT descricao_missao('Hells Bells ', 2);
SELECT descricao_missao('Thunderstruck ', 3);

-- F) Escolha dois dos três aventureiros e duas das três missões, relacione-os os dois aventureiros as duas missões, uma com status 'Falhou' e outra com status 'Concluída'
-- Resposta:


-- G) Crie uma view 'resumo_aventureiro' que retorne o nome do aventureiro, o nome da missão, o status e a recompensa, depois, chame a view
-- Resposta:
CREATE VIEW resumo_aventureiro AS
SELECT Aventureiro.nome, Missao.titulo, Missao.recompensa FROM Aventureiro, Missao;
drop view resumo_aventureiro;

-- H) Busque o nome do aventureiro, a classe do aventureiro e o título da missão executada por ele
-- Resposta:

SELECT a.nome, m.titulo, a.classe FROM Aventureiro a
JOIN Participacao p 
ON a.id = p.aventureiro_id 
JOIN Missao m ON m.id = p.missao_id;


-- I) Busque todas as informações de todos os aventureiros e o nome de suas missões, mesmo que não tenham participado de nenhuma missão
-- Resposta:

SELECT a.nome, a.classe, a.nivel, a.experiencia, m.titulo FROM Aventureiro a
JOIN Participacao p 
ON a.id = p.aventureiro_id 
JOIN Missao m ON m.id = p.missao_id;

-- J) Busque todas as informações de todas as missões e o nome de seus aventureiros, mesmo que nenhuma aventureiro tenha participado da missão
-- Resposta:

SELECT a.nome, m.titulo, m.titulo, m.dificuldade, m.recompensa FROM Aventureiro a
JOIN Participacao p 
ON a.id = p.aventureiro_id 
JOIN Missao m ON m.id = p.missao_id;