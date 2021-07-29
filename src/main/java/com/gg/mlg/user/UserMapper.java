package com.gg.mlg.user;

import com.gg.mlg.user.model.UserEntity;
import com.gg.mlg.user.model.UserProfileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int inJoin(UserEntity param);
    UserEntity selUser(UserEntity param);
    int updUser(UserEntity param);
    int updUserMainProfile(UserProfileEntity param);
}
