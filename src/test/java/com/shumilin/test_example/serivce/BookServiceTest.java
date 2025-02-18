package com.shumilin.test_example.serivce;

import com.shumilin.test_example.dto.BookDto;
import com.shumilin.test_example.entity.Book;
import com.shumilin.test_example.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
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
        BookService bookService = new BookService(mockBookRepository);
        BookDto bookDto = bookService.getBookByAuthor("sa");

        assertNotNull(bookDto);
        assertEquals("test_author", bookDto.author());
    }
}