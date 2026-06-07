package org.example.ventory;

import jakarta.websocket.server.PathParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VentoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentoryApplication.class, args);
    }

    @GetMapping("/hello")
    public String seyHello(@RequestParam(value = "myName", defaultValue= "World") String name) {
        return String.format("Hello %s!", name);
    }

}
