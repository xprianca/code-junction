package com.tiwari.priyanka.codejunction.Service;

import com.tiwari.priyanka.codejunction.Models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static java.util.List.*;

@Service
public class OrdersService {

  public List<Order> getOrder() {
    List<Order> orderList =
        new ArrayList<>(
            Arrays.asList(
                new Order(1, "item1", 1, "generated"),
                new Order(2, "item2", 2, "generated"),
                new Order(3, "item3", 1, "generated"),
                new Order(4, "item4", 3, "generated"),
                new Order(5, "item5", 5, "generated"),
                new Order(6, "item6", 5, "generated"),
                new Order(7, "item7", 1, "generated"),
                new Order(8, "item8", 2, "generated"),
                new Order(9, "item9", 3, "generated"),
                new Order(10, "item10", 1, "generated"),
                new Order(11, "item11", 2, "generated"),
                new Order(12, "item12", 4, "generated")));

    return orderList;
  }

  public Order enrichOrder(Order order) {
    int randomNum = new Random().nextInt();
    if (randomNum % 2 == 0) {
      try {
        System.out.println(
            "Sleeping in enrichOrder - item - "
                + order.getId()
                + " "
                + Thread.currentThread().getName());
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    order.setItemName(order.getItemName() + " - enriched");
    System.out.printf(
        "Enriched order %s via Thread %s %n", order.getId(), Thread.currentThread().getName());
    return order;
  }

  public Order processPayment(Order order) {
    try {
      int randomNum = new Random().nextInt();
      if (randomNum % 2 == 0) {
        System.out.println(
            "Sleeping in processPayment- item - "
                + order.getId()
                + " "
                + Thread.currentThread().getName());
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus("Payment Processed");
    System.out.printf(
        "Payment processed for id - %s via Thread %s %n",
        order.getId(), Thread.currentThread().getName());
    return order;
  }

  public CompletableFuture<Order> dispatchItem(Order order) {
    try {
      int randomNum = new Random().nextInt();
      if (randomNum % 2 == 0) {
        System.out.println(
            "Sleeping in dispatchItem -  item - "
                + order.getId()
                + " "
                + Thread.currentThread().getName());
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    order.setStatus("Dispatched");
    System.out.printf(
        "Order %s dispatched via Thread %s %n", order.getId(), Thread.currentThread().getName());
    return CompletableFuture.completedFuture(order);
  }

  public Order sendMail(Order order) {
    order.setStatus("Done!!!");
    return order;
  }
}
