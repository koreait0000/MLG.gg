package com.gg.mlg.mlg;


import com.gg.mlg.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
    UserEntity selLoginUser(UserEntity param);
}