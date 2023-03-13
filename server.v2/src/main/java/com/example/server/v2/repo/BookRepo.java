package com.example.server.v2.repo;

import com.example.server.v2.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findDistinctByPublishing_PublisherOrPublishing_City(String title, String city);
}
