package com.thiago.integration.domain.usecase;

import com.thiago.integration.domain.entity.RbrfCpf;
import com.thiago.integration.port.input.IRbrfCpfUseCaseInput;
import com.thiago.integration.port.output.IRbrfCpfUseCaseOutput;

import java.util.List;
import java.util.stream.Collectors;

public class RbrfCpfUseCaseImpl implements IRbrfCpfUseCaseInput {

    private final IRbrfCpfUseCaseOutput rbrfCpfUseCaseOutput;

    public RbrfCpfUseCaseImpl(IRbrfCpfUseCaseOutput rbrfCpfUseCaseOutput) {
        this.rbrfCpfUseCaseOutput = rbrfCpfUseCaseOutput;
    }


    @Override
    public List<RbrfCpf> fetchRbrfCpf() {

        List<RbrfCpf> rbrfCpfList = rbrfCpfUseCaseOutput.fetchRbrfCpf();

        return rbrfCpfList;
    }

    @Override
    public List<RbrfCpf> filterRbrfCpf(List<RbrfCpf> rbrfCpfList, String cpf) {
        return rbrfCpfList.stream().filter(rbrf -> rbrf.getCpf().equals(cpf)).collect(Collectors.toList());
    }

    @Override
    public RbrfCpf fetchSingleRbrfCpf(String cpf) {
        return rbrfCpfUseCaseOutput.fetchSingleRbrfCpf(cpf);
    }
}

