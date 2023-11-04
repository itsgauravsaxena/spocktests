package com.gs.spocktests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import java.util.List;

@SpringBootApplication
public class SpockTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpockTestsApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/", request -> ServerResponse.ok().bodyValue("Welcome to the BookService!"))
                .GET("/books", request -> ServerResponse.ok().bodyValue(List.of(
                        new Book("The Hobbit"),
                        new Book("The Lord of the Rings"),
                        new Book("His Dark Materials")
                )))
                .build();
    }

    record Book(String title){}

}
