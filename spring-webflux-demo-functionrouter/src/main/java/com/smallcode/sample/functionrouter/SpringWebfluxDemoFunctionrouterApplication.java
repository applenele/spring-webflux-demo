package com.smallcode.sample.functionrouter;

import com.smallcode.sample.functionrouter.bean.Post;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@SpringBootApplication
@RestController
public class SpringWebfluxDemoFunctionrouterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringWebfluxDemoFunctionrouterApplication.class, args);
  }


  /**
   * 客户端每条获取
   * @return
   */
  @GetMapping(value = "/sync",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<Post> sync() {
    List<Post> posts = new ArrayList<>();
    posts.add(Post.builder().id("1").name("sss").build());
    posts.add(Post.builder().id("2").name("sss2").build());
    posts.add(Post.builder().id("3").name("sss3").build());
    posts.add(Post.builder().id("4").name("sss4").build());
    //Flux<Post> postFlux = Flux.fromIterable(posts).delaySequence(Duration.ofSeconds(1));/
    return Flux.fromIterable(posts).delayElements(Duration.ofSeconds(1));
  }

}

