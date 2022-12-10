package br.com.fundatec.trabalhodeconclusao.repository;

import br.com.fundatec.trabalhodeconclusao.domain.Jogo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogoRepository extends MongoRepository<Jogo, String> {

    List<Jogo> findAll ();
}
