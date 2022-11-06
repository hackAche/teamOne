package com.hackathon.onibusUFPEL;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.model.Localizacao;
import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.resource.OnibusResource;
import java.lang.Thread;
import java.math.BigDecimal;

/**
 *
 * @author Mauricio
 */
public class Simulacao {

    private OnibusResource or;

    public Simulacao() {
    }

    public Simulacao(OnibusResource or) {
        this.or = or;
    }

    public OnibusResource getOr() {
        return or;
    }

    public void setOr(OnibusResource or) {
        this.or = or;
    }

    public static void main(String[] args) throws InterruptedException {
        Simulacao s = new Simulacao();
        Onibus onibus = (Onibus) s.getOr().buscaById(1l).getBody();
        onibus = (Onibus) s.getOr().toggleAtivoOnibus(onibus.getId()).getBody();

        //PARADA XV
        fillRelatorio(onibus, 42, 0);
        Thread.sleep(2500l);
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.773356),
                BigDecimal.valueOf(-52.343319))
        ).getBody();

        //CEU
        fillRelatorio(onibus, 3, 10);
        Thread.sleep(4500l);
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.772851),
                BigDecimal.valueOf(-52.348393))
        ).getBody();

        //Entre Paradas        
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.772851),
                BigDecimal.valueOf(-52.348393))
        ).getBody();

        //LANEIRA
        fillRelatorio(onibus, 5, 5);
        Thread.sleep(3500l);
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.762406),
                BigDecimal.valueOf(-52.358084))
        ).getBody();

        //FAMED
        fillRelatorio(onibus, 5, 10);
        Thread.sleep(2500l);
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.760198),
                BigDecimal.valueOf(-52.362177))
        ).getBody();

        //ROTULA
        fillRelatorio(onibus, 5, 0);
        Thread.sleep(8000l);
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.762734),
                BigDecimal.valueOf(-52.418920))
        ).getBody();

        //Entre Paradas        
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.772851),
                BigDecimal.valueOf(-52.348393))
        ).getBody();

        //CAMPUS CAPÃO
        fillRelatorio(onibus, 0, onibus.getVagasUtilizadas());
        onibus = (Onibus) s.getOr().atualizaLocalizacao(onibus.getId(), new Localizacao(
                BigDecimal.valueOf(-31.797449),
                BigDecimal.valueOf(-52.407675))
        ).getBody();
    }

    private static RelatorioParadaDTO fillRelatorio(Onibus onibus, int entrou,
            int saiu) {
        RelatorioParadaDTO rpDT = new RelatorioParadaDTO();
        rpDT.setOnibusId(onibus.getId());
        rpDT.setParadaId(onibus.getParadaAtual().getId());
        rpDT.setQtdEntraram(entrou);
        rpDT.setQtdSairam(saiu);
        rpDT.setVagasUtilizadas(onibus.getVagasUtilizadas() - saiu + entrou);
        return rpDT;
    }
}
