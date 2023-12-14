package com.pluralsight;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Scanner;

public class Screen {

    public static void main(String[] args) {

        Book[] books = new Book[20];
        addBooks(books);

        displayMainScreenOptions(books);

    }


    public static void displayMainScreenOptions(Book[] books){
        Scanner scanner = new Scanner(System.in);
        boolean displayOptions = true;

        while (displayOptions) {

            System.out.println("A - Show Available Books");
            System.out.println("S - Show Checked Out Book");
            System.out.println("C - Check In a Book");
            System.out.println("D - Check Out a Book");
            System.out.println("X - Exit");
            System.out.print("Select Option: ");

            char choice = scanner.next().charAt(0);

            switch (Character.toLowerCase(choice)) {
                case 'a':
                    System.out.println("A has been pressed - Show Available Books");
                    displayAvailableBooks(books);
                    break;
                case 's':
                    System.out.println("S has been pressed - Show Checked Out Book");
                    displayCheckedOutBooks(books);
                    break;
                case 'c':
                    System.out.println("C has been pressed - Check In a Book");
                    findUserToCheckIn(books);
                    break;
                case 'd':
                    System.out.println("D has been pressed - Check Out a Book");
                    findCheckedOutBook(books);
                    break;
                case 'x':
                    System.out.println("X has been pressed - Exit");
                    displayOptions = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public static void displayAvailableBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        for (Book book : books) {
            if (book.isCheckedOut == false) {
                System.out.println(
                        "title = " + book.title  +
                                ", id = " + book.id +
                                ", isbn = " + book.isbn
                );
            }
        }
        System.out.print("Would you like to checkout a book? Y -- Yes or N -- No:  ");
        char choice = scanner.next().charAt(0);
        scanner.nextLine();
        if (Character.toLowerCase(choice) == 'y') {
            findCheckedOutBook(books);

        } else {
//            bring user back to the home screen options
        }
    }


    public static void displayCheckedOutBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        for (Book book : books) {
            if (book.isCheckedOut) {
                System.out.println(
                        " title =" + book.title +
                                "id = " + book.id +
                                ", isbn = " + book.isbn +
                                ", Checked Out To  = " + book.checkedOutTo
                );
            }
        }
        System.out.print("Would you like to checkIn a book? Y -- Yes or N -- No:  ");
        char choice = scanner.next().charAt(0);
        scanner.nextLine();
        if (Character.toLowerCase(choice) == 'y') {
            findUserToCheckIn(books);

        } else {
//            bring user back to the home screen options
        }

    }

    public static void findUserToCheckIn(Book[] books){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the ID of the book you would like to return: ");
        int idNumber = scanner.nextInt();
        for(Book book : books){
            if(book.id == idNumber){
                checkInBook(book);
            }
        }
    }

    public static void checkInBook(Book book){
        Scanner scanner = new Scanner(System.in);
        book.checkIn();
        System.out.print("Thank you for checking out a book, would you like to go back to the home screen? Y -- Yes or N -- No:");
        char choice = scanner.next().charAt(0);
        if (Character.toLowerCase(choice) == 'y') {
//            go back to home screen
        } else {
            System.out.println("Thank you for coming to Koichi's Library!");
            System.exit(0);
        }

    }

    public static void findCheckedOutBook(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select a book : ");
        String choiceBook = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equals(choiceBook)) {
                checkOutBook(book);
            }
        }
    }

    public static void checkOutBook(Book book) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name for book checkout : ");
        String name = scanner.nextLine();

        book.checkOut(name);
        System.out.print("Thank you for checking out a book, would you like to go back to the home screen? Y -- Yes or N -- No:");
        char choice = scanner.next().charAt(0);
        if (Character.toLowerCase(choice) == 'y') {
//            go back to home screen
        } else {
            System.out.println("Thank you for coming to Koichi's Library!");
            System.exit(0);
        }

    }


    public static void addBooks(Book[] books){
        books[0] = new Book(1, "ISBN001", "To Kill a Mockingbird", false, "");
        books[1] = new Book(2, "ISBN002", "1984", false, "");
        books[2] = new Book(3, "ISBN003", "The Catcher in the Rye", false, "");
        books[3] = new Book(4, "ISBN004", "The Great Gatsby", false, "");
        books[4] = new Book(5, "ISBN005", "Animal Farm", true, "John");
        books[5] = new Book(6, "ISBN006", "Lord of the Flies", false, "");
        books[6] = new Book(7, "ISBN007", "The Grapes of Wrath", false, "");
        books[7] = new Book(8, "ISBN008", "Brave New World", false, "");
        books[8] = new Book(9, "ISBN009", "One Hundred Years of Solitude", false, "");
        books[9] = new Book(10, "ISBN010", "Fahrenheit 451", false, "");
        books[10] = new Book(11, "ISBN011", "The Lord of the Rings", false, "");
        books[11] = new Book(12, "ISBN012", "The Hobbit", false, "");
        books[12] = new Book(13, "ISBN013", "The Kite Runner", false, "");
        books[13] = new Book(14, "ISBN014", "Pride and Prejudice", true, "Jimmy");
        books[14] = new Book(15, "ISBN015", "The Outsiders", false, "");
        books[15] = new Book(16, "ISBN016", "Slaughterhouse-Five", false, "");
        books[16] = new Book(17, "ISBN017", "Catch-22", false, "");
        books[17] = new Book(18, "ISBN018", "The Fountainhead", false, "");
        books[18] = new Book(19, "ISBN019", "The Hitchhiker's Guide to the Galaxy", true, "Bob");
        books[19] = new Book(20, "ISBN020", "The Shining", false, "");
    }


}