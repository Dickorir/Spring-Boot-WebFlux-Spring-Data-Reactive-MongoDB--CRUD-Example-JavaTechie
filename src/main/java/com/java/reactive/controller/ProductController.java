package com.java.reactive.controller;

import com.java.reactive.dto.ProductDto;
import com.java.reactive.models.AbilitiesResponse;
import com.java.reactive.models.User;
import com.java.reactive.service.ProductService;
import com.java.reactive.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private TestService testService;

    @GetMapping
    public Flux<ProductDto> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id) {
        return service.getProduct(id);
    }

    @GetMapping("/get-url")
    public Mono<AbilitiesResponse> getUrl() {
        return testService.someRestCall();
    }

    @GetMapping("/get-user/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        return testService.getUser(id);
    }

    @GetMapping("/get-users")
    public Flux<User> getUsers() {
        return testService.getUsers();
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductBetweenRange(
            @RequestParam("max") double max,
            @RequestParam("min") double min) {
        return service.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono) {
        return service.saveProduct(productDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id) {
        return service.updateProduct(productDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return service.deleteProduct(id);
    }
}
