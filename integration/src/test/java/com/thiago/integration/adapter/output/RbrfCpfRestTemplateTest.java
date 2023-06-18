package com.thiago.integration.adapter.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiago.integration.domain.entity.Dados;
import com.thiago.integration.domain.entity.RbrfCpf;
import org.junit.jupiter.api.*;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Arrays;
import java.util.List;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RbrfCpfRestTemplateTest {

//    TestRestTemplate testRestTemplate = new TestRestTemplate();
//    @LocalServerPort
//    private int port = 8090;

    public static final String CPF = "59886488732";

    @Value("${rbrf-service.url}")
    private String baseUrl;
    private ObjectMapper mapper = new ObjectMapper();

    private RbrfCpf rbrfCpf;

    private ClientAndServer mockServer;

    @Autowired
    private RbrfCpfRestTemplate subject;

    @BeforeAll
    private void start(){
        mockServer = ClientAndServer.startClientAndServer(1080);
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().rootUri(baseUrl);
        subject = new RbrfCpfRestTemplate(restTemplateBuilder.build());
    }

    @BeforeEach
    void setUp() {
        startRbrfCpf();
        mockServer.reset();
    }

    @AfterAll
    public void stop(){
        mockServer.stop();
    }

    @Test
    void fetchSingleRbrfCpfSucesso() throws JsonProcessingException {

        List<RbrfCpf> responseList = Arrays.asList(rbrfCpf);

        mockServer
                .when(
                    request()
                        .withMethod("GET")
                        .withQueryStringParameter("CPF", CPF))
                .respond(
                    response()
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withStatusCode(200)
                        .withBody(objectsToJson(responseList)));

        RbrfCpf result = subject.fetchSingleRbrfCpf(CPF);

        //Assertions.assertThat(result).isNotNull();
        Assertions.assertEquals(CPF, result.getCpf());

    }

    private String objectsToJson(List<RbrfCpf> list) throws JsonProcessingException {
        return mapper.writeValueAsString(list);
    }

    private void startRbrfCpf(){
        rbrfCpf = new RbrfCpf(1, CPF, 7, "Sint vero deleniti minus commodi occaecati sunt aut.", new Dados(0, "Expedita qui illum aliquam cumque hic et cupiditate.", "Wed Jan 10 00:42:26 BRT 3923", "Francisca Solimões Filho", "Sun Aug 19 22:22:41 BRT 1962", "fem", "Caio Almada Filho", "8163879575656232", "nao", "Tue Jun 05 15:54:52 BRT 3923", "Tue Jun 05 15:54:52 BRT 3923", "sim", "nao", "nao"));
    }
}