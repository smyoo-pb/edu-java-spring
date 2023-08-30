package com.example.hexagonal.infrastructure.jpa.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Profile Entity for JPA
 *
 * @author miniyus
 * @date 2023/08/30
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE profile SET deleted_at = NOW() WHERE id = ?")
@Table(name = "profile")
public class ProfileJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String app;
    private String name;
    private String species;
    private String breeds;
    private String email;
    private LocalDate birth;
    private String gender;
    private String nickname;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
