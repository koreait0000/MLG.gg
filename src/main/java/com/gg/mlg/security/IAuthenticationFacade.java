package com.gg.mlg.security;

import com.gg.mlg.user.model.UserEntity;

public interface IAuthenticationFacade {
    UserEntity getLoginUser();
    int getLoginUserPk();
}
