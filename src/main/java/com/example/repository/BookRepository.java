package com.example.repository;

import com.example.model.user.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface BookRepository extends JpaRepository<Book,Long>{
    Book findBybookname(String bookname);
}
