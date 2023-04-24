package br.com.atendimento.AtendimentoAPI.requests;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AtendimentoPostRequest {
    private Date dataHora;
    private Integer idMedico;
    private Integer idPaciente;
    private List<ReceitaMedicaPostRequest> receitas;
}
