package com.hackathon.onibusUFPEL.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.Parada;
import com.hackathon.onibusUFPEL.model.RelatorioParada;

import java.time.LocalDate;

public class RelatorioParadaDTO {

    private Long paradaId;

    private Long onibusId;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataHorario;

    private Integer vagasUtilizadas;

    private Integer qtdSairam;

    private Integer qtdEntraram;

    public RelatorioParadaDTO() {
    }

    public RelatorioParada transformaParaRelatorioParada(Parada parada, Onibus onibus) {
        return new RelatorioParada(parada, onibus, dataHorario, vagasUtilizadas, qtdSairam, qtdEntraram);
    }

    public Long getParadaId() {
        return paradaId;
    }

    public void setParadaId(Long paradaId) {
        this.paradaId = paradaId;
    }

    public Long getOnibusId() {
        return onibusId;
    }

    public void setOnibusId(Long onibusId) {
        this.onibusId = onibusId;
    }

    public LocalDate getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDate dataHorario) {
        this.dataHorario = dataHorario;
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
