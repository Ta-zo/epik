package com.everyplaceinkorea.epik_boot3_api.admin.contents.exhibition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitionTicketOfficeDto {
  private Long id;
  private String name;      // 티켓 판매처 플랫폼 이름
  private String link;      // 티켓 판매 링크
  private Long exhibitionId;   // 공연 정보 FK
}
