package com.jpa.jpashop.api;

import com.jpa.jpashop.domain.Address;
import com.jpa.jpashop.domain.Order;
import com.jpa.jpashop.domain.OrderSearch;
import com.jpa.jpashop.domain.OrderStatus;
import com.jpa.jpashop.repository.OrderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    /*
    Lazy Loading의 N+1 문제가 발생
    1개를 조회할 때 3개의 ㅇ테이블을 조회
    하면 할수 록 늘어남
    Eager로 바꾸면? 예상치 못한게 나온다..
     */
    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        return orders.stream()
                .map(SimpleOrderDto::new)
                .collect(Collectors.toList());
    }

    /*
        fetch join
        기술적으로는 Join, JPA의 Fetch를 활용
        Lazy를 무시하고 실제 값을 가져와서 넘겨줌
     */
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        return orders.stream()
                .map(SimpleOrderDto::new)
                .collect(Collectors.toList());
    }

    @Data
    static class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getMember().getAddress()
        }
    }
}
