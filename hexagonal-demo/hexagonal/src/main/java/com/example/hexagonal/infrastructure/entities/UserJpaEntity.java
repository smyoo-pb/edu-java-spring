package com.example.hexagonal.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_users")
public class UserJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
