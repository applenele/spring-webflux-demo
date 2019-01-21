package com.smallcode.sample.reactor;

import java.util.concurrent.atomic.AtomicLong;
import reactor.core.publisher.Flux;

/**
 * @author lenny
 * @Title: GenerateSample
 * @ProjectName spring-webflux-demo
 * @date 2019-01-21 14:27
 **/
public class GenerateSample {

  public static void main(String[] args) {
//    test01();
    test02();
  }

  public static void test01() {
    Flux<String> flux = Flux.generate(
        AtomicLong::new,
        (state, sink) -> {
          long i = state.getAndIncrement();
          sink.next("3 x " + i + " = " + 3 * i);
          if (i == 10) {
            sink.complete();
          }
          return state;
        });

    flux.subscribe(s -> System.out.println(s));
  }

  public static void test02() {
    Flux<String> flux = Flux.generate(
        AtomicLong::new,
        (state, sink) -> {
          long i = state.getAndIncrement();
          sink.next("3 x " + i + " = " + 3 * i);
          if (i == 10) {
            sink.complete();
          }
          return state;
        }, (state) -> {
          System.out.println("state:" + state);
        });

    flux.subscribe(s -> System.out.println(s));
  }
}
