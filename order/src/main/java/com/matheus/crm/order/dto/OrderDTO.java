package com.matheus.crm.order.dto;

import com.matheus.crm.order.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public LocalDateTime requestedDate;
    public List<SaleItemDTO> items = new ArrayList<>();
    public Status status;

}
