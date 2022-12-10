package br.com.fundatec.trabalhodeconclusao.service;

import static org.mockito.Mockito.when;

import br.com.fundatec.trabalhodeconclusao.domain.Jogo;
import br.com.fundatec.trabalhodeconclusao.repository.JogoRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JogoServiceTest {

    @InjectMocks
    private JogoService jogoService;

    @Mock
    private JogoRepository jogosRepository;

    @Test
    void deveMostrarOsJogosDeHoje() {

        when(jogosRepository.findAll()).thenReturn(List.of(
            new Jogo(
                "1",
                "aa",
                "bb",
                "21:00",
                List.of("espn"),
                LocalDate.now()
            ),
            new Jogo(
                "2",
                "aa",
                "bb",
                "21:00",
                List.of("espn"),
                LocalDate.now().plusDays(1)
            )
        ));

        var esperado = jogoService.jogosDeHoje();

        Assertions.assertEquals(1, esperado.size());
        Assertions.assertEquals("1", esperado.get(0).getId());
    }

    @Test
    void deveMostrarOsJogosDeAmanha() {

        when(jogosRepository.findAll()).thenReturn(List.of(
            new Jogo(
                "1",
                "aa",
                "bb",
                "21:00",
                List.of("espn"),
                LocalDate.now()
            ),
            new Jogo(
                "2",
                "aa",
                "bb",
                "21:00",
                List.of("espn"),
                LocalDate.now().plusDays(1)
            )
        ));

        var esperado = jogoService.jogosDeAmanha();

        Assertions.assertEquals(1, esperado.size());
        Assertions.assertEquals("2", esperado.get(0).getId());
    }

}
