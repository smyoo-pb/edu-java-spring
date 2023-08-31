package com.example.hexagonal.infrastructure.oauth2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.example.hexagonal.infrastructure.jpa.entities.AccessTokenJpaEntity;
import com.example.hexagonal.infrastructure.jpa.entities.RefreshTokenJpaEntity;
import com.example.hexagonal.infrastructure.jpa.entities.UserJpaEntity;
import com.example.hexagonal.infrastructure.jpa.repositories.AccessTokenJpaRepository;
import com.example.hexagonal.infrastructure.jpa.repositories.RefreshTokenJpaRepository;
import com.example.hexagonal.infrastructure.oauth2.jwt.IssueTokenResponse;
import com.example.hexagonal.infrastructure.oauth2.jwt.JwtProvider;

import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtProvider jwtProvider;
    private final AccessTokenJpaRepository accessTokenJpaRepository;
    private final RefreshTokenJpaRepository refreshTokenJpaRepository;

    public IssueTokenResponse issueToken(PrincipalUserInfo userInfo) {
        AccessTokenJpaEntity accessToken = createAccessToken(userInfo);
        RefreshTokenJpaEntity refreshToken = createRefreshToken(accessToken);

        return new IssueTokenResponse(
                userInfo.getUserEntity().getSnsId(),
                userInfo.getUserInfo().getProvider().getId(),
                accessToken.getToken(),
                jwtProvider.getAccessTokenExpiration(),
                refreshToken.getToken());
    }

    private AccessTokenJpaEntity createAccessToken(PrincipalUserInfo userInfo) {
        String token = jwtProvider.createAccessToken(userInfo.getUsername());
        UserJpaEntity entity = userInfo.getUserEntity();
        Date expiresAt = jwtProvider.extractExpiresAt(token).get();
        LocalDateTime exp = expiresAt.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        AccessTokenJpaEntity tokenEntity = new AccessTokenJpaEntity(
                null,
                entity,
                token,
                exp,
                null,
                null,
                null);

        return saveAccessToken(tokenEntity);
    }

    private RefreshTokenJpaEntity createRefreshToken(AccessTokenJpaEntity tokenEntity) {
        String refreshToken = jwtProvider.createRefreshToken();
        Date expiresAt = jwtProvider.extractExpiresAt(refreshToken).get();
        LocalDateTime exp = expiresAt.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        RefreshTokenJpaEntity refreshTokenEntity = new RefreshTokenJpaEntity(
                null,
                tokenEntity,
                refreshToken,
                exp,
                null,
                null,
                null);

        return saveRefreshToken(refreshTokenEntity);
    }

    private AccessTokenJpaEntity saveAccessToken(AccessTokenJpaEntity entity) {
        return accessTokenJpaRepository.save(entity);
    }

    private RefreshTokenJpaEntity saveRefreshToken(RefreshTokenJpaEntity enttiy) {
        return refreshTokenJpaRepository.save(enttiy);
    }
}
