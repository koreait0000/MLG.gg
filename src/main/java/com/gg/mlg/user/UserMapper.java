package com.gg.mlg.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int inJoin(UserEntity param);
    UserEntity selUser(UserEntity param);
    UserEntity userLogin(UserEntity param);
}
