package com.thiago.integration.adapter.output;

import com.thiago.integration.domain.entity.RbrfCpf;
import com.thiago.integration.port.output.IRbrfCpfUseCaseOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RbrfCpfRestTemplate implements IRbrfCpfUseCaseOutput {

    @Value("${rbrf-service.url}")
    private String baseUrl;

    private final String URL = "http://localhost:8081/api/rbrf";
    private final RestTemplate restTemplate;

    public RbrfCpfRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RbrfCpf> fetchRbrfCpf() {

        ResponseEntity<RbrfCpf[]> response = restTemplate.exchange(baseUrl + "/api/rbrf", HttpMethod.GET, null, RbrfCpf[].class);
        RbrfCpf[] rbrfCpfList = response.getBody();

        if(rbrfCpfList != null){
            return Arrays.asList(rbrfCpfList);
        }
        return null;
    }

    @Override
    public List<RbrfCpf> filterRbrfCpf(List<RbrfCpf> rbrfCpfList, String cpf) {
        return rbrfCpfList.stream().filter(rbrf -> rbrf.getCpf().equals(cpf)).collect(Collectors.toList());
    }

    @Override
    public RbrfCpf fetchSingleRbrfCpf(String cpf) {
        ResponseEntity<List<RbrfCpf>> response = restTemplate.exchange(URL, HttpMethod.GET, null,  new ParameterizedTypeReference<List<RbrfCpf>>() {});
        List<RbrfCpf> rbrfCpfList = response.getBody();

        if (rbrfCpfList != null && !rbrfCpfList.isEmpty()) {
            for (RbrfCpf rbrfCpf : rbrfCpfList) {
                if (rbrfCpf.getCpf().equals(cpf)) {
                    return rbrfCpf;
                }
            }
        }
        throw new RuntimeException("Falha ao buscar RBRF por CPF. CPF não encontrado: " + cpf);
    }
}
