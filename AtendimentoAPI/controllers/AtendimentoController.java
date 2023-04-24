package br.com.atendimento.AtendimentoAPI.controllers;

import br.com.atendimento.AtendimentoAPI.entities.Atendimento;
import br.com.atendimento.AtendimentoAPI.entities.Medico;
import br.com.atendimento.AtendimentoAPI.entities.Paciente;
import br.com.atendimento.AtendimentoAPI.entities.ReceitaMedica;
import br.com.atendimento.AtendimentoAPI.repositories.AtendimentoRepository;
import br.com.atendimento.AtendimentoAPI.repositories.MedicoRepository;
import br.com.atendimento.AtendimentoAPI.repositories.PacienteRepository;
import br.com.atendimento.AtendimentoAPI.requests.AtendimentoPostRequest;
import br.com.atendimento.AtendimentoAPI.requests.ReceitaMedicaPostRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Controller
public class AtendimentoController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;


    @ApiOperation("Serviço para cadastro de atendimentos.")
    @RequestMapping(value = "/api/atendimento", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<String> post(@RequestBody AtendimentoPostRequest request){

        try {
            Optional<Medico> medico = medicoRepository.findById(request.getIdMedico());
            if (medico.isEmpty())
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Medico não encontrado");

            Optional<Paciente> paciente = pacienteRepository.findById(request.getIdPaciente());
            if (paciente.isEmpty())
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Paciente não encontrado");


            Atendimento atendimento = new Atendimento();

            atendimento.setDataHora(request.getDataHora());
            atendimento.setMedico(medico.get());
            atendimento.setPaciente(paciente.get());

            List<ReceitaMedica> receitas = new ArrayList<ReceitaMedica>();
            for (ReceitaMedicaPostRequest item : request.getReceitas()) {

                ReceitaMedica receitaMedica = new ReceitaMedica();
                receitaMedica.setMedicamento(item.getMedicamento());
                receitaMedica.setPrescricao(item.getPrescricao());
                receitas.add(receitaMedica);

            }

            atendimento.setReceitaMedicas(receitas);

            atendimentoRepository.save(atendimento);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Atendimento cadastrado com sucesso!!!");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @ApiOperation("Serviço para comsulta de atendimentos.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<List<Atendimento>> getAll(){
        try {

            List<Atendimento> atendimentos = atendimentoRepository.findAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(atendimentos);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
