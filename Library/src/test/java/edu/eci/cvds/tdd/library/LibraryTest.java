package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    Library library = new Library();
    Book HarryPotter = new Book("Harry potter", "Jk Rowling", "001");
    Book Shelly = new Book("Shelly", "Vector", "002");


    @Test
    public void shouldCreateANewBook() {
        Boolean addBook = library.addBook(HarryPotter);
        assertTrue(addBook);
    }

    public void shouldCreateANewBookandItsAmountIsOne() {
        library.addBook(Shelly);
        int amountOfBooks = library.getBooks().get(Shelly);
        assertEquals(1, amountOfBooks);
    }

    @Test
    public void ShoulsAddTheAmountOfBooksIfAlreadyExists() {
        library.addBook(HarryPotter);
        //Books in Library class are a map <Book, Integer> so the amount of books is the value of the map
        int amountOfBooks = library.getBooks().get(HarryPotter);
        assertEquals(2, amountOfBooks);
    }

    

    @Test
    public void shouldIncreaseBy1TheAmuntOfTheReturnedLibrary() {

    }
}



