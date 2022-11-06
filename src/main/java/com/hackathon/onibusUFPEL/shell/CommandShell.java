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

    @ShellMethod
    public String execute() throws InterruptedException {
        Onibus onibus = client.getOnibus(1l);
        client.ativarOnibus(onibus.getId());

        //PARADA XV
        criaRelatorio(onibus, 1l, 42, 0);
        atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(-31.773356),
                BigDecimal.valueOf(-52.343319))
        );
        Thread.sleep(1000);

        //CEU
        criaRelatorio(onibus, 2l, 10, 15);
                atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(-31.772851),
                BigDecimal.valueOf(-52.348393))
        );
        Thread.sleep(3000);

        //LANEIRA
        criaRelatorio(onibus, 3l, 15, 5);
                atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(-31.762406),
                BigDecimal.valueOf(-52.358084))
        );
        Thread.sleep(5000l);

        //FAMED
        criaRelatorio(onibus, 4l, 3, 0);
                atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(31.760198),
                BigDecimal.valueOf(-52.362177))
        );
        Thread.sleep(3000l);

        //ROTULA
        criaRelatorio(onibus, 5l, 2, 0);
                atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(-31.762734),
                BigDecimal.valueOf(-52.418920))
        );
        Thread.sleep(8000l);

        //CAMPUS CAPÃO
        criaRelatorio(onibus, 6l, 0, onibus.getVagasUtilizadas());
                atualizaLocalizacaoOnibus(onibus, new Localizacao(
                BigDecimal.valueOf(-31.797449),
                BigDecimal.valueOf(-52.407675))
        );
        return "Finalizado";
    }

    public void atualizaLocalizacaoOnibus(Onibus onibus, Localizacao localizacao) {
        client.atualizaLocalizacaoOnibus(onibus.getId(), localizacao);
    }

    public void criaRelatorio(Onibus onibus, Long paradaId, int entrou, int saiu) {
        RelatorioParadaDTO rpDT = new RelatorioParadaDTO();
        rpDT.setOnibusId(onibus.getId());
        rpDT.setParadaId(paradaId);
        rpDT.setDataHorario(LocalDateTime.now());
        rpDT.setQtdEntraram(entrou);
        rpDT.setQtdSairam(saiu);
        rpDT.setVagasUtilizadas(onibus.getVagasUtilizadas() - saiu + entrou);
        client.criaRelatorioOnibus(onibus.getId(), rpDT);
    }

}
