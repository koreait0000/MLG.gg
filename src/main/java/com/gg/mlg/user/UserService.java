package com.gg.mlg.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void inJoin(UserEntity param) {
        String hashedPw = passwordEncoder.encode(param.getUpw());
        param.setUpw(hashedPw);
        mapper.inJoin(param);
    }

    public void userLogin(UserEntity param) {mapper.selUser(param);}

}
