package com.twu.biblioteca;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class BibliotecaApp {

    private static final String WELCOME = "Welcome to Biblioteca!";

    static List<Book> bookList = new ArrayList<Book>();
    static Library library;

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
    }

    private static void printAllBooks() {
        System.out.println("All Books:\n");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

    }

    public static void main(String[] args) {

        setupBookList();

        // Display a welcome message
        System.out.println(WELCOME);

        String input;
        Scanner keyboard = new Scanner(System.in);

        // Display the menu repeatedly
        while (true) {
            printMenu();
            System.out.print("Enter Option: ");
            input = keyboard.next();

            if (input.toUpperCase().equals("L")) {printAllBooks();}
            
            else {System.out.println("Invalid menu option.");}
        }



    }
}
