CREATE DATABASE funcionarios;

USE funcionarios;

CREATE TABLE info(
ID INT PRIMARY KEY,
nome VARCHAR(100),
endereco VARCHAR(100),
cargo VARCHAR(100)
);

select * from info;

INSERT INTO info (ID, nome, endereco, cargo) VALUES (1, 'Thiago Damas', 'Delcides Teles 371 Inatel', 'CEO');
INSERT INTO info(ID, nome, endereco, cargo) Values(2, 'Rodrigo Armengol', 'Algum lugar em Pouso Alegre', 'Vice-presidente');
INSERT INTO info(ID, nome, endereco, cargo) VALUES(3, 'Luan Santana', 'Algum lugar do mundo', 'Cantor Sertanejo'); 

SELECT nome from info;

UPDATE info SET nome = 'Vergil', endereco = 'Inferno', cargo = 'Ultimate Demon King' WHERE ID = '1';

DELETE FROM info WHERE ID = '3';