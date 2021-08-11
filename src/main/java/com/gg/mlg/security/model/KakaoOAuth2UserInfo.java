package com.gg.mlg.security.model;

import com.gg.mlg.security.SocialType;
import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {
    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        int id = (int) attributes.get("id");
        return Integer.toString(id);
    }
    @Override
    public String getProvider() {
        return SocialType.KAKAO.getValue();
    }
}