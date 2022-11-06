package com.hackathon.onibusUFPEL.resource;

import com.hackathon.onibusUFPEL.DTO.RelatorioParadaDTO;
import com.hackathon.onibusUFPEL.model.Onibus;
import com.hackathon.onibusUFPEL.model.Parada;
import com.hackathon.onibusUFPEL.model.RelatorioParada;
import com.hackathon.onibusUFPEL.repository.OnibusRepository;
import com.hackathon.onibusUFPEL.repository.ParadaRepository;
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

    @Autowired
    public OnibusResource(OnibusRepository onibusRepository, ParadaRepository paradaRepository, RelatorioRepository relatorioRepository) {
        this.onibusRepository = onibusRepository;
        this.paradaRepository = paradaRepository;
        this.relatorioRepository = relatorioRepository;
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

    @PostMapping("/criaRelatorio")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRelatorio(@RequestBody RelatorioParadaDTO relatorioParadaDTO) {
        Optional<Parada> optionalParada = paradaRepository.findById(relatorioParadaDTO.getParadaId());
        Optional<Onibus> optionalOnibus = onibusRepository.findById(relatorioParadaDTO.getOnibusId());
        if(optionalParada.isPresent() && optionalOnibus.isPresent()){
            RelatorioParada relatorioParada =  relatorioParadaDTO.transformaParaRelatorioParada(optionalParada.get(), optionalOnibus.get());
            relatorioRepository.save(relatorioParada);
        }
    }
}
