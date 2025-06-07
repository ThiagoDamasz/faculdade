CREATE DATABASE plataforma_cursos;
USE plataforma_cursos;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario ENUM('aluno', 'professor', 'admin') NOT NULL
);

CREATE TABLE perfis (
    id INT PRIMARY KEY,
    data_nascimento DATE NOT NULL,
    FOREIGN KEY (id) REFERENCES usuario(id)
);

CREATE TABLE modulos (
    idmodulo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- correcao de chave estreangeira na Relacao 1:N entre curso, modulos
ALTER TABLE modulos
ADD COLUMN idcurso INT,
ADD FOREIGN KEY (idcurso) REFERENCES cursos(idcurso);
UPDATE modulos SET idcurso = 1 WHERE idmodulo = 1;
UPDATE modulos SET idcurso = 2 WHERE idmodulo = 2;
UPDATE modulos SET idcurso = 3 WHERE idmodulo = 3;


CREATE TABLE aulas (
    idaula INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    id_modulo INT,  -- Chave estrangeira que vai referenciar a tabela modulos
    FOREIGN KEY (id_modulo) REFERENCES modulos(idmodulo)  -- Relacionamento com a tabela modulos
);

CREATE TABLE cursos (
    idcurso INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    id_professor INT,  -- Chave estrangeira que vai referenciar a tabela usuario (professor)
    FOREIGN KEY (id_professor) REFERENCES usuario(id),  -- Relacionamento com a tabela usuario (professor)
    CONSTRAINT fk_cursos_professor FOREIGN KEY (id_professor) REFERENCES usuario(id)  -- Garantir integridade
);

CREATE TABLE inscricoes (
    id_aluno INT,
    id_curso INT,
	data_inscricao VARCHAR(45),  
    PRIMARY KEY (id_aluno, id_curso),  -- chave composta para evitar duplicatas
    FOREIGN KEY (id_aluno) REFERENCES usuario(id),
    FOREIGN KEY (id_curso) REFERENCES cursos(idcurso)
);

CREATE TABLE atividades (
    idatividade INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    descricao VARCHAR(45),
    idcurso INT,
    FOREIGN KEY (idcurso) REFERENCES cursos(idcurso)
);

CREATE TABLE envios_atividades (
    id_aluno INT,
    idatividade INT,
    data_envio VARCHAR(45),  -- Ex: '2025-05-05'
    PRIMARY KEY (id_aluno, idatividade),
    FOREIGN KEY (id_aluno) REFERENCES usuario(id),
    FOREIGN KEY (idatividade) REFERENCES atividades(idatividade)
);

-- insercoes de usuario
INSERT INTO usuario (nome, email, senha, tipo_usuario)
VALUES ('Ana Souza', 'ana@email.com', 'senha123', 'aluno');

INSERT INTO usuario (nome, email, senha, tipo_usuario)
VALUES ('Carlos Lima', 'carlos@email.com', 'senha456', 'professor');

INSERT INTO usuario (nome, email, senha, tipo_usuario)
VALUES ('Juliana Prado', 'juliana@email.com', 'admin789', 'admin');

INSERT INTO usuario (nome, email, senha, tipo_usuario)
VALUES ('Ruan', 'Ruan@email.com', 'senha4222', 'professor');

-- insercoes de perfis
INSERT INTO perfis (id, data_nascimento)
VALUES (1, '2000-04-10');

INSERT INTO perfis (id, data_nascimento)
VALUES (2, '1985-11-22');

INSERT INTO perfis (id, data_nascimento)
VALUES (3, '1990-06-15');

-- insercoes de curso
INSERT INTO cursos (categoria, nome, descricao, id_professor)
VALUES ('Programação', 'Lógica de Programação', 'Curso introdutório', 2);

INSERT INTO cursos (categoria, nome, descricao, id_professor)
VALUES ('Web Design', 'HTML e CSS Básico', 'Construa páginas web', 2);

INSERT INTO cursos (categoria, nome, descricao, id_professor)
VALUES ('Banco de Dados', 'SQL para Iniciantes', 'Aprenda a manipular dados', 2);

-- isercaa de modulos
INSERT INTO modulos (nome)
VALUES ('Introdução à Lógica');

INSERT INTO modulos (nome)
VALUES ('HTML Básico');

INSERT INTO modulos (nome)
VALUES ('Consultas em SQL');

-- insercoes de aulas
INSERT INTO aulas (nome, descricao, id_modulo)
VALUES ('Variáveis e Tipos', 'Tipos de dados em programação', 1);

INSERT INTO aulas (nome, descricao, id_modulo)
VALUES ('Tags HTML', 'Elementos fundamentais de uma página', 2);

INSERT INTO aulas (nome, descricao, id_modulo)
VALUES ('SELECT Básico', 'Usando SELECT em SQL', 3);

-- insercoes atividades
INSERT INTO atividades (nome, descricao, idcurso)
VALUES ('Exercício de Variáveis', 'Resolver 5 questões', 1);

INSERT INTO atividades (nome, descricao, idcurso)
VALUES ('Criar Página HTML', 'Criar estrutura HTML simples', 2);

INSERT INTO atividades (nome, descricao, idcurso)
VALUES ('Consulta de Tabela', 'Criar consulta SELECT', 3);

-- insercoes inscricoes
INSERT INTO inscricoes (id_aluno, id_curso, data_inscricao)
VALUES (1, 1, '2025-05-01');

INSERT INTO inscricoes (id_aluno, id_curso, data_inscricao)
VALUES (1, 2, '2025-05-02');

INSERT INTO inscricoes (id_aluno, id_curso, data_inscricao)
VALUES (1, 3, '2025-05-03');

-- insercoes envios atividade
INSERT INTO envios_atividades (id_aluno, idatividade, data_envio)
VALUES (1, 1, '2025-05-04');

INSERT INTO envios_atividades (id_aluno, idatividade, data_envio)
VALUES (1, 2, '2025-05-05');

INSERT INTO envios_atividades (id_aluno, idatividade, data_envio)
VALUES (1, 3, '2025-05-06');

-- att em usuarios
UPDATE usuario
SET nome = 'Thiago Damas', email = 'Thiago@email.com'
WHERE id = 1;

UPDATE usuario
SET nome = 'Rodrigo Armengol', email = 'Rodrigo@email.com'
WHERE id = 4;

-- Juntando a tabela perfis com a tabela usuario
SELECT * FROM usuario u 
JOIN perfis p 
ON u.id = p.id 
JOIN cursos ON p.id = curso.idcursos;

-- Juntando usuarios,curso e inscricoes pra saber qual usuario está em qual curso
SELECT u.nome, c.nome AS curso
FROM usuario u
JOIN inscricoes i ON u.id = i.id_aluno
JOIN cursos c ON i.id_curso = c.idcurso
WHERE u.nome = 'Thiago Damas';

-- Juntando aulas, modulos e curso para saber qual curso tem qual aula
SELECT 
    c.nome AS curso,
    m.nome AS modulo,
    a.nome AS aula
FROM cursos c
JOIN modulos m ON c.idcurso = m.idcurso
JOIN aulas a ON m.idmodulo = a.id_modulo
ORDER BY c.nome, m.nome, a.nome;

-- View para evitar a criação e repetições do JOIN para ver quais alunos estão em qual curso
CREATE VIEW vw_alunos_cursos AS
SELECT u.nome AS aluno, c.nome AS curso
FROM usuario u
JOIN inscricoes i ON u.id = i.id_aluno
JOIN cursos c ON i.id_curso = c.idcurso
WHERE u.tipo_usuario = 'aluno';

SELECT * FROM vw_alunos_cursos;

-- Trigger para registrar quando um aluno se matricula em um curso e impedir a exclusao de um curso com modulos vinculados
CREATE TRIGGER tr_data_inscricao
BEFORE INSERT ON inscricoes
FOR EACH ROW
SET NEW.data_inscricao = DATE_FORMAT(NOW(), '%Y-%m-%d'); -- pega e formata a data atual











