package com.creaturelove.orderhomeword;

import com.creaturelove.orderhomeword.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public void createOrder(BigDecimal price) {
        orderService.createOrder(price);
    }

    @GetMapping("/{id}")
    public OrderEntity getOrder(@PathVariable Long id) {
        try {
            return orderService.getOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping()
    public OrderEntity updateOrder(Long id, BigDecimal price) throws Exception {
        try {
            return orderService.updateOrder(id, price);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping()
    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}
