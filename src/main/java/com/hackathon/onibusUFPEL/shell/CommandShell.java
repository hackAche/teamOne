/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackathon.onibusUFPEL.shell;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.client.OnibusClient;
import com.hackathon.onibusUFPEL.model.Localizacao;
import com.hackathon.onibusUFPEL.model.Onibus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 *
 * @author aluno
 */
@ShellComponent
public class CommandShell {

    @Autowired
    OnibusClient client;

    @ShellMethod
    public void executar() {

    }

    @ShellMethod
    public String getOnibus(Long id) {
        Onibus onibus = client.getOnibus(id);
        return onibus.toString();
    }

    @ShellMethod
    public String atualizaLocalizacaoOnibus() {
        client.atualizaLocalizacaoOnibus(1l,
                new Localizacao(new BigDecimal(-31.773356), new BigDecimal(-52.343319)));
        return "Localizacao atualizacao";
    }

    @ShellMethod
    public String criaRelatorio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
        RelatorioParadaDTO rel = new RelatorioParadaDTO();
        rel.setDataHorario(LocalDateTime.parse("06/11/2022 11:51:00", formatter));
        rel.setOnibusId(1l);
        rel.setParadaId(1l);
        rel.setQtdEntraram(30);
        rel.setQtdSairam(0);
        rel.setVagasUtilizadas(30);
        client.criaRelatorioOnibus(1l, rel);
        return "Relatório criado";
    }

}
