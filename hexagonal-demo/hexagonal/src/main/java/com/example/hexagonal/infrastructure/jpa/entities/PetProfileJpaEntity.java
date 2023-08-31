package com.example.hexagonal.infrastructure.jpa.entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE pet_profile SET deleted_at = NOW() WHERE id = ?")
@Table(name = "pet_profile")
public class PetProfileJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String species;

    private String breeds;

    private int birth;

    private String gender;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "user_id")
    private UserJpaEntity user;
}
