package com.smallcode.sample.functionrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringWebfluxDemoFunctionrouterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringWebfluxDemoFunctionrouterApplication.class, args);
  }


  @GetMapping("anno")
  public String sayHello(String name) {
    return "hello world! " + name;
  }

}

