CREATE TABLE turma (
	idturma SERIAL NOT NULL,
	siglaturma VARCHAR(2),
	periodoturma VARCHAR(20),
	CONSTRAINT pk_turma PRIMARY KEY (idturma)
);

CREATE TABLE aluno (
	idaluno SERIAL NOT NULL,
	nomealuno VARCHAR(200),
        telefonealuno VARCHAR(20),
        idturma INT NOT NULL,
	CONSTRAINT fk_turma FOREIGN KEY (idturma) REFERENCES turma
);

INSERT INTO turma (siglaturma, periodoturma) VALUES ('1A', 'matutino');
INSERT INTO turma (siglaturma, periodoturma) VALUES ('2A', 'vespertino');
INSERT INTO turma (siglaturma, periodoturma) VALUES ('3A', 'noturno');

INSERT INTO aluno (nomealuno, telefonealuno, idturma) VALUES ('Matheus', '17996621221', 1);
INSERT INTO aluno (nomealuno, telefonealuno, idturma) VALUES ('teste2', '99999999999', 2);
INSERT INTO aluno (nomealuno, telefonealuno, idturma) VALUES ('teste3', '88888888888', 3);