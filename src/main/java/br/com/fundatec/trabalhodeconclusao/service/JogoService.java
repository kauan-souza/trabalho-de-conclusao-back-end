package br.com.fundatec.trabalhodeconclusao.service;

import br.com.fundatec.trabalhodeconclusao.domain.Jogo;
import br.com.fundatec.trabalhodeconclusao.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class JogoService {

    private final JogoRepository jogosRepository;

    public List<Jogo> jogosDeHoje() {
        var jogos = this.jogosRepository.findAll();
        Predicate<Jogo> predicado = (Jogo a) -> a.getData().equals(LocalDate.now());

        return jogos.stream().filter(predicado).toList();
    }

    public List<Jogo> jogosDeAmanha() {
        var jogos = this.jogosRepository.findAll();

        return jogos.stream().filter(jogo -> jogo.getData().equals(LocalDate.now().plusDays(1))).toList();
    }

    public void adicionar(Collection<Jogo> jogos) {
        jogosRepository.saveAll(jogos);
    }
}
