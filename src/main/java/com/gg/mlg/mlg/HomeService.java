package com.gg.mlg.mlg;


import com.gg.mlg.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private HomeMapper mapper;

    public UserEntity selLoginUser(String name) {
        UserEntity param=new UserEntity();
        param.setUid(name);
        param=mapper.selLoginUser(param);
        param.setUpw(null);
        return param;
    }
}