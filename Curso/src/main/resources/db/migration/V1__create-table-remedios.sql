 CREATE TABLE remedios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    lote VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    validade VARCHAR(100) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
 );
