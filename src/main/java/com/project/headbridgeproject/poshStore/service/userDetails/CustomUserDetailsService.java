//package com.project.headbridgeproject.poshStore.service.userDetails;
//
//
//import com.project.headbridgeproject.poshStore.entity.UserEntity;
//import com.project.headbridgeproject.poshStore.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findUserByEmail(username);
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add((new SimpleGrantedAuthority("ROLE_" + user.getRole())));
//        return new CustomUserDetails(
//                user.getId(),
//                username,
//                user.getPassword(),
//                authorityList);
//    }
//}
