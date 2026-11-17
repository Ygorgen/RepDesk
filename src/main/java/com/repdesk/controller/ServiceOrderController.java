package com.repdesk.controller;

import com.repdesk.model.ServiceOrder;
import com.repdesk.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service-orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService service;

    @PostMapping
    public ResponseEntity <ServiceOrder> create(@RequestBody ServiceOrder serviceOrder){

        ServiceOrder created = service.create(serviceOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
