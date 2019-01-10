package com.smallcode.sample.functionrouter.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lenny
 * @Title: Post
 * @ProjectName spring-webflux-demo
 * @date 2019-01-10 19:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

  private String id;
  private String name;
}
