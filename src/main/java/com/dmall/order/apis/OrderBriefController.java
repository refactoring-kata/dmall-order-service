package com.dmall.order.apis;

import com.dmall.order.apis.common.ApiForResponse;
import com.dmall.order.apis.common.HttpFacadeBaseClass;
import com.dmall.order.model.query.*;
import com.dmall.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderBriefs")
public class OrderBriefController extends HttpFacadeBaseClass {

    private OrderQueryService orderQueryService;


    @Autowired
    public OrderBriefController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/{id}")
    public final ApiForResponse<OrderBrief> findById(@PathVariable("id") final long id) {
        OrderBrief orderBrief = orderQueryService.findOrderBriefWithDetailById(id);

        ApiForResponse<OrderBrief> orderApiForResponse = new ApiForResponse<>(orderBrief.getId(), orderBrief);
        return orderApiForResponse;
    }



}

