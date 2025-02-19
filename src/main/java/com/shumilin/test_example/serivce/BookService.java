package com.shumilin.test_example.serivce;

import com.shumilin.test_example.dto.BookDto;
import com.shumilin.test_example.entity.Book;
import com.shumilin.test_example.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public final Function<Book, BookDto> toBookDto = (Book book)
            -> new BookDto(book.getTitle(), book.getAuthor());

    public BookDto getBookByAuthor(String author) {
        return toBookDto.apply(bookRepository.findByAuthor(author)
                .orElseThrow(EntityNotFoundException::new));
    }


    public BookDto getBookByTitle(String title) {
        return toBookDto.apply(bookRepository.findByTitle(title).orElseThrow(EntityNotFoundException::new));
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(toBookDto)
                .toList();
    }
}
