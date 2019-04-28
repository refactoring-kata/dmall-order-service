package com.dmall.order.domain.factory;

import com.dmall.order.domain.model.Order;
import com.dmall.order.domain.model.OrderEvent;
import com.dmall.order.z.debug.spike.domain.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    public Order createNewOrderEntity(OrderCommandDTO orderCommandDTO){

        Order result = new Order();
        result.setContactId(orderCommandDTO.getCustomerContactId());

        result.setOrderItems(orderCommandDTO.getOrderItems());


        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setName(OrderEvent.Values.CREATED.name());
        result.addEvent(orderEvent);
        return result;
    }
}
