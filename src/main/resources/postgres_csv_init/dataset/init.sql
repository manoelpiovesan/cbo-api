CREATE TABLE cbo
(
    id SERIAL PRIMARY KEY,
    code TEXT,
    description TEXT
);

COPY cbo(code, description)
    FROM '/docker-entrypoint-initdb.d/ocupacoes.csv'
    DELIMITER ';'
    CSV HEADER;