package com.gg.mlg.security;

import com.gg.mlg.user.UserEntity;
import com.gg.mlg.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        UserEntity param = new UserEntity();
        param.setUid(uid);
        UserEntity loginUser = mapper.selUser(param);

        //아이디가 없는 상태
        if(loginUser == null) {
            return null;
        }
        //아이디는 있는 상태
        UserDetailsImpl details = new UserDetailsImpl(loginUser);
        details.setLname(loginUser.getLname());
        details.setPname(loginUser.getPname());
        return details;
    }
}
