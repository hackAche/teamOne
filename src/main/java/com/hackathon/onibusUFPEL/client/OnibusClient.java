package com.hackathon.onibusUFPEL.client;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.model.Localizacao;
import com.hackathon.onibusUFPEL.model.Onibus;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author aluno
 */
@RestController
public class OnibusClient {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/template/onibus/{id}")
    public Onibus getOnibus(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8080/onibus/" + id,
                HttpMethod.GET, entity, Onibus.class).getBody();
    }

    @RequestMapping(value = "/template/onibus/{idOnibus}/atualizaLocalizacao",
            method = RequestMethod.POST)
    public String atualizaLocalizacaoOnibus(@PathVariable Long idOnibus,
            @RequestBody Localizacao localizacao) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Localizacao> entity = new HttpEntity<>(localizacao, headers);
        return restTemplate.exchange(
                "http://localhost:8080/onibus/" + idOnibus + "/atualizaLocalizacao",
                HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/onibus/{idOnibus}/toggleAtivo",
            method = RequestMethod.POST)
    public void ativarOnibus(@PathVariable Long idOnibus) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.exchange(
                "http://localhost:8080/onibus/" + idOnibus + "/toggleAtivo",
                HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/onibus/criaRelatorio",
            method = RequestMethod.POST)
    public String criaRelatorioOnibus(@PathVariable Long idOnibus,
            @RequestBody RelatorioParadaDTO relatorioDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<RelatorioParadaDTO> entity = new HttpEntity<>(relatorioDTO, headers);
        return restTemplate.exchange(
                "http://localhost:8080/onibus/criaRelatorio",
                HttpMethod.POST, entity, String.class).getBody();
    }

}
