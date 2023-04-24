package br.com.atendimento.AtendimentoAPI.repositories;

import br.com.atendimento.AtendimentoAPI.entities.ReceitaMedica;
import org.springframework.data.repository.CrudRepository;

public interface ReceitaMedicaRepository extends CrudRepository<ReceitaMedica, Integer> {
}
