package br.com.atendimento.AtendimentoAPI.repositories;

import br.com.atendimento.AtendimentoAPI.entities.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicoRepository extends CrudRepository<Medico, Integer> {
    @Query("select m from Medico m order by m.nome")
    List<Medico> findAll();
}
