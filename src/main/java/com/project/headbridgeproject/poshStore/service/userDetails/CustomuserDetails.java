package com.project.headbridgeproject.poshStore.service.userDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@RequiredArgsConstructor
public class CustomuserDetails implements UserDetails {

    private final String password;
    private final String login;
    private final Long id;
    private final Boolean enable;
    private final Boolean accountNotExpire;
    private final Boolean accountNotLocked;
    private final Boolean credentialsNotExpired;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomuserDetails(String password, String login, Long id, Boolean enable, Boolean accountNotExpire, Boolean accountNotLocked, Boolean credentialsNotExpired, Collection<? extends GrantedAuthority> authorities) {
        this.password = password;
        this.login = login;
        this.id = id;
        this.enable = enable;
        this.accountNotExpire = accountNotExpire;
        this.accountNotLocked = accountNotLocked;
        this.credentialsNotExpired = credentialsNotExpired;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNotExpire;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  this.accountNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNotExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
