package com.example.Ordert_Services.controller;

import com.example.Ordert_Services.dto.ResponseDto;
import com.example.Ordert_Services.model.OrderInfo;
import com.example.Ordert_Services.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/addOrder")
    public OrderInfo addOrder(@RequestBody OrderInfo orderInfo){
        return service.addOrder(orderInfo);
    }

    @GetMapping("{id}")
    public Optional<OrderInfo> getOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    @GetMapping("/menu/{menuid}")
    public Mono<ResponseDto> getOrder(@PathVariable long menuid) {
        return service.getOrder(menuid);
    }
}
