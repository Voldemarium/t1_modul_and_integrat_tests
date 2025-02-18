package com.shumilin.test_example.serivce;

import com.shumilin.test_example.entity.Book;
import com.shumilin.test_example.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitService implements CommandLineRunner {

    private final BookRepository bookRepository;

    public InitService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) {
        saveTestBooks();
    }

    private void saveTestBooks() {
        Book book1 = new Book();
        book1.setAuthor("Pushkin");
        book1.setTitle("Skazka");

        Book book2 = new Book();
        book2.setAuthor("Tolstoy");
        book2.setTitle("Voina i mir");

        Book book3 = new Book();
        book3.setAuthor("Bulgakov");
        book3.setTitle("Master i margarita");

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
    }
}
