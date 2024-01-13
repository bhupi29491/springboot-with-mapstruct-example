package com.bhupi.mapstruct.service;

import com.bhupi.mapstruct.dto.OrderDTO;
import com.bhupi.mapstruct.entity.Order;
import com.bhupi.mapstruct.mapper.OrderMapper;
import com.bhupi.mapstruct.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public Order saveOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO));
    }

    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElse(new OrderDTO());
    }

}
