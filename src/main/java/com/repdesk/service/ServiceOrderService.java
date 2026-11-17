package com.repdesk.service;

import com.repdesk.Repository.ServiceOrderRepository;
import com.repdesk.enums.ServiceOrderStatus;
import com.repdesk.model.ServiceOrder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ServiceOrderService {

    @Autowired
    ServiceOrderRepository repository;

    @Transactional
    public ServiceOrder create(ServiceOrder serviceOrder) {
        serviceOrder.setProtocol(generateProtocol());
        serviceOrder.setStatus(ServiceOrderStatus.RECEIVED);
        serviceOrder.setReceivedAt(LocalDateTime.now());

        return repository.save(serviceOrder);
    }

    private String generateProtocol() {
        String date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("ddMMyyyy"));

        String protocol;

        do {
            String randomCode = UUID.randomUUID()
                    .toString()
                    .substring(0, 8)
                    .toUpperCase();
            protocol = "OS-" + date + "-" + randomCode;
        } while (repository.existsByProtocol(protocol));
        return protocol;
    }
}