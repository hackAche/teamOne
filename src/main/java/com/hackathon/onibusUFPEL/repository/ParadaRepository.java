package com.hackathon.onibusUFPEL.repository;

import com.hackathon.onibusUFPEL.model.Parada;
import com.hackathon.onibusUFPEL.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mauricio
 */
public interface ParadaRepository extends JpaRepository<Parada, Long> {

    /**
     * Retorna uma lista, não ordenada, de todas as paradas com base no
     * parâmetro ponto
     *
     * @param ponto
     * @return List of Parada
     */
    @Query("SELECT p FROM Parada p WHERE p.ponto =: ponto")
    List<Parada> findParadaByPontoParam(
            @Param("ponto") Ponto ponto);
}
