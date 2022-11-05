package com.hackaton.onibusUFPEL.silmulator;

import com.hackaton.onibusUFPEL.model.Onibus;
import com.hackaton.onibusUFPEL.model.Rota;
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

    /**
     * Retorna um único elemento da Entity Onibus com base no parâmetro id
     *
     * @param id
     * @return Onibus
     */
    @Query("SELECT o FROM Onibus o WHERE o.id = :id")
    Onibus findOnibusByIdParam(
            @Param("id") Long id);
}
