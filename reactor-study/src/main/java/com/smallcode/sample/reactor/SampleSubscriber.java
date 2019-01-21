package com.smallcode.sample.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author lenny
 * @Title: SampleSubscriber
 * @ProjectName spring-webflux-demo
 * @date 2019-01-21 11:06
 **/
public class SampleSubscriber<T> extends BaseSubscriber<T> {

  public void hookOnSubscribe(Subscription subscription) {
    System.out.println("Subscribed");
    request(1);
  }

  public void hookOnNext(T value) {
    System.out.println(value);
    request(1);
  }
}