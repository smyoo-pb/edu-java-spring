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
import jakarta.persistence.OneToOne;
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
@SQLDelete(sql = "UPDATE access_token SET deleted_at = NOW() WHERE id = ?")
@Table(name = "access_token")
public class RefreshTokenJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = AccessTokenJpaEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "access_token_id")
    private AccessTokenJpaEntity accessToken;

    private String token;

    private LocalDateTime expiresAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
