# spring-webflux-demo
spring-webflux-demo

## 响应式编程
1. RxJava是java反应式编程的先驱。RxJava 2 在 RxJava 的基础上做了很多的更新。不过 RxJava 库也有其不足的地方。
Reactor 也是 Spring 5 中反应式编程的基础。
2. 在 Java 程序中使用 Reactor 库非常的简单，只需要通过 Maven 或 Gradle 来添加对 io.projectreactor:reactor-core 的依赖即可。

## Flux 和 Mono
Flux 和 Mono 是 Reactor 中的两个基本概念。Flux 表示的是包含 0 到 N 个元素的异步序列。
在该序列中可以包含三种不同类型的消息通知：正常的包含元素的消息、序列结束的消息和序列出错的消息。
当消息通知产生时，订阅者中对应的方法 onNext(), onComplete()和 onError()会被调用。
Mono 表示的是包含 0 或者 1 个元素的异步序列。该序列中同样可以包含与 Flux 相同的三种类型的消息通知。
Flux 和 Mono 之间可以进行转换。对一个 Flux 序列进行计数操作，得到的结果是一个 Mono<Long>对象。
把两个 Mono 序列合并在一起，得到的是一个 Flux 对象。

## 参考文档
[spring webflux（一）](https://www.jianshu.com/p/d648af830183)
[使用 Reactor 进行反应式编程](https://www.ibm.com/developerworks/cn/java/j-cn-with-reactor-response-encode/index.html)
[router](https://github.com/lankydan/spring-boot-webflux)
[Reactor 3 参考文档](https://htmlpreview.github.io/?https://github.com/get-set/reactor-core/blob/master-zh/src/docs/index.html#mono)