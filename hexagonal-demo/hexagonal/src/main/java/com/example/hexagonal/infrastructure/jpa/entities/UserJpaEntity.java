package com.example.hexagonal.infrastructure.jpa.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE user SET deleted_at = NOW() WHERE id = ?")
public class UserJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String app;
    private String snsId;
    private String email;
    private String provider;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    // Relationships
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Collection<AccessTokenJpaEntity> accessTokens;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Collection<ProfileJpaEntity> profiles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Collection<PetProfileJpaEntity> petProfiles;

}
