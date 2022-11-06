/**
 * Author:  aluno
 * Created: 5 de nov de 2022
 */

CREATE TABLE ponto (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    x FLOAT,
    y FLOAT,
    precisao FLOAT
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE rota (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE parada (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    ponto_id BIGINT(20),
    rota_id BIGINT(20),
    INDEX rota_index (rota_id),
    FOREIGN KEY (rota_id)
        REFERENCES rota(id)
        ON DELETE CASCADE,
    FOREIGN KEY (ponto_id)
        REFERENCES ponto(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE onibus (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    x FLOAT,
    y FLOAT,
    precisao FLOAT,
    ativo BOOLEAN, 
    acessibilidade BOOLEAN,
    vagas_totais INT,
    vagas_utilizadas INT,
    rota_id BIGINT(20),
    FOREIGN KEY (rota_id)
        REFERENCES rota(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE relatorioparada (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    parada_id BIGINT(20),
    onibus_id BIGINT(20),
    data_horario DATETIME,
    vagas_utilizadas INT,
    qtd_sairam INT,
    qtd_entraram INT,
    FOREIGN KEY (parada_id)
        REFERENCES parada(id),
    FOREIGN KEY (onibus_id)
        REFERENCES onibus(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;