package com.smallcode.sample.functionrouter.web;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.smallcode.sample.functionrouter.bean.Post;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lenny
 * @Title: PostHandler
 * @ProjectName spring-webflux-demo
 * @date 2019-01-10 19:57
 **/
@Component
public class PostHandler {

  public Mono<ServerResponse> echoName(ServerRequest request) {
    return request.bodyToMono(Post.class)
        .map(Post::getName)
        .flatMap(name -> ServerResponse.ok()
            .contentType(MediaType.TEXT_PLAIN)
            .body(BodyInserters.fromObject("hello world!" + name)));
  }

  public Mono<ServerResponse> list(ServerRequest request) {
    List<Post> posts = new ArrayList<>();
    posts.add(Post.builder().id("1").name("sss").build());
    posts.add(Post.builder().id("2").name("sss2").build());
    posts.add(Post.builder().id("3").name("sss3").build());
    posts.add(Post.builder().id("4").name("sss4").build());
    Flux<Post> postFlux = Flux.fromIterable(posts).delaySequence(Duration.ofSeconds(1));//.delayElements(Duration.ofSeconds(1));
    return ok().contentType(APPLICATION_JSON)
        .body(fromPublisher(postFlux, Post.class));
  }
}
