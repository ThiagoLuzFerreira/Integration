package com.thiago.integration.adapter.input;

import com.thiago.integration.adapter.dto.DadosDto;
import com.thiago.integration.adapter.dto.RbrfCpfDto;
import com.thiago.integration.domain.entity.Dados;
import com.thiago.integration.domain.entity.RbrfCpf;
import com.thiago.integration.port.input.IRbrfCpfUseCaseInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RbrfCpfControllerTest {

    public static final String CPF = "54005970549";
    private RbrfCpf rbrfCpf;
    private RbrfCpfDto dto;

    @InjectMocks
    private RbrfCpfController controller;

    @Mock
    private IRbrfCpfUseCaseInput rbrfCpfUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startRbrfCpf();
    }

    @Test
    void getRbrfCpf() {
        when(rbrfCpfUseCase.fetchSingleRbrfCpf(anyString())).thenReturn(rbrfCpf);
        ResponseEntity<RbrfCpfDto> response = controller.getRbrfCpf(CPF);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(RbrfCpfDto.class, response.getBody().getClass());
    }

    @Test
    void getRbrfCpfReturnsNotFound(){
        when(rbrfCpfUseCase.fetchSingleRbrfCpf(anyString())).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        try {
            controller.getRbrfCpf(CPF);
        } catch (Exception e){
            assertEquals(ResponseStatusException.class, e.getClass());
            assertEquals(HttpStatus.NOT_FOUND.toString(), e.getMessage());
        }
    }

    private void startRbrfCpf(){
        rbrfCpf = new RbrfCpf(1, CPF, 7, "Sint vero deleniti minus commodi occaecati sunt aut.", new Dados(0, "Expedita qui illum aliquam cumque hic et cupiditate.", "Wed Jan 10 00:42:26 BRT 3923", "Francisca Solimões Filho", "Sun Aug 19 22:22:41 BRT 1962", "fem", "Caio Almada Filho", "8163879575656232", "nao", "Tue Jun 05 15:54:52 BRT 3923", "Tue Jun 05 15:54:52 BRT 3923", "sim", "nao", "nao"));
        dto = new RbrfCpfDto(7, "Sint vero deleniti minus commodi occaecati sunt aut.", new DadosDto(0, "Expedita qui illum aliquam cumque hic et cupiditate.", "Wed Jan 10 00:42:26 BRT 3923", "Francisca Solimões Filho", "Sun Aug 19 22:22:41 BRT 1962", "fem", "Caio Almada Filho", "8163879575656232", "nao", "Tue Jun 05 15:54:52 BRT 3923", "Tue Jun 05 15:54:52 BRT 3923", "sim", "nao", "nao"));

    }
}