package com.hackaton.onibusUFPEL.silmulator;

import com.hackaton.onibusUFPEL.model.Parada;
import com.hackaton.onibusUFPEL.model.Ponto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Mauricio
 */
public interface ParadaRepository extends JpaRepository<Parada, Long> {

    /**
     * Retorna uma lista, não ordenada, de todas as paradas
     *
     * @return List of Parada
     */
    @Query("SELECT p FROM Parada p")
    List<Parada> findAllParadas();

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

    /**
     * Retorna um único elemento da Entity Parada com base no parâmetro id
     *
     * @param id
     * @return Parada
     */
    @Query("SELECT p FROM Parada p WHERE p.id = :id")
    Parada findParadaByIdParam(
            @Param("id") Long id);
}
