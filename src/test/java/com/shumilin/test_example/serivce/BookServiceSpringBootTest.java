package com.shumilin.test_example.serivce;

import com.shumilin.test_example.dto.BookDto;
import com.shumilin.test_example.entity.Book;
import com.shumilin.test_example.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceSpringBootTest {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository mockBookRepository;

    @BeforeEach
    void setUp() {
        Book bookForRep = new Book();
        bookForRep.setAuthor("test_author");
        bookForRep.setTitle("test_title");
        when(mockBookRepository.findByAuthor(any())).thenReturn(Optional.of(bookForRep));
    }

    @Test
    @DisplayName("test to get a book by author")
    void getBookByAuthor() {
        BookDto actualBook = bookService.getBookByAuthor("sa");

        assertNotNull(actualBook);
        assertEquals("test_author", actualBook.author());
    }
}