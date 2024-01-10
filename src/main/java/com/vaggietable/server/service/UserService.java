package com.vaggietable.server.service;

import com.vaggietable.server.domain.User;
import com.vaggietable.server.dto.NicknameDto;
import com.vaggietable.server.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    public void saveNickname(NicknameDto dto) {
        userMapper.saveNickname(dto);
    }


      public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
            return oauth2User.getAttribute("email");
        }
        return null;
    }

}
