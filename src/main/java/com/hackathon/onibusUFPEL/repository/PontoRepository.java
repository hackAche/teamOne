package com.hackathon.onibusUFPEL.repository;

import com.hackathon.onibusUFPEL.model.Ponto;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author aluno
 */
public interface PontoRepository extends JpaRepository<Ponto, Long> {

    @Query("SELECT p FROM Ponto p WHERE p.localizacao.x = :x and p.localizacao.y = :y")
    Optional<Ponto> findPontoByLocalizacao(@Param("x") BigDecimal x, @Param("y") BigDecimal y);

}
