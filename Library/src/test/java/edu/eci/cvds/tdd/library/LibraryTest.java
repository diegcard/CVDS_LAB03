package edu.eci.cvds.tdd.library;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;

import org.junit.jupiter.api.Test;

public class LibraryTest {

    Library library = new Library();
    Book HarryPotter = new Book("Harry potter", "Jk Rowling", "001");
    Book Shelly = new Book("Shelly", "Vector", "002");
    User Clarence = new User("Clarence", "001");
    User John = new User("John", "002");


    @Test
    public void shouldCreateANewBook() {
        Boolean addBook = library.addBook(HarryPotter);
        assertTrue(addBook);
    }

    @Test
    public void shouldCreateANewBookandItsAmountIsOne() {
        library.addBook(Shelly);
        int amountOfBooks = library.getBooks().get(Shelly);
        assertEquals(1, amountOfBooks);
    }

    @Test
    public void ShoulsAddTheAmountOfBooksIfAlreadyExists() {
        library.addBook(HarryPotter);
        library.addBook(HarryPotter);
        //Books in Library class are a map <Book, Integer> so the amount of books is the value of the map
        int amountOfBooks = library.getBooks().get(HarryPotter);
        assertEquals(2, amountOfBooks);
    }

    @Test
    public void shouldCreateANewLoan() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertNotNull(loan);
    }

    @Test
    public void shouldCreateANewLoanAndValidateThatTheBookIsAvailable() {
        library.addUser(Clarence);
        library.addUser(John);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        Loan loan2 = library.loanABook(John.getId(), HarryPotter.getIsbn());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertNull(loan2);
    }

    @Test
    public void shouldCreateANewLoanAndValidateThatTheBookExist() {
        library.addUser(Clarence);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertNull(loan);
    }

    @Test
    public void shouldCreateANewLoanAndValidateThatTheUserExist() {
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertNull(loan);
    }

    @Test
    public void shouldntAUserHaveALoanForTheSameBook() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        library.addBook(HarryPotter);
        library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertNull(loan);
    }

    @Test
    public void shouldCreateANewLoanAndStartWithActiveStatus() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    @Test
    public void shouldCreateALoanAndDecreaseTheAmountOfBooks() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        int amountOfBooks = library.getBooks().get(HarryPotter);
        assertEquals(0, amountOfBooks);
    }

    @Test
    public void ShouldCreateALoanAnditsDateIsTheCurrentDate() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertEquals(loan.getLoanDate(), LocalDate.now());
    }

    @Test
    public void ShouldCreateALoanAndOtherUserCantLoanTheSameBook() {
        library.addUser(Clarence);
        library.addUser(John);
        library.addBook(HarryPotter);
        library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        Loan loan2 = library.loanABook(John.getId(), HarryPotter.getIsbn());
        assertNull(loan2);
    }

    @Test
    public void shouldIncreaseBy1TheAmuntOfTheReturnedLibrary() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        int amountOfBooks = library.getBooks().get(HarryPotter);
        assertEquals(1, amountOfBooks);
        library.addBook(HarryPotter);
        int amountOfBooks1 = library.getBooks().get(HarryPotter);
        assertEquals(2, amountOfBooks1);
        Loan loan =library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        int amountOfBooks2 = library.getBooks().get(HarryPotter);
        assertEquals(1, amountOfBooks2);
        library.returnLoan(loan);
        int amountOfBooks3 = library.getBooks().get(HarryPotter);
        assertEquals(2, amountOfBooks3);
    }

    @Test
    public void shouldReturnALoanAndItsStatusIsReturned() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        library.returnLoan(loan);
        assertEquals(LoanStatus.RETURNED, loan.getStatus());
    }

    @Test
    public void shouldReturnALoanAndItsReturnDateIsTheCurrentDate() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        library.returnLoan(loan);
        assertEquals(loan.getReturnDate(), LocalDate.now());
    }

    @Test
    public void shouldReturnALoanAndValidateThatTheLoanExist() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        library.returnLoan(loan);
        assertNotNull(loan);
    }

    @Test
    public void shouldCreateALoanAndReturnTheLoanAndTheUserCanLoanTheSameBookAgain() {
        library.addUser(Clarence);
        library.addBook(HarryPotter);
        Loan loan = library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        library.returnLoan(loan);
        library.loanABook(Clarence.getId(), HarryPotter.getIsbn());
        assertNotNull(loan);
    }
}



