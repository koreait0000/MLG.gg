package com.gg.mlg.security;

import com.gg.mlg.user.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private  String lname;

    private  String pname;

    public String getLname() {
        return user.getLname();
    }
    public void setLname(String lname) {
        this.lname=lname;
    }
    public String getPname() {
        return user.getPname();
    }
    public void setPname(String pname) {
        this.pname=pname;
    }
    @Getter
    private UserEntity user;

    public UserDetailsImpl(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getUpw();
    }

    @Override
    public String getUsername() {
        return user.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
