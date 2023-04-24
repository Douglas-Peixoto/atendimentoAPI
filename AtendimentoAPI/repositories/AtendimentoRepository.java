package br.com.atendimento.AtendimentoAPI.repositories;

import br.com.atendimento.AtendimentoAPI.entities.Atendimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {
    @Query("select a from Atendimento  a order by a.dataHora desc")
    List<Atendimento> findAll();
}
