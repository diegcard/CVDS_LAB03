package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    Library library = new Library();
    Book HarryPotter = new Book("Harry potter", "Jk Rowling", "001");


    @Test
    public void shouldCreateANewBook() {
        Boolean addBook = library.addBook(HarryPotter);
        assertTrue(addBook);
    }

    @Test
    public void ShoulsAddTheAmountOfBooksIfAlreadyExists() {

    }


    @Test
    public void shouldIncreaseBy1TheAmuntOfTheReturnedLibrary() {

    }
}



