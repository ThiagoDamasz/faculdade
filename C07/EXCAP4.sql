CREATE DATABASE Firma;
USE Firma;


CREATE TABLE Departamento (
DNome VARCHAR(15) NOT NULL,
DNumero INT NOT NULL,
SSN_Empregado CHAR(9),
Datainicio DATE NOT NULL,

PRIMARY KEY (DNumero)
);


CREATE TABLE Empregado (
PNome VARCHAR(30),
Minicial CHAR(1),
UNome VARCHAR(15),
SSN VARCHAR(45) NOT NULL,
DataNasc DATE,
Endereco VARCHAR(45),
Sexo CHAR(1),
Salario DECIMAL,
SSN_Supervisor VARCHAR(45),
Dnumero_Departamento INT,

PRIMARY KEY (SSN),
FOREIGN KEY (DNumero_Departamento) REFERENCES Departamento(DNumero),
FOREIGN KEY (SSN_Supervisor) REFERENCES EMPREGADO(SSN)
);

CREATE TABLE Projeto (
PNome VARCHAR(30) NOT NULL,
PNumero INT NOT NULL,
PLocalizacao VARCHAR(30),
DNumero_Departamento INT NOT NULL,

PRIMARY KEY (PNumero),
FOREIGN KEY (DNumero_Departamento) REFERENCES Departamento(DNumero)
);

CREATE TABLE Departamento_Localizacoes (
LNumero INT NOT NULL,
DLocalizacao VARCHAR(45),
DNumero_Departamento INT NOT NULL,

PRIMARY KEY (LNumero),
FOREIGN KEY (DNumero_Departamento) REFERENCES Departamento(DNumero)
);

CREATE TABLE Trabalha_em (
SSN_Empregado VARCHAR(45) NOT NULL,
PNumero_Projeto INT NOT NULL,
Horas DECIMAL(5,2),

PRIMARY KEY (SSN_Empregado, PNumero_Projeto),
FOREIGN KEY (SSN_Empregado) REFERENCES Empregado(SSN),
FOREIGN KEY (PNumero_Projeto) REFERENCES Projeto(PNumero)
);

CREATE TABLE Dependente (
SSN_Empregado VARCHAR(45) NOT NULL,
Nome_Dependente VARCHAR(45) NOT NULL,
Sexo CHAR(1),
DataNasc DATE,
Parentesco VARCHAR(45),

PRIMARY KEY (SSN_Empregado, Nome_Dependente),
FOREIGN KEY (SSN_Empregado) REFERENCES Empregado(SSN)
);

-- 1)
INSERT INTO Departamento (DNome, DNumero, DataInicio)
VALUES 
('Pesquisa', 1 ,  '2023-01-01'),
('TI', 2 ,  '2024-02-15');

-- 2)
ALTER TABLE Departamento
MODIFY DataInicio DATE NULL;

INSERT INTO Departamento (DNome, DNumero)
VALUES 
('RH', 3);

-- 3)
INSERT INTO Empregado (PNome, UNome, SSN, DNumero_Departamento, DataNasc)
VALUES ('João', 'Silva', '123456789', 1, '1990-05-10'),
('Thiago', 'Damas', '214', 2, '2001-11-13');

-- Primeiro insere Ana, que ainda não tem supervisor
INSERT INTO Empregado (
    PNome, Minicial, UNome, SSN, DataNasc, Endereco,
    Sexo, Salario, SSN_Supervisor, DNumero_Departamento
)
VALUES (
    'Ana', 'M', 'Souza', '111223333', '1985-03-12', 'Rua das Flores, 100',
    'F', 7500.00, NULL, 1
);

INSERT INTO Empregado (
    PNome, Minicial, UNome, SSN, DataNasc, Endereco,
    Sexo, Salario, SSN_Supervisor, DNumero_Departamento
)
VALUES
(
    'Ana', 'M', 'Souza', '111223333', '1985-03-12', 'Rua das Flores, 100',
    'F', 7500.00, NULL, 1
),
(
    'Carlos', 'J', 'Pereira', '222334444', '1992-07-25', 'Av. Central, 250',
    'M', 6200.00, '111223333', 1
);

-- 4)

ALTER TABLE Projeto
MODIFY DNumero_Departamento INT NULL;

INSERT INTO Projeto (PNome, PNumero)
VALUES ('Aplicativo de Software', 1),
('Produto 1', 2),
('Produto 2', 3);

-- 5)

UPDATE Empregado
SET SSN_Supervisor = '111223333'
WHERE SSN = '123456789';

UPDATE Empregado
SET SSN_Supervisor = '111223333'
WHERE SSN = '214';

UPDATE Empregado
SET SSN_Supervisor = '214'
WHERE SSN = '111223333';

-- 6)

UPDATE Departamento
SET SSN_Empregado = '111223333'
WHERE DNumero = 1;

UPDATE Departamento
SET SSN_Empregado = '214'
WHERE DNumero = 2;

UPDATE Departamento
SET SSN_Empregado = '111223333'
WHERE DNumero = 3;

-- 7)

UPDATE Projeto
SET PLocalizacao = 'Detroit Ohio USA'
WHERE DNumero_Departamento = 1;

UPDATE Projeto
SET PLocalizacao = 'Rio de Janeiro RJ Brasil'
WHERE DNumero_Departamento = 2;

UPDATE Projeto
SET PLocalizacao = 'Macau China'
WHERE DNumero_Departamento = 3;

-- 8)

DELETE FROM Projeto
WHERE DNumero_Departamento = 3;

-- 9)

SELECT Parentesco
FROM Dependente;

-- 10)

SELECT PNome, DataNasc
FROM Empregado
WHERE Sexo = 'M'
ORDER BY DataNasc ASC;

-- 11)

SELECT Nome_Dependente, PNome
FROM Dependente, Empregado
WHERE SSN_Empregado = SSN;	

-- 12)

SELECT AVG(Salario) AS Media_Salarial
FROM Empregado, Departamento
WHERE Endereco = 'Sao Paulo' AND Dnumero_Departamento = DNumero;

-- 13)

SELECT 
    g.PNome AS Nome_Gerente,
    e.PNome AS Nome_Empregado,
    (g.Salario - e.Salario) AS Diferenca_Salarial
FROM Empregado e
JOIN Empregado g ON e.SSN_Supervisor = g.SSN;

-- 14)

SELECT 
    e.PNome AS Nome_Empregado,
    p.PNome AS Nome_Projeto,
    t.Horas
FROM Trabalha_em t
JOIN Empregado e ON t.SSN_Empregado = e.SSN
JOIN Projeto p ON t.PNumero_Projeto = p.PNumero;






