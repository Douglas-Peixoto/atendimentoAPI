package br.com.atendimento.AtendimentoAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 150)
    private Integer idMedico;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 25,unique = true)
    private String crm;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String tipo;
}
