package pl.gornik.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void borrowBook(Student student, String title) {
        Book book = findBookByTitle(title);
        if (book != null && book.getAvailability() > 0) {
            book.decreaseAvailability();
            student.borrowBook(book);
            System.out.println("Dziękujemy za wypożyczenie książki '" + title + "'");
        } else {
            System.out.println("Brak dostępnych egzemplarzy książki '" + title + "' lub taka książka nie istnieje.");
        }
    }

    public void returnBook(Student student, String title) {
        Book book = findBookByTitle(title);
        if (book != null && student.returnBook(book)) {
            book.increaseAvailability();
            System.out.println("Książka '" + title);
        } else {
            System.out.println("Nie możesz zwrócić książki '" + title + "' (może jej nie wypożyczyłeś/aś).");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\nDostępne książki w bibliotece:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBorrowedBooks(Student student) {
        System.out.println("\nWypożyczone książki przez " +
                student.getFirstName() + " " + student.getLastName() + ":");
        List<Book> borrowedBooks = student.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("Brak wypożyczonych książek.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}