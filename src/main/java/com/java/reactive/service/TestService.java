package com.java.reactive.service;

import com.java.reactive.dto.ProductDto;
import com.java.reactive.models.AbilitiesResponse;
import com.java.reactive.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Service
public class TestService {

    private final WebClient webClient;

    public TestService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<AbilitiesResponse> someRestCall() {
        System.out.println("fika");
        return this.webClient.get().uri("https://pokeapi.co/api/v2/pokemon/ditto")
                .retrieve()
                .bodyToMono(AbilitiesResponse.class)
                .flatMap(t -> {
                   return Mono.just(t);
                });
    }


    public Mono<ProductDto> getUrl() {
//        return webClient
//                .get()
//                .uri("https://dummyjson.com/products/1")
//                .retrieve()
//                .bodyToMono(QueryJsonResponse.class)
//                .flatMap(transformer -> {
//                    return null;
//                });
        return null;
    }

    public Mono<User> getUser(String id) {
        return this.webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/users/" + id)
                .accept(APPLICATION_JSON)
                .exchangeToMono(request -> request.bodyToMono(User.class))
                .onErrorResume(err -> Mono.just(new User("Operation Failed", "500")));


    }

    public Flux<User> getUsers() {
        return this.webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/users")
                .accept(APPLICATION_JSON)
                .exchangeToFlux(request -> request.bodyToFlux(User.class))
                .onErrorResume(err -> Mono.just(new User("Operation Failed", "500")));

    }
}
