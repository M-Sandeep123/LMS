package com.incubyte.LMS.repository;


import com.incubyte.LMS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailableTrue();
}
