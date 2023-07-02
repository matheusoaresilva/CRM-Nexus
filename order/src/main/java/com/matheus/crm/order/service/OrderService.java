package com.matheus.crm.order.service;

import com.matheus.crm.order.dto.OrderDTO;
import com.matheus.crm.order.entity.OrderEntity;
import com.matheus.crm.order.entity.enums.Status;
import com.matheus.crm.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrders() {
        List<OrderEntity> list = repository.findAll();

        List<OrderDTO> listDto = list.stream()
                .map(x -> new OrderDTO(x)).collect(Collectors.toList());
        return listDto;
    }

    @Transactional
    public OrderDTO createOrder(OrderDTO dto){
        OrderEntity entity = new OrderEntity();

        entity.setRequestedDate(LocalDateTime.now());
        entity.setStatus(Status.REALIZED);
        entity.getItems().forEach(saleItem -> saleItem.setOrder(entity));

        OrderEntity save = repository.save(entity);

        return new OrderDTO(entity);
    }

}
