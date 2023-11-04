package com.gs.spocktests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockTestsApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void whenRootThenWelcomeMessage() {
        webTestClient
                .get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Welcome to the BookService!");
    }

    @Test
    void whenGetBooksThenReturnList() {
        webTestClient
                .get()
                .uri("/books")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SpockTestsApplication.Book.class).hasSize(3);
    }

}
