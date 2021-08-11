package com.gg.mlg.security.model;

import com.gg.mlg.security.SocialType;
import java.util.Map;

public class FacebookOAuth2UserInfo extends OAuth2UserInfo {
    public FacebookOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return SocialType.FACEBOOK.getValue();
    }
}
