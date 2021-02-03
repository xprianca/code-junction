package com.tiwari.priyanka.codejunction.corejava;

import com.tiwari.priyanka.codejunction.Models.Order;
import com.tiwari.priyanka.codejunction.Service.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class ThreadPoolDemo {

  @Autowired OrdersService completableFutureOrdersService;

  @Test
  void threadPoolTest() {
    ExecutorService cpuBound = Executors.newFixedThreadPool(4);
    ExecutorService ioBound = Executors.newCachedThreadPool();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    List<Order> orderList = completableFutureOrdersService.getOrder();
    CompletableFuture<Order> orderCompletableFuture = new CompletableFuture<>();
    for (Order order : orderList) {
      orderCompletableFuture =
          CompletableFuture.supplyAsync(
                  () -> completableFutureOrdersService.enrichOrder(order), cpuBound)
              .thenApplyAsync(o -> completableFutureOrdersService.processPayment(o), ioBound)
              .thenComposeAsync(o -> completableFutureOrdersService.dispatchItem(o), ioBound)
              .exceptionally(
                  e -> {
                    System.out.println("exception occured");
                    return new Order(0,"item0",0,"failure");
                  })
              .thenApply(o -> completableFutureOrdersService.sendMail(o));
    }


    CompletableFuture<Order> finalOrderCompletableFuture = orderCompletableFuture;
    scheduler.schedule(() -> System.out.printf("Result is -> %s %n", finalOrderCompletableFuture),30, TimeUnit.SECONDS);

    try {
      Thread.sleep(50000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    System.out.println("Completable future task done !!!!");
//    System.out.printf("Result is %s %n", orderCompletableFuture);
    }
}
