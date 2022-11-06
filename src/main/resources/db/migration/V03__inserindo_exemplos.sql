/**
 * Author:  aluno
 * Created: 5 de nov de 2022
 */

INSERT INTO ponto (id, nome, x, y)
VALUES (1, "PARADA XV", -31.773356, -52.343319);

INSERT INTO ponto (id, nome, x, y)
VALUES (2, "CEU", -31.772851, -52.348393);

INSERT INTO ponto (id, nome, x, y)
VALUES (3, "LANEIRA", -31.762406, -52.358084);

INSERT INTO ponto (id, nome, x, y)
VALUES (4, "FAMED", -31.760198, -52.362177);

INSERT INTO ponto (id, nome, x, y)
VALUES (5, "ROTULA", -31.762734, -52.418920);

INSERT INTO ponto (id, nome, x, y)
VALUES (6, "CAMPUS CAPÃO", -31.797449, -52.407675);

INSERT INTO rota (id, nome)
VALUES (1, "LINHA PELOTAS->CAPÃO");

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (1, 1, 1);

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (2, 1, 2);

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (3, 1, 3);

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (4, 1, 4);

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (5, 1, 5);

INSERT INTO parada (ponto_id, rota_id, ordem)
VALUES (6, 1, 6);

INSERT INTO onibus (x, y, ativo, acessibilidade, vagas_totais, vagas_utilizadas, rota_id )
VALUES (-31.780187, -52.323844, true, true, 80, 0, 1 );



