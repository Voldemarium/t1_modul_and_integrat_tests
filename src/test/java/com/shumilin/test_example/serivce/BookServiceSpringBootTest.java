package com.shumilin.test_example.serivce;

import com.shumilin.test_example.dto.BookDto;
import com.shumilin.test_example.entity.Book;
import com.shumilin.test_example.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookServiceSpringBootTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        Book bookForRep = new Book();
        bookForRep.setAuthor("test_author");
        bookForRep.setTitle("test_title");

        bookRepository.deleteAll();
        bookRepository.save(bookForRep);
    }

    @Test
    @DisplayName("test to get a book by author")
    void getBookByAuthor() {
        BookDto actualBook = bookService.getBookByAuthor("test_author");

        assertNotNull(actualBook);
        assertEquals("test_author", actualBook.author());
    }

    @Test
    @DisplayName("Тест ошибки при получения книги по ее автору")
    void testGetBookByAuthorError() {
        assertThrows(EntityNotFoundException.class, () -> {
            bookService.getBookByAuthor("Shumilin");
        });
    }
}