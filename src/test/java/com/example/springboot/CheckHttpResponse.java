package com.example.springboot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CheckHttpResponse {

    @LocalServerPort
    private int port;
    private String serverip;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldPassIfStringMatches() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello World from SpringBoot New");
    }

    @Test
    public void shouldPassIfStringMatchesGoodBy() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/GoodBy",
                String.class)).contains("GoodBy from SpringBoot");
    }
    /**
     * ClientDetails
     * */
    @Test
    public void shouldPassIfStringName() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/ClientDeatils?name=eyal",
                String.class)).contains("Hello eyal");
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/ClientDeatils?name=Noam",
                String.class)).contains("Hello Noam");
    }
}
