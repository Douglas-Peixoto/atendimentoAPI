package br.com.atendimento.AtendimentoAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAtendimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "Medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "Paciente", nullable = false)
    private Paciente paciente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "atendimento_receitaMedica",
               joinColumns = @JoinColumn(name = "idAtendimento", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "idReceitaMedica", nullable = false))
    private List<ReceitaMedica> receitaMedicas;

}
