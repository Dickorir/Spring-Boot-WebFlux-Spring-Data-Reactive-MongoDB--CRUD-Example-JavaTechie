package com.java.reactive.service;

import com.java.reactive.dto.ProductDto;
import com.java.reactive.models.AbilitiesResponse;
import com.java.reactive.models.PokeMonData;
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

    public Mono<PokeMonData> someRestCall() {
        System.out.println("ndani");
        // not working to be ckecked once more
        return this.webClient
                .get()
                .uri("http://pokeapi.co/api/v2/pokemon/ditto")
                .accept(APPLICATION_JSON)
                .exchangeToMono(request -> request.bodyToMono(PokeMonData.class))
                .onErrorResume(err -> Mono.just(new PokeMonData("Operation Failed", "500")));
//                .retrieve()
//                .bodyToMono(PokeMonData.class)
//                .flatMap(t -> {
//                   return Mono.just(t);
//                });
    }


    public Mono<User> getUser(String id) {
        return this.webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/users/" + id)
                .retrieve()
                .bodyToMono(User.class)
                .flatMap(Mono::just)
                .onErrorResume(err -> Mono.just(new User("Operation Failed", "500")));


    }

//    public Mono<User> getUser(String id) {
//        return this.webClient
//                .get()
//                .uri("http://jsonplaceholder.typicode.com/users/" + id)
//                .accept(APPLICATION_JSON)
//                .exchangeToMono(request -> request.bodyToMono(User.class))
//                .onErrorResume(err -> Mono.just(new User("Operation Failed", "500")));
//
//
//    }

    public Flux<User> getUsers() {
        return this.webClient
                .get()
                .uri("http://jsonplaceholder.typicode.com/users")
                .accept(APPLICATION_JSON)
                .exchangeToFlux(request -> request.bodyToFlux(User.class))
                .onErrorResume(err -> Mono.just(new User("Operation Failed", "500")));

    }
}
