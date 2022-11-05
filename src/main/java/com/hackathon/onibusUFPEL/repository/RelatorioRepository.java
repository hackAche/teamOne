package com.hackathon.onibusUFPEL.repository;

import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.RelatorioParada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Mauricio
 */
public interface RelatorioRepository extends JpaRepository<RelatorioParada, Long> {

    @Query("SELECT r FROM RelatorioParada r WHERE r.id = :id")
    RelatorioParada findRelatorioByIdParam(
            @Param("id") Long id);

    @Query("SELECT r FROM RelatorioParada r WHERE r.onibus = :onibus")
    List<RelatorioParada> findRelatoriosByOnibusParam(
            @Param("onibus") Onibus onibus);
}
