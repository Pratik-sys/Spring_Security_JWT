package com.example.SpringJWT.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/test")
    public ResponseEntity<String> testjwt(){
        return  ResponseEntity.ok().body("Hello bitches, i'm from planet mars");
    }

}
