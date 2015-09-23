package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static final String WELCOME = "Welcome to Biblioteca!";

    static Library library;
    static Scanner keyboard = new Scanner(System.in);
    static User currentUser;

    private static void setupLibrary() {
        library = new Library();

        library.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1922));
        library.add(new Book("Frankenstein", "Mary Shelley", 1818));

        library.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 9));
        library.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10));
        library.add(new Movie("Sharktopus", 2006, "Declan O'Brien", 1));
        library.add(new Movie("Scooby Doo", 2002, "Raja Gosnell", 0));

    }

    private static void printMenu() {
        System.out.println("Options Available: ");
        System.out.println("   B  - List all books");
        System.out.println("   M  - List all movies");
        System.out.println("   CB - Checkout a book");
        System.out.println("   CM - Checkout a movie");
        System.out.println("   RB  - Return a book");
        System.out.println("   Q  - Quit");
    }

    private static void printAvailableBooks() {
        System.out.println("Available Books:\n");
        printList(library.getAvailableBooks());

    }

    private static void printLoanedBooks() {
        System.out.println("Loaned Books:\n");
        printList(library.getLoanedBooks());
    }

    private static void printAvailableMovies() {
        System.out.println("Available Movies: \n");
        printList(library.getAvailableMovies());
    }

    private static void quit() {
        System.out.println("Quitting Biblioteca");
        System.exit(0);
    }

    private static void printList(List<?extends LibraryStock> list) {
        for (LibraryStock stock : list) {
            System.out.println(list.indexOf(stock) + ": " + stock);
        }
    }

    private static void checkoutBook() {
        printAvailableBooks();
        System.out.println("Enter the number of the book you would like to check out: ");
        int bookIndex = keyboard.nextInt();
        try {
            library.getAvailableBooks().get(bookIndex).checkOut(currentUser);
            System.out.println("Thank you! Enjoy the book");
        } catch (StockNotAvailableException e) {
            System.out.println("That book is not available.");
        }
    }

    private static void checkoutMovie() {
        printAvailableMovies();
        System.out.println("Enter the number of the movie you would like to check out: ");
        int movieIndex = keyboard.nextInt();
        try {
            library.getAvailableMovies().get(movieIndex).checkOut(currentUser);
            System.out.println("Thank you! Enjoy the movie");
        } catch (StockNotAvailableException e) {
            System.out.println("That movie is not available");
        }
    }

    private static void returnBook() {
        printLoanedBooks();
        System.out.println("\nEnter the number of the book to be returned: ");
        int bookIndex = keyboard.nextInt();
        try {
            library.getLoanedBooks().get(bookIndex).returnStock();
            System.out.println("Thank you for returning the book.");
        } catch (StockNotOutException e) {
            System.out.println("That is not a valid book to return");
        }

    }

    public static void main(String[] args) {

        setupLibrary();

        // Display a welcome message
        System.out.println(WELCOME);

        String input = "";
        // Display the menu repeatedly
        while (! input.equals("Q")) {
            printMenu();
            System.out.print("Enter Option: ");
            input = keyboard.next().toUpperCase();

            if (input.toUpperCase().equals("B")) {
                printAvailableBooks();
            } else if (input.equals("CB")) {
                checkoutBook();
            } else if (input.equals("CM")) {
                checkoutMovie();
            } else if (input.equals("RB")) {
                returnBook();
            } else if (input.equals("M")) {
                printAvailableMovies();
            } else if (! input.equals("Q")) {
                System.out.println("Invalid menu option.");
            }
        }
        quit();
    }
}
