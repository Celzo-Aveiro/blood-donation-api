package celzoo.project.bloood.donation.controller;

import celzoo.project.bloood.donation.model.Candidato;
import celzoo.project.bloood.donation.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidatos")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/importar")
    public ResponseEntity<Void> importarCandidatos(@RequestBody List<Candidato> candidatos) {
        candidatoService.importarCandidatos(candidatos);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contarPorEstado")
    public Map<String, Long> contarCandidatosPorEstado() {
        return candidatoService.contarCandidatosPorEstado();
    }

    @GetMapping("/recuperarImcMedio")
    public Map<Integer, Double> recuperaImcMedio() {
        return candidatoService.calcularIMCMedioPorFaixaDeIdade();
    }

    @GetMapping("/recuperarPercentualDeObesosPorGenero")
    public Map<String, Double> recuperaObesidadePorSexo() {
        return candidatoService.calcularPercentualObesosPorSexo();
    }

    @GetMapping("/recuperarMediaDeIdadePorTipoSanguineo")
    public Map<String, Double> recuperaMediaDeIdadePorTipoSanguineo() {
        return candidatoService.calcularMediaIdadePorTipoSanguineo();
    }

    @GetMapping("/recuperarDoadoresPorTipoSanguineo")
    public Map<String, Long> recuperaDoadoresPorTipoSanguineo() {
        return candidatoService.contarDoadoresPorTipoSanguineo();
    }

}
