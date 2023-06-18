package com.thiago.integration.domain.usecase;

import com.thiago.integration.domain.entity.Dados;
import com.thiago.integration.domain.entity.RbrfCpf;
import com.thiago.integration.port.output.IRbrfCpfUseCaseOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class RbrfCpfUseCaseImplTest {

    public static final String CPF = "54005970549";

    @Mock
    private IRbrfCpfUseCaseOutput rbrfCpfUseCaseOutput;

    private RbrfCpf rbrfCpf;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startRbrfCpf();
    }

    @Test
    void fetchRbrfCpf() {
    }

    @Test
    void filterRbrfCpf() {
    }

    @Test
    void fetchSingleRbrfCpf() {
        when(rbrfCpfUseCaseOutput.fetchSingleRbrfCpf(anyString())).thenReturn(rbrfCpf);
        RbrfCpfUseCaseImpl subject = new RbrfCpfUseCaseImpl(rbrfCpfUseCaseOutput);
        RbrfCpf response = subject.fetchSingleRbrfCpf(CPF);

        assertNotNull(response);
        assertEquals(RbrfCpf.class, response.getClass());
        assertEquals(CPF, response.getCpf());
    }

    private void startRbrfCpf(){
        rbrfCpf = new RbrfCpf(
                1, CPF, 7, "Sint vero deleniti minus commodi occaecati sunt aut.", new Dados(0, "Expedita qui illum aliquam cumque hic et cupiditate.", "Wed Jan 10 00:42:26 BRT 3923", "Francisca Solimões Filho", "Sun Aug 19 22:22:41 BRT 1962", "fem", "Caio Almada Filho", "8163879575656232", "nao", "Tue Jun 05 15:54:52 BRT 3923", "Tue Jun 05 15:54:52 BRT 3923", "sim", "nao", "nao")
        );
    }
}