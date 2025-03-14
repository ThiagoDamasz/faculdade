CREATE DATABASE empresa;

USE empresa;

CREATE TABLE info(
matricula INT PRIMARY KEY,
nome VARCHAR(100),
cpf VARCHAR(100),
cargo VARCHAR(100),
NroProjetos INT
);

SELECT * FROM info;

INSERT INTO info VALUES (1, 'Junior', '000.000.000-00', 'GP', 2);
INSERT INTO info VALUES (2, 'Maria', '111.111.111-11', 'Desenvolvedor', 3);
INSERT INTO info VALUES (3, 'Carlos', '222.222.222-22', 'Tester', 4);
INSERT INTO info VALUES (4, 'Julia', '333.333.333-33', 'Desenvolvedor', 5);

SELECT COUNT(NroProjetos) FROM info WHERE NroProjetos > 4 ;
SELECT AVG(NroProjetos) FROM info WHERE cargo != 'GP';
SELECT DiSTINCT cargo FROM info;
SELECT nome, cpf, NroProjetos FROM info WHERE cargo = 'Desenvolvedor';
