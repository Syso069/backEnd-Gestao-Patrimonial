CREATE SEQUENCE patrimonio_id_seq START 1;

CREATE TABLE patrimonio(
    id NUMERIC PRIMARY KEY NOT NULL DEFAULT nextval('patrimonio_id_seq'),
    codigo_patrimonio TEXT NOT NULL,
    tipo TEXT NOT NULL,
    localizacao TEXT NOT NULL,
    estado TEXT NOT NULL,
    responsavel_atual TEXT NOT NULL,
    data_aquisicao DATE NOT NULL
);

CREATE TABLE localizacao (
    id NUMERIC AUTO_INCREMENT PRIMARY KEY,
    logradouro TEXT NOT NULL,
    numero NUMERIC,
    uf TEXT NOT NULL,
    cidade TEXT NOT NULL,
    setor TEXT NOT NULL,
    cep TEXT NOT NULL,
    complemento TEXT
);

CREATE TABLE inventario(
    id NUMERIC AUTO_INCREMENT PRIMARY KEY,
    fk_patrimonio INT,
    fk_localizacao INT,
    FOREIGN KEY (fk_patrimonio) REFERENCES patrimonio(id),
    FOREIGN KEY (fk_localizacao) REFERENCES localizacao(id)
);