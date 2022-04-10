package com.robin.userservice.controller;

import com.robin.userservice.model.Package;
import com.robin.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final WebClient webClient;

    @Value("${service.url}")
    private String url;

    @Autowired
    public UserController(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * create the user during sign up
     *
     * @param user
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/getUserInfo/{userId}")
    public ResponseEntity<Flux<Package>> getPackage(@PathVariable("userId") String userId) {
        Flux<Package> packageFlux = this.webClient.get().uri(url+"/"+userId).retrieve().bodyToFlux(Package.class);
        return ResponseEntity.ok().body(packageFlux);
    }



}
