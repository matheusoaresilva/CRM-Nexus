package com.matheus.crm.order.service;

import com.matheus.crm.order.dto.OrderDTO;
import com.matheus.crm.order.dto.StatusDTO;
import com.matheus.crm.order.entity.OrderEntity;
import com.matheus.crm.order.entity.enums.Status;
import com.matheus.crm.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAllOrders() {
        List<OrderEntity> list = repository.findAll();

        List<OrderDTO> listDto = list.stream()
                .map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
        return listDto;
    }

    public OrderDTO findOrderById(Long id){
        OrderEntity order = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(order, OrderDTO.class);
    }

    @Transactional
    public OrderDTO createOrder(OrderDTO dto){
        OrderEntity entity = modelMapper.map(dto, OrderEntity.class);

        entity.setRequestedDate(LocalDateTime.now());
        entity.setStatus(Status.REALIZED);

        entity.getItems().forEach(saleItem -> saleItem.setOrder(entity));

        OrderEntity save = repository.save(entity);

        return modelMapper.map(entity, OrderDTO.class);
    }

    public OrderDTO updateStatus(Long id, StatusDTO status){
        OrderEntity order = repository.findByIdFetchItens(id);

        if (order == null){
            throw new EntityNotFoundException();
        }

        order.setStatus(status.getStatus());
        repository.updateStatusByPedido(status.getStatus(), order);

        return  modelMapper.map(order, OrderDTO.class);
    }

    public void updatePayment(Long id){
        OrderEntity order = repository.findByIdFetchItens(id);

        if (order == null){
            throw new EntityNotFoundException();
        }

        order.setStatus(Status.PAID);
        repository.updateStatusByPedido(Status.PAID, order);
    }

}
