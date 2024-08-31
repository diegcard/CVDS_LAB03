package edu.eci.cvds.tdd.library.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class represent a Book for testing
 */
public class BookTest {

    @Test
    public void ShoudBeEqualsForConstructMethodEquals(){
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "1234");
        Book book2 = new Book("Harry Potter", "J.K. Rowling", "1234");
        assertEquals(book1, book2);
    }

    @Test
    public void ShouldGetNameEquals(){
        Book book = new Book("Colombia", "Tomas", "231312");
        assertEquals(book.getTittle(), "Colombia");
    }

    @Test
    public void ShouldGetIsbnEquals(){
        Book book = new Book("Aypr", "Escuela Ing", "312321");
        assertEquals(book.getIsbn(), "312321");
    }

    @Test
    public void ShouldGetNameFalse(){
        Book book = new Book("Poob", "ECI", "4");
        assertNotEquals(book.getTittle(), "POOB");
    }
}
