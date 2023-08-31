package com.example.hexagonal.infrastructure.security;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.example.hexagonal.infrastructure.jpa.entities.UserJpaEntity;
import com.example.hexagonal.infrastructure.jpa.repositories.UserJpaRepository;
import com.example.hexagonal.infrastructure.security.userInfo.OAuth2Attributes;
import com.example.hexagonal.infrastructure.security.userInfo.OAuth2Provider;
import com.example.hexagonal.infrastructure.security.userInfo.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Service
@RequiredArgsConstructor
public class PrincipalUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final UserJpaRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);

		String registrationId = userRequest.getClientRegistration()
				.getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails()
				.getUserInfoEndpoint()
				.getUserNameAttributeName();

		OAuth2Attributes oAuthAttributes = OAuth2Attributes.of(registrationId, userNameAttributeName,
				oAuth2User.getAttributes());

		OAuth2UserInfo userInfo = oAuthAttributes.toUserInfo();

		OAuth2Provider provider = userInfo.getProvider();
		String providerId = userInfo.getSnsId();

		UserJpaEntity user = userRepository.findBySnsIdAndProvider(providerId, provider.getId());
		if (user == null) {
			user = UserJpaEntity.builder()
					.snsId(providerId)
					.provider(provider.getId())
					.app(userInfo.getApp())
					.email(userInfo.getEmail())
					.build();
			userRepository.save(user);
		}

		return new PrincipalUserInfo(user, userInfo);
	}

}
