package com.twu.biblioteca;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BibliotecaApp {

    private static final String WELCOME = "Welcome to Biblioteca!";

    static List<Book> bookList = new ArrayList<Book>();
    static Library library;
    static Scanner keyboard = new Scanner(System.in);

    private static void setupBookList(){
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", Year.of(1813)));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", Year.of(1960)));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Year.of(1925)));
        bookList.add(new Book("Frankenstein", "Mary Shelley", Year.of(1818)));

        library = new Library(bookList);
    }

    private static void printMenu() {
        System.out.println("Options Available: ");
        System.out.println("   L - List all books");
        System.out.println("   C - Checkout a book");
        System.out.println("   Q - Quit");
    }

    private static void printAvailableBooks() {
        System.out.println("Available Books:\n");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(library.getAvailableBooks().indexOf(book) + ": " + book);
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
        } catch (BookNotAvailableException e){
            System.out.println("That book has already been checked out.");
        }
    }

    public static void main(String[] args) {

        setupBookList();

        // Display a welcome message
        System.out.println(WELCOME);

        String input;

        // Display the menu repeatedly
        while (true) {
            printMenu();
            System.out.print("Enter Option: ");
            input = keyboard.next();

            if (input.toUpperCase().equals("L")) {
                printAvailableBooks();}
            else if (input.toUpperCase().equals("C")) {checkout();}
            else if (input.toUpperCase().equals("Q")) {quit();}

            else {System.out.println("Invalid menu option.");}
        }



    }
}
