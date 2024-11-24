package com.everyplaceinkorea.epik_boot3_api.anonymous.feed.controller;
/*
* 방문자 피드 요청 api
* */

import com.everyplaceinkorea.epik_boot3_api.anonymous.feed.dto.FeedResponseDto;
import com.everyplaceinkorea.epik_boot3_api.member.feed.sesrvice.FeedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feed")
public class FeedController {

//    private final FeedService feedService;

    // 피드 전체 조회 = 메인 = 검색
//    @GetMapping()
//    public ResponseEntity<List<FeedResponseDto>> getList() {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body();
//    }



    // 피드 카테고리별 조회
//    @GetMapping("category/{categoryId}")
}
