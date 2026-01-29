package com.example.eShop.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartEntity.CartId.class)
@Table(name = "cart")
public class CartEntity {
    @Id
    private Integer userId;
    @Id
    private Integer productId;
    private Integer quantity;

    // Getters and setters
    @Data
    public static class CartId implements Serializable {
        private Integer userId;
        private Integer productId;

    }
}
