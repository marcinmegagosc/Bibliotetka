package pl.gornik;

import pl.gornik.model.Book;
import pl.gornik.model.Library;
import pl.gornik.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witamy w bilbiotece. Wprowadź swoje dane:");
        System.out.print("Imię: ");
        String firstName = capitalizeFirstLetter(scanner.nextLine());
        System.out.print("Nazwisko: ");
        String lastName = capitalizeFirstLetter(scanner.nextLine());
        System.out.print("Klasa (maksymalnie 5): ");
        String className;
        do {
            className = scanner.nextLine();
            if (!isValidClass(className)) {
                System.out.print("Nieprawidłowa klasa. Wprowadź poprawną klasę (maksymalnie 5): ");
            }
        } while (!isValidClass(className));

        Student student = new Student(firstName, lastName, className);

        System.out.println("\nWitaj, " + student.getFirstName() + " " + student.getLastName() + "!");
        System.out.println("Klasa: " + student.getClassName());

        Library library = new Library();

        library.addBook(new Book("Prosto do matury. Matematyka", "Piotr Grabowski", "Matematyka", 5));
        library.addBook(new Book("Historia Świata", "Jane Smith", "Historia", 3));
        library.addBook(new Book("Matematyka dla początkujących", "Adam Nowak", "Matematyka", 8));
        library.addBook(new Book("Sztuka gotowania", "Alicja Kowalska", "Kulinaria", 10));
        library.addBook(new Book("Podróże po Europie", "Robert Green", "Podróże", 4));
        library.addBook(new Book("Chemia organiczna", "Emily Brown", "Chemia", 6));
        library.addBook(new Book("Literatura klasyczna", "Daniel Johnson", "Literatura", 7));
        library.addBook(new Book("Sztuka filmowa", "Sophie White", "Film", 2));
        library.addBook(new Book("Psychologia społeczna", "David Jones", "Psychologia", 9));
        library.addBook(new Book("Programowanie w C++", "Laura Davis", "Programowanie", 3));
        library.addBook(new Book("Anatomia człowieka", "Michael Miller", "Anatomia", 5));
        library.addBook(new Book("Historia sztuki", "Emma Taylor", "Sztuka", 6));
        library.addBook(new Book("Fizyka kwantowa", "Kevin Johnson", "Fizyka", 4));
        library.addBook(new Book("Język francuski dla początkujących", "Sophie Martin", "Języki obce", 8));
        library.addBook(new Book("Geografia świata", "Andrew White", "Geografia", 7));
        library.addBook(new Book("Ekonomia globalna", "Olivia Davis", "Ekonomia", 3));
        library.addBook(new Book("Etyka zawodowa", "Emma Green", "Etyka", 6));
        library.addBook(new Book("Programowanie w Python", "Daniel Adams", "Programowanie", 4));
        library.addBook(new Book("Malarstwo nowoczesne", "Sophie Johnson", "Sztuka", 5));
        library.addBook(new Book("Podstawy rachunku różniczkowego", "Michael Green", "Matematyka", 7));

        library.addStudent(student);

        int choice;
        do {
            System.out.println("\nMenu biblioteki:");
            System.out.println("1. Wyświetl dostępne książki");
            System.out.println("2. Wypożycz książkę");
            System.out.println("3. Zwróć książkę");
            System.out.println("4. Wyświetl wypożyczone książki");
            System.out.println("0. Wyjście");

            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    borrowBook(library, scanner, student);
                    break;
                case 3:
                    returnBook(library, scanner, student);
                    break;
                case 4:
                    displayBorrowedBooks(library, student);
                    break;
                case 0:
                    System.out.println("Dziękujemy! Do widzenia.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

        } while (choice != 0);
    }

    private static void borrowBook(Library library, Scanner scanner, Student student) {
        do {
            System.out.print("Podaj tytuł książki, którą chcesz wypożyczyć (lub wpisz '0' aby wrócić do menu głównego): ");
            scanner.nextLine();
            String titleToBorrow = scanner.nextLine();

            if (titleToBorrow.equals("0")) {
                break;
            }

            library.borrowBook(student, titleToBorrow);

            System.out.print("Czy chcesz wypożyczyć kolejną książkę? (Tak/Nie): ");
        } while (scanner.next().equalsIgnoreCase("Tak"));
    }

    private static void returnBook(Library library, Scanner scanner, Student student) {
        System.out.print("Podaj tytuł książki, którą chcesz zwrócić: ");
        scanner.nextLine();
        String titleToReturn = scanner.nextLine();
        library.returnBook(student, titleToReturn);
    }

    private static void displayBorrowedBooks(Library library, Student student) {
        System.out.println("\nTwoje wypożyczone książki:");
        library.displayBorrowedBooks(student);
    }
    private static boolean isValidClass(String className) {
        return className.matches("[1-5][a-zA-Z]?");
    }
    private static String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}