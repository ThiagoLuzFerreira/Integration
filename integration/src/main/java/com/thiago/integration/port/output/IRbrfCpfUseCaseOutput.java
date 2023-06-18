package com.thiago.integration.port.output;

import com.thiago.integration.domain.entity.RbrfCpf;

import java.util.List;

public interface IRbrfCpfUseCaseOutput {

    List<RbrfCpf> fetchRbrfCpf();

    List<RbrfCpf> filterRbrfCpf(List<RbrfCpf> rbrfCpfList, String cpf);

    RbrfCpf fetchSingleRbrfCpf(String cpf);
}
