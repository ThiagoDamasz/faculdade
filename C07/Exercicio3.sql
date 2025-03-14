CREATE DATABASE escola;
USE escola;

CREATE TABLE info(
Nome VARCHAR(100),
Matricula INT PRIMARY KEY,
Endereco VARCHAR(100),
Ano_Nasc INT,
Curso VARCHAR(100)
);

SELECT * FROM info;

DESC info;

INSERT INTO info (Nome, Matricula, Endereco, Ano_Nasc, curso) VALUES ('Carlos', 333, 'Rua 0', 2003, 'GEB');
INSERT INTO info values('Luca', 214, 'Rua 2', 2004, 'GES');
Insert into info values('Janaina',123, 'Rua 1', 1998, 'GEB');
insert into info values('Paula', 222, 'Rua 3', 2000, 'GEC');
insert into info values('Pedro', 225, 'Rua 25', 1999, 'GEA');
insert into info values('Jander', 109, 'Rua 10', 2000, 'GES');
insert into info values('Laura', 342, 'Rua 3', 2002, 'GEC');

SELECT nome FROM info WHERE nome like 'Jan____%';
SELECT nome FROM info WHERE nome like 'l%a';
SELECT nome, ano_nasc, curso FROM info WHERE ano_nasc <= 2000;
SELECT * FROM info LIMIT 4;
UPDATE info SET endereco = 'Rua 13' WHERE curso = 'GES';
DELETE FROM info WHERE curso = 'GES';    







