package com.smallcode.sample.reactor;

import java.util.function.Consumer;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

/**
 * @author lenny
 * @Title: SubscribeSample
 * @ProjectName spring-webflux-demo
 * @date 2019-01-21 10:57
 **/
public class SubscribeSample {


  public static void main(String[] args) {
//      test01();;
//    test02();
//    test03();
    test04();
  }

  /**
   * 演示简单的定于
   */
  public static void test01() {
    Flux<Integer> ints = Flux.range(1, 3);
    ints.subscribe(i -> System.out.println(i));
  }

  /**
   * 故意引入一个错误
   */
  public static void test02() {
    Flux<Integer> ints = Flux.range(1, 4)
        .map(i -> {
          if (i <= 3) {
            return i;
          }
          throw new RuntimeException("Got to 4");
        });
    ints.subscribe(i -> System.out.println(i), new Consumer<Throwable>() {
      @Override
      public void accept(Throwable throwable) {
        System.out.println("发生了错误");
      }
    });
  }

  /**
   * 一个处理异常，一个处理完成的数据
   */
  public static void test03() {
    Flux<Integer> ints = Flux.range(1, 4);

    ints.subscribe(i -> System.out.println(i), new Consumer<Throwable>() {
      @Override
      public void accept(Throwable throwable) {
        System.out.println("发生了错误");
      }
    }, new Runnable() {
      @Override
      public void run() {
        System.out.println("完成操作");
      }
    });
  }

  public static void test04() {
    SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
    Flux<Integer> ints = Flux.range(1, 4);
    ints.subscribe(i -> System.out.println(i),
        error -> System.err.println("Error " + error),
        () -> {
          System.out.println("Done");
        },
        new Consumer<Subscription>() {
          @Override
          public void accept(Subscription subscription) {

          }
        });
    ints.subscribe(ss);
  }

}
