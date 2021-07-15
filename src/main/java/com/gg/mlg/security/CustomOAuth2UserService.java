package com.gg.mlg.security;

import com.gg.mlg.security.model.*;
import com.gg.mlg.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired private UserDetailsServiceImpl myUserService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();

        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> modifyAttributes = modifyUserAttributes(registrationId, attributes);

        OAuth2UserInfo userInfo = getOauth2UserInfo(registrationId, modifyAttributes);
        UserEntity user = convertOauthToUserEntity(userInfo);
        UserEntity chkUser = myUserService.loadUserByUsernameAndProvider(user.getUid(), user.getProvider());
        //DB에 값 있나 체크 없으면 insert
        if(chkUser == null) {
            myUserService.join(user);
            chkUser = user;
        }
        CustomUserPrincipal loginUser = new CustomUserPrincipal(chkUser, attributes);
        return loginUser;
    }
    private UserEntity convertOauthToUserEntity(OAuth2UserInfo userInfo) {
        UserEntity user = UserEntity.builder()
                .uid(userInfo.getId()) //social 사이트의 pk값을 우리 user테이블에 email에 저장함.
                .provider(userInfo.getProvider())
                .build();
        return user;
    }

    private OAuth2UserInfo getOauth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(SocialType.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(SocialType.FACEBOOK.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(SocialType.KAKAO.toString())) {
            return new KakaoOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(SocialType.NAVER.toString())) {
            return new NaverOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }

    private Map<String, Object> modifyUserAttributes(String registrationId, Map<String, Object> attributes) {
        Map<String, Object> mod = new HashMap(attributes);
        switch(registrationId) {
            case "naver":
                LinkedHashMap responseData = (LinkedHashMap) mod.get("response");
                mod.putAll(responseData);
                mod.remove("response");
                break;
            case "kakao":
                LinkedHashMap propertiesData = (LinkedHashMap) mod.get("properties");
                mod.putAll(propertiesData);
                mod.remove("properties");
                break;
        }
        return mod;
    }
}