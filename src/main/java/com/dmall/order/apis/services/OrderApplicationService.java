package com.dmall.order.apis.services;

import com.dmall.order.domain.factory.OrderCommandDTO;
import com.dmall.order.domain.model.Order;
import com.dmall.order.domain.model.OrderEvent;
import org.springframework.stereotype.Service;

@Service
public interface OrderApplicationService {
  //TODO: 思考题：application service 和domain service职责上怎么划分
  //       Order如果复杂化会怎么复杂？
  Order submitOrder(OrderCommandDTO orderCommandDTO);

  void postEvent(Long orderId, OrderEvent orderEvent);
}
