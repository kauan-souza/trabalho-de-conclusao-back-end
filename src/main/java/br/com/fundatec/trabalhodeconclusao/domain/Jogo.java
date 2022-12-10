package br.com.fundatec.trabalhodeconclusao.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Document
public class Jogo {

    @Id
    private String id;

    private String timeMandante;

    private String timeVisitante;

    private String horario;

    private List<String> transmissao;

    private LocalDate data;

}
