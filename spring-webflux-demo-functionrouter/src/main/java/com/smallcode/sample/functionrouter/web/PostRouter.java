package com.smallcode.sample.functionrouter.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @author lenny
 * @Title: PostRouter
 * @ProjectName spring-webflux-demo
 * @Description: TODO
 * @date 2019-01-10 19:57
 **/
@Configuration
public class PostRouter {

  @Bean
  public RouterFunction<ServerResponse> route(PostHandler postHandler) {
    return RouterFunctions.route(GET("/post/list"), postHandler::list)
        .andRoute(POST("/post/create").and(accept(APPLICATION_JSON)),postHandler::echoName);
  }

}
