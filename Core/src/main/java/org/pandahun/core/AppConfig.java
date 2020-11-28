package org.pandahun.core;

import org.pandahun.core.discount.DiscountPolicy;
import org.pandahun.core.discount.FixDiscountPolicy;
import org.pandahun.core.discount.RateDiscountPolicy;
import org.pandahun.core.member.MemberRepository;
import org.pandahun.core.member.MemberService;
import org.pandahun.core.member.MemberServiceImpl;
import org.pandahun.core.member.MemoryMemberRepository;
import org.pandahun.core.order.OrderService;
import org.pandahun.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
