package br.com.fundatec.trabalhodeconclusao.controller;

import br.com.fundatec.trabalhodeconclusao.domain.Jogo;
import br.com.fundatec.trabalhodeconclusao.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class JogoController {

    private final JogoService jogoService;

    @PostMapping("/jogos")
    public void adicionaJogos(@RequestBody Collection<Jogo> jogos) {
        jogoService.adicionar(jogos);
    }

    @GetMapping("/jogos/hoje")
    public List<Jogo> jogosHoje() {
        return jogoService.jogosDeHoje();
    }

    @GetMapping("/jogos/amanha")
    public List<Jogo> jogosAmanha() {
        return jogoService.jogosDeAmanha();
    }
}
