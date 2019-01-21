package com.smallcode.sample.reactor;

import java.util.List;

/**
 * @author lenny
 * @Title: MyEventListener
 * @ProjectName spring-webflux-demo
 * @date 2019-01-21 14:39
 **/
public interface MyEventListener<T> {

  void onDataChunk(List<T> chunk);

  void processComplete();
}
