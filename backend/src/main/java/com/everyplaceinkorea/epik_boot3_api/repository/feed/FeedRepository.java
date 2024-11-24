package com.everyplaceinkorea.epik_boot3_api.repository.feed;

import com.everyplaceinkorea.epik_boot3_api.entity.feed.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
