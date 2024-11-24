package com.everyplaceinkorea.epik_boot3_api.anonymous.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDto {

  private Long id;
  private String title;
  private String content;
  private LocalDateTime writeDate;
  private String writer;
}
