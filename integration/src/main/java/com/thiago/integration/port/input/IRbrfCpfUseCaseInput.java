package com.thiago.integration.port.input;

import com.thiago.integration.domain.entity.RbrfCpf;

import java.util.List;

public interface IRbrfCpfUseCaseInput {

    List<RbrfCpf> fetchRbrfCpf();

    List<RbrfCpf> filterRbrfCpf(List<RbrfCpf> rbrfCpfList, String cpf);

    RbrfCpf fetchSingleRbrfCpf(String cpf);
}
