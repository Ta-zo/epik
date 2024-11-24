package com.everyplaceinkorea.epik_boot3_api.repository;

import com.everyplaceinkorea.epik_boot3_api.entity.concert.Concert;
import com.everyplaceinkorea.epik_boot3_api.repository.concert.ConcertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ConcertRepositoryTest {

  @Autowired
  private ConcertRepository concertRepository;

  @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
  @Test
  void testServiceConcert() {
    // GIVEN
    String searchType = "ALL";
    String keyword = "";
    Pageable pageable = PageRequest.of(0, 15, Sort.by("id").descending());

    // WHEN
    Page<Concert> result = concertRepository.searchConcert(searchType, keyword, pageable);

    // THEN
    System.out.println("Total Result: " + result.getTotalElements());
    System.out.println("Concert: " + result.getContent());
    assertNotNull(result);
    assertTrue(result.getTotalElements() > 0, "결과가 있어야함");
  }
}
