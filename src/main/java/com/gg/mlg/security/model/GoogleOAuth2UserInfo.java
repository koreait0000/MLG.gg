package com.gg.mlg.security.model;

import com.gg.mlg.security.SocialType;
import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return SocialType.GOOGLE.getValue();
    }
}