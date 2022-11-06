package com.hackathon.onibusUFPEL;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.Rota;
import com.hackathon.onibusUFPEL.resource.OnibusResource;

/**
 *
 * @author Mauricio
 */
public class Simulacao {
    
    private OnibusResource onibusResource;

    public Simulacao(OnibusResource onibusResource) {
        this.onibusResource = onibusResource;
    }
    
    public static void main(String[] args) {
        
    }
    
    private Onibus ativarOnibus(long id) {
       Onibus elem = onibusResource.buscaById(id).getBody(); //ws
       elem.setAtivo(Boolean.TRUE); //ws
       return elem;
    }
    
    private void criarRelatorio(Rota rota) {
        RelatorioParadaDTO rpDT = new RelatorioParadaDTO();
    }
}
