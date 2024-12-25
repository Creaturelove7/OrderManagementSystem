package com.creaturelove.orderhomeword;

import com.creaturelove.orderhomeword.model.OrderEntity;
import com.creaturelove.orderhomeword.model.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(BigDecimal price) {
        OrderEntity newOrder = new OrderEntity();
        newOrder.setTotalAmount(price);
        orderRepository.save(newOrder);
    }

    public OrderEntity getOrder(Long id) throws Exception {
        Optional<OrderEntity> order = orderRepository.findById(id);

        if(order.isPresent()){
            return order.get();
        }else{
            throw new Exception("Order not found");
        }
    }

    public OrderEntity updateOrder(Long id, BigDecimal price) throws Exception {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if(order.isPresent()){
            order.get().setTotalAmount(price);
        }else{
            throw new Exception("Order not found");
        }

        return orderRepository.save(order.get());
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
