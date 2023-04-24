package br.com.atendimento.AtendimentoAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ReceitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idReceitaMedica;

    @Column(nullable = false, length = 250)
    private String medicamento;

    @Column(nullable = false, length = 500)
    private String prescricao;
}
