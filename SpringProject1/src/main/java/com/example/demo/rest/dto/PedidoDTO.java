package com.example.demo.rest.dto;

import com.example.demo.domain.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * {
 *     "cliente" : 1
 *     "total" : 100,
 *     "items" : {
 *         {
 *             "produto" : 1,
 *             "quantidade" : 10
 *         }
 *     }
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;

}
