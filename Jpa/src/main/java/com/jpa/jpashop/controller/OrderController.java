package com.jpa.jpashop.controller;

import com.jpa.jpashop.domain.Member;
import com.jpa.jpashop.domain.Order;
import com.jpa.jpashop.domain.OrderSearch;
import com.jpa.jpashop.domain.item.Item;
import com.jpa.jpashop.service.ItemService;
import com.jpa.jpashop.service.MemberService;
import com.jpa.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String Order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderLists(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("/orders/{id}/cancle")
    public String cancelOrder(@PathVariable("id") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
