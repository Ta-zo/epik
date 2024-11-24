package com.everyplaceinkorea.epik_boot3_api.anonymous.notice.service;

import com.everyplaceinkorea.epik_boot3_api.admin.notice.repository.NoticeRepository;
import com.everyplaceinkorea.epik_boot3_api.anonymous.notice.dto.NoticeResponseDto;
import com.everyplaceinkorea.epik_boot3_api.entity.Notice;
import com.everyplaceinkorea.epik_boot3_api.repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultNoticeService implements NoticeService {

  private final NoticeRepository noticeRepository;
  private final MemberRepository memberRepository;
  private final ModelMapper modelMapper;

  @Override
  public NoticeResponseDto getAllNotices() {
    // 목록 내림차순으로 가져오기
//    List<Notice> notices = noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//
//    // NoticeResponseDto 리스트로 변환
//    List<NoticeResponseDto> responseDtos = notices.stream()
//            .map(notice -> {
//              NoticeResponseDto responseDto = modelMapper.map(notice, NoticeResponseDto.class);
//              responseDto.setWriter(notice.getMember().getNickname()); // 작성자 닉네임 설정
//              return responseDto;
//            })
//            .collect(Collectors.toList());
//
//    // 변환된 목록 반환
//    return responseDtos;
    return null;
  }

  @Override
  public NoticeResponseDto getNoticeById(Long id) {
    return null;
  }
}
