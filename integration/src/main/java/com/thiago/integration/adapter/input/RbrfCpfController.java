package com.thiago.integration.adapter.input;

import com.thiago.integration.domain.entity.Dados;
import com.thiago.integration.domain.entity.RbrfCpf;
import com.thiago.integration.adapter.dto.DadosDto;
import com.thiago.integration.adapter.dto.RbrfCpfDto;
import com.thiago.integration.port.input.IRbrfCpfUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/rbrf")
public class RbrfCpfController {

    @Autowired
    private IRbrfCpfUseCaseInput rbrfCpfUseCase;

    @GetMapping
    public ResponseEntity<List<RbrfCpfDto>> getRbrfCPfList(@RequestParam(required = false) String cpf){

        List<RbrfCpf> rbrfCpfList = rbrfCpfUseCase.fetchRbrfCpf();

        if(cpf != null){
            rbrfCpfList = rbrfCpfUseCase.filterRbrfCpf(rbrfCpfList, cpf);
        }

        List<RbrfCpfDto> rbrfCpfDtoList = rbrfCpfList.stream().map(r -> converter(r)).collect(Collectors.toList());

        if (rbrfCpfList != null){
            return ResponseEntity.ok(rbrfCpfDtoList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/single")
    public ResponseEntity<RbrfCpfDto> getRbrfCpf(@RequestParam String cpf){

        RbrfCpf rbrfCpf = rbrfCpfUseCase.fetchSingleRbrfCpf(cpf);
        RbrfCpfDto rbrfCpfDto = converter(rbrfCpf);

        if (rbrfCpf != null){
            return ResponseEntity.ok(rbrfCpfDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public RbrfCpfDto converter(RbrfCpf rbrfCpf){
        RbrfCpfDto rbrfCpfDto = new RbrfCpfDto();
        rbrfCpfDto.setCodigo(rbrfCpf.getCodigo());
        rbrfCpfDto.setMensagem(rbrfCpf.getMensagem());
        rbrfCpfDto.setDados(converter(rbrfCpf.getDados()));
        return rbrfCpfDto;
    }

    private DadosDto converter(Dados dados) {
        DadosDto dadosDto = new DadosDto();
        dadosDto.setCodSituacaoReceita(dados.getCodSituacaoReceita());
        dadosDto.setDescSituacaoReceita(dados.getDescSituacaoReceita());
        dadosDto.setDataConsulta(dados.getDataConsulta());
        dadosDto.setNome(dados.getNome());
        dadosDto.setDtNascimento(dados.getDtNascimento());
        dadosDto.setSexo(dados.getSexo());
        dadosDto.setNomeMae(dados.getNomeMae());
        dadosDto.setTituloEleitor(dados.getTituloEleitor());
        dadosDto.setResideExterior(dados.getResideExterior());
        dadosDto.setAnoObito(dados.getAnoObito());
        dadosDto.setDtAtualizacao(dados.getDtAtualizacao());
        dadosDto.setIsClienteValido(dados.getIsClienteValido());
        dadosDto.setIsNomeValido(dados.getIsNomeValido());
        dadosDto.setIsDataNascimentoValida(dados.getIsDataNascimentoValida());
        return dadosDto;
    }
}
