package com.everyplaceinkorea.epik_boot3_api.anonymous.notice.service;

import com.everyplaceinkorea.epik_boot3_api.anonymous.notice.dto.NoticeResponseDto;

public interface NoticeService {

  // 전체 조회
  NoticeResponseDto getAllNotices();

  // 단건 조회

  NoticeResponseDto getNoticeById(Long id);



}
