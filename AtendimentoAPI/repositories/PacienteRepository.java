package br.com.atendimento.AtendimentoAPI.repositories;

import br.com.atendimento.AtendimentoAPI.entities.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
    @Query("select p from Paciente p order by p.nome")
    List<Paciente> findAll();
}
