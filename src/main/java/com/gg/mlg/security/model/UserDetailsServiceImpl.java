package com.gg.mlg.security.model;

import com.gg.mlg.user.UserMapper;
import com.gg.mlg.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new CustomUserPrincipal(loadUserByUsernameAndProvider(email, "local"));
    }

    public UserEntity loadUserByUsernameAndProvider(String id, String provider) throws UsernameNotFoundException {
        UserEntity param = new UserEntity();
        param.setProvider(provider);
        param.setUid(id);
        return  mapper.selUser(param);
    }

    public int join(UserEntity param) {
        if(param == null) {
            return 0;
        }
        param.setUpw("gfadfg");
        return mapper.inJoin(param);
    }
}
