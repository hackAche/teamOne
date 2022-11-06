package com.hackathon.onibusUFPEL.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "relatorioparada")
public class RelatorioParada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="parada_id")
    private Parada parada;
    
    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name="onibus_id")
    private Onibus onibus;

    private LocalDate dataHorario;

    private Integer vagasUtilizadas;

    private Integer qtdSairam;

    private Integer qtdEntraram;

    public RelatorioParada() {
    }

    public RelatorioParada(Parada parada, Onibus onibus, LocalDate dataHorario, Integer vagasUtilizadas, Integer qtdSairam, Integer qtdEntraram) {
        this.parada = parada;
        this.onibus = onibus;
        this.dataHorario = dataHorario;
        this.vagasUtilizadas = vagasUtilizadas;
        this.qtdSairam = qtdSairam;
        this.qtdEntraram = qtdEntraram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public LocalDate getHorario() {
        return dataHorario;
    }

    public void setHorario(LocalDate horario) {
        this.dataHorario = horario;
    }

    public Integer getVagasUtilizadas() {
        return vagasUtilizadas;
    }

    public void setVagasUtilizadas(Integer vagasUtilizadas) {
        this.vagasUtilizadas = vagasUtilizadas;
    }

    public Integer getQtdSairam() {
        return qtdSairam;
    }

    public void setQtdSairam(Integer qtdSairam) {
        this.qtdSairam = qtdSairam;
    }

    public Integer getQtdEntraram() {
        return qtdEntraram;
    }

    public void setQtdEntraram(Integer qtdEntraram) {
        this.qtdEntraram = qtdEntraram;
    }

    
    
}
