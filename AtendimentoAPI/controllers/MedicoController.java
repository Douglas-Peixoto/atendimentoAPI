package br.com.atendimento.AtendimentoAPI.controllers;

import br.com.atendimento.AtendimentoAPI.entities.Medico;
import br.com.atendimento.AtendimentoAPI.repositories.MedicoRepository;
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
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;


    @ApiOperation("Serviço para consulta de médicos.")
    @RequestMapping(value = "/api/medicos", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<Medico>> getAll(){
        try {
            List<Medico> medicos = medicoRepository.findAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(medicos);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
