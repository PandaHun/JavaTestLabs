package com.jpa.jpashop.api;

import com.jpa.jpashop.domain.Order;
import com.jpa.jpashop.domain.OrderSearch;
import com.jpa.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
x To One(Many to One, One to One)
Order
Order -> Member
Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    /*
    problem1: 이 경우는 양방향 관계가 있다 한쪽의 연관을 끊어준다.
        Entity에 JsonIgnore를 걸어준다.
     */
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        return orderRepository.findAllByString(new OrderSearch());
    }
}
