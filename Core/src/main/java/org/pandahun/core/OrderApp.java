package org.pandahun.core;

import org.pandahun.core.member.Grade;
import org.pandahun.core.member.Member;
import org.pandahun.core.member.MemberService;
import org.pandahun.core.order.Order;
import org.pandahun.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "A", 10000);

        System.out.println("order =" + order );
    }
}
