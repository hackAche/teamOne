package com.hackathon.onibusUFPEL.resource;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.model.Localizacao;
import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.Parada;
import com.hackathon.onibusUFPEL.model.Ponto;
import com.hackathon.onibusUFPEL.model.RelatorioParada;
import com.hackathon.onibusUFPEL.repository.OnibusRepository;
import com.hackathon.onibusUFPEL.repository.ParadaRepository;
import com.hackathon.onibusUFPEL.repository.PontoRepository;
import com.hackathon.onibusUFPEL.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onibus")
public class OnibusResource {

    private final OnibusRepository onibusRepository;
    private final ParadaRepository paradaRepository;
    private final RelatorioRepository relatorioRepository;
    private final PontoRepository pontoRepository;

    @Autowired
    public OnibusResource(OnibusRepository onibusRepository, ParadaRepository paradaRepository,
            RelatorioRepository relatorioRepository, PontoRepository pontoRepository) {
        this.onibusRepository = onibusRepository;
        this.paradaRepository = paradaRepository;
        this.relatorioRepository = relatorioRepository;
        this.pontoRepository = pontoRepository;
    }

    @GetMapping
    public List<Onibus> listar() {
        return onibusRepository.findAll();
    }

    @GetMapping("/ativos")
    public List<Onibus> listarAtivos() {
        return onibusRepository.findAllActiveOnibus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Onibus> buscaById(@PathVariable Long id) {
        Optional<Onibus> categoriaOptional = onibusRepository.findById(id);
        return categoriaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/toggleAtivo")
    public ResponseEntity toggleAtivoOnibus(@PathVariable Long id) {
        Optional<Onibus> optionalOnibus = onibusRepository.findById(id);
        if (optionalOnibus.isPresent()) {
            Onibus onibus = optionalOnibus.get();
            onibus.setAtivo(!onibus.getAtivo());
            onibusRepository.save(onibus);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/atualizaLocalizacao")
    public ResponseEntity atualizaLocalizacao(@PathVariable Long id, @RequestBody Localizacao localizacao) {
        Optional<Onibus> optionalOnibus = onibusRepository.findById(id);
        if (optionalOnibus.isPresent()) {
            Onibus onibus = optionalOnibus.get();
            onibus.setLocalizacao(localizacao);
            Optional<Parada> optionalProximaParada = getProximaParadaLocalizacao(localizacao, onibus);
            optionalProximaParada.ifPresent(parada -> onibus.setParadaAtual(parada));
            onibusRepository.save(onibus);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Optional<Parada> getProximaParadaLocalizacao(Localizacao localizacao, Onibus onibus) {
        Optional<Ponto> optionalPonto = pontoRepository.findPontoByLocalizacao(localizacao.getX(), localizacao.getY());
        if (optionalPonto.isPresent()) {
            Optional<List<Parada>> optionalParadas = paradaRepository
                    .findParadaByPontoParam(optionalPonto.get());
            if (optionalParadas.isPresent()) {
                List<Parada> paradas = optionalParadas.get();
                //Feito para protótipo, vai dar errado se houver mais de um mesmo ponto na mesma rota
                return paradaRepository
                        .findParadaByOrdem(onibus.getRota(), paradas.get(0).getOrdem() + 1);

            }
        }
        return Optional.empty();
    }

    @PostMapping("/criaRelatorio")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRelatorio(@RequestBody RelatorioParadaDTO relatorioParadaDTO) {
        Optional<Parada> optionalParada = paradaRepository.findById(relatorioParadaDTO.getParadaId());
        Optional<Onibus> optionalOnibus = onibusRepository.findById(relatorioParadaDTO.getOnibusId());
        if (optionalParada.isPresent() && optionalOnibus.isPresent()) {
            RelatorioParada relatorioParada = relatorioParadaDTO.transformaParaRelatorioParada(optionalParada.get(), optionalOnibus.get());
            relatorioRepository.save(relatorioParada);
        }
    }
}
