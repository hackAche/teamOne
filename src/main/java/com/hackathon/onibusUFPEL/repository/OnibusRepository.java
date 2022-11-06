package com.hackathon.onibusUFPEL.repository;

import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.Rota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Mauricio
 */
public interface OnibusRepository extends JpaRepository<Onibus, Long> {


    /**
     * Retorna uma lista, não ordenada, de todos os ônibus ativos
     *
     * @return List of Onibus
     */
    @Query("SELECT o FROM Onibus o WHERE o.ativo is true")
    List<Onibus> findAllActiveOnibus();


    /**
     * Retorna uma lista, não ordenada, dos ônibus com base no parâmetro rota
     *
     * @param rota
     * @return
     */
    @Query("SELECT o FROM Onibus o WHERE o.rota = :rota")
    List<Onibus> findOnibusByRotaParam(
            @Param("rota") Rota rota);
}
