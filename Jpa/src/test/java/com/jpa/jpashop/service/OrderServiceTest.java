package com.jpa.jpashop.service;

import com.jpa.jpashop.domain.Address;
import com.jpa.jpashop.domain.Member;
import com.jpa.jpashop.domain.Order;
import com.jpa.jpashop.domain.OrderStatus;
import com.jpa.jpashop.domain.item.Book;
import com.jpa.jpashop.domain.item.Item;
import com.jpa.jpashop.exception.NotEnoughStockException;
import com.jpa.jpashop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = createMember();
        em.persist(member);

        Item book = createBook();
        em.persist(book);
        int orderCount = 2;
        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("주문한 상품 종류 수", 1, getOrder.getOrderItems().size());
        assertEquals("주문 가격은 가격 * 수량", 10000 * orderCount, getOrder.getTotalPrice());
        assertEquals("주문 한 만큼 재고가 줄어야 한다", 98, book.getStockQuantity());
    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문재고수량초과() throws Exception {
        //given
        Member member = createMember();
        em.persist(member);

        Item book = createBook();
        em.persist(book);
        int orderCount = 11;
        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        //then
        fail("not enough stock exception");
    }

    @Test
    public void 주문취소() throws Exception {
        //given

        //when

        //then
    }
    
    private Member createMember() {
        Member member = new Member();
        member.setName("kim");
        member.setAddress(new Address("서울", "강", "123"));
        return member;
    }

    private Item createBook() {
        Item book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        return book;
    }

}