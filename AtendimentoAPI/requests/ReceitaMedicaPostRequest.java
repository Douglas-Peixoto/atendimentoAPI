package br.com.atendimento.AtendimentoAPI.requests;

import lombok.Data;

@Data
public class ReceitaMedicaPostRequest {
    private String medicamento;
    private String prescricao;
}
