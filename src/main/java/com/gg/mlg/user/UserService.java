package com.gg.mlg.user;

import com.gg.mlg.security.IAuthenticationFacade;
import com.gg.mlg.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAuthenticationFacade auth;

    public void inJoin(UserEntity param) {
        String hashedPw = passwordEncoder.encode(param.getUpw());
        param.setUpw(hashedPw);
        mapper.inJoin(param);
    }

    public UserEntity selUser(UserEntity param) {
        return mapper.selUser(param);
    }

    List<UserEntity> selfollow(UserEntity param) {
        return mapper.selfollow(param);
    }
    List<UserEntity> selfollowing(UserEntity param) {
        UserEntity search_user=mapper.selUser(param);
        return mapper.selfollowing(search_user);
    }

    public int indelfollow(UserEntity param) {
        if(mapper.searchfollow(param)==0){
            mapper.infollow(param);
            return 1;//ins
        }
        mapper.delfollow(param);
        return 0;//del
    }

    public int selWriteCnt(int user_no) {
        int writeCnt = mapper.selWriteCnt(user_no);
        System.out.println(user_no);
        System.out.println(writeCnt);
        return writeCnt;
    }


}
