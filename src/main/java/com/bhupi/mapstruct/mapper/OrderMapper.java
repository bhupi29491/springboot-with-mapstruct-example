package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.OrderDTO;
import com.bhupi.mapstruct.entity.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @BeforeMapping
    default void validate(OrderDTO orderDTO) {
        if (orderDTO.getQuantity() == 0) {
            orderDTO.setQuantity(1);
        }
    }

    @Mapping(source = "orderAmount", target = "amount")
    @Mapping(source = "orderDate", target = "date", dateFormat = "yyyy-MMM-dd")
    @Mapping(source = "orderStatus", target = "status", qualifiedByName = "checkOrderStatus")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "amount", target = "orderAmount")
    @Mapping(source = "date", target = "orderDate", dateFormat = "yyyy-MMM-dd")
    @Mapping(source = "status", target = "orderStatus", qualifiedByName = "checkOrderStatusInString")
    OrderDTO toDTO(Order order);

    @AfterMapping
    default void calculateSum(Order order, @MappingTarget OrderDTO orderDTO) {
        float sum = 0;
        if (order.getQuantity() != 0 && order.getAmount() != 0) {
            sum = sum + (order.getQuantity() * order.getAmount());
            orderDTO.setSum(sum);
        }
    }

    @Named("checkOrderStatus")
    default Boolean checkOrderStatus(String orderStatus) {
        boolean flag;
        flag = orderStatus.equals("Delivered");
        return flag;
    }

    @Named("checkOrderStatusInString")
    default String checkOrderStatusinString(boolean status) {
        String orderStatus;
        if (status) {
            orderStatus = "Delivered";
        } else {
            orderStatus = "Pending";
        }
        return orderStatus;
    }
}
