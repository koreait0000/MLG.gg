package com.gg.mlg.security;

import com.gg.mlg.user.UserEntity;

public interface IAuthenticationFacade {
    UserEntity getLoginUser();
    int getLoginUserPk();
}
