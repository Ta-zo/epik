package com.everyplaceinkorea.epik_boot3_api.anonymous.find.password.service;

import com.everyplaceinkorea.epik_boot3_api.anonymous.find.password.dto.PasswordFindRequestDto;
import com.everyplaceinkorea.epik_boot3_api.member.mypage.password.dto.PasswordChechRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface PasswordFindService {

    //비밀번호 찾기 - 아이디 확인
    String checkUsername(PasswordFindRequestDto passwordFindRequestDto);

    String passwordReset(PasswordFindRequestDto passwordFindRequestDto);
}
