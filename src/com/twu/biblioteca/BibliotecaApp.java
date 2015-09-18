package com.twu.biblioteca;

import java.time.Year;
import java.util.Scanner;

public class BibliotecaApp {

    private static final String WELCOME = "Welcome to Biblioteca!";

    static Library library;
    static Scanner keyboard = new Scanner(System.in);

    private static void setupLibrary() {
        library = new Library();

        library.add(new Book("Pride and Prejudice", "Jane Austen", Year.of(1813)));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", Year.of(1960)));
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Year.of(1925)));
        library.add(new Book("Frankenstein", "Mary Shelley", Year.of(1818)));

    }

    private static void printMenu() {
        System.out.println("Options Available: ");
        System.out.println("   L - List all books");
        System.out.println("   C - Checkout a book");
        System.out.println("   R - Return a book");
        System.out.println("   Q - Quit");
    }

    private static void printAvailableBooks() {
        System.out.println("Available Books:\n");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(library.getAvailableBooks().indexOf(book) + ": " + book);
        }

    }

    private static void printLoanedBooks() {
        System.out.println("Loaned Books:\n");
        for (Book book : library.getLoanedBooks()) {
            System.out.println(library.getLoanedBooks().indexOf(book) + ": " + book);
        }
    }

    private static void quit() {
        System.out.println("Quitting Biblioteca");
        System.exit(0);
    }

    private static void checkout() {
        System.out.println("Enter the number of the book you would like to check out: ");
        int bookIndex = keyboard.nextInt();
        try {
            library.getAvailableBooks().get(bookIndex).checkOut();
            System.out.println("Thank you! Enjoy the book");
        } catch (StockNotAvailableException e) {
            System.out.println("That book is not available.");
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
        while (! input.toUpperCase().equals("Q")) {
            printMenu();
            System.out.print("Enter Option: ");
            input = keyboard.next();

            if (input.toUpperCase().equals("L")) {
                printAvailableBooks();
            } else if (input.toUpperCase().equals("C")) {
                checkout();
            } else if (input.toUpperCase().equals("R")) {
                returnBook();
            } else {
                System.out.println("Invalid menu option.");
            }
        }
        quit();
    }
}
