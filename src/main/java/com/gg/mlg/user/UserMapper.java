package com.gg.mlg.user;

import com.gg.mlg.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int inJoin(UserEntity param);
    UserEntity selUser(UserEntity param);
    int updUser(UserEntity param);
    int selWriteCnt(int user_no);
    List<UserEntity> selfollow(UserEntity param);
    List<UserEntity> selfollowing(UserEntity param);
    int searchfollow(UserEntity param);
    int infollow(UserEntity param);
    int delfollow(UserEntity param);
}
