package edu.eci.cvds.tdd.library.book;

/**
 * This Class Represents a Book in the Library
 */
public class Book {
    /**
     * The tittle of the book
     */
    private final String tittle;
    /**
     * The author of the book
     */
    private final String author;
    /**
     * The isbn of the book
     */
    private final String isbn;

    public Book(String tittle, String author, String isbn) {
        this.tittle = tittle;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * @return the tittle of the book
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the isbn of the book
     */
    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object obj) {
        return isbn.equals(((Book)obj).isbn);
    }
}