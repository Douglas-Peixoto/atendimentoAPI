package br.com.atendimento.AtendimentoAPI.controllers;

import br.com.atendimento.AtendimentoAPI.entities.Paciente;
import br.com.atendimento.AtendimentoAPI.repositories.PacienteRepository;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Transactional
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @ApiOperation("Serviço para consulta de pacientes.")
    @RequestMapping(value = "/api/pacientes", method = RequestMethod.GET)

    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<Paciente>> getAll(){
        try {
            List<Paciente> pacientes = pacienteRepository.findAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pacientes);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
