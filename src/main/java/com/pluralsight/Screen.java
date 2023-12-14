package com.pluralsight;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Scanner;

public class Screen {

    public static void main(String[] args) {


        Scanner  scanner = new Scanner(System.in);
        Book[] books = new Book[20];
        books[0] = new Book(1, "ISBN001", "Book 1", false, "");
        books[1] = new Book(2, "ISBN002", "Book 2", false, "");
        books[2] = new Book(3, "ISBN003", "Book 3", false, "");
        books[3] = new Book(4, "ISBN004", "Book 4", false, "");
        books[4] = new Book(5, "ISBN005", "Book 5", true, "john");
        books[5] = new Book(6, "ISBN006", "Book 6", false, "");
        books[6] = new Book(7, "ISBN007", "Book 7", false, "");
        books[7] = new Book(8, "ISBN008", "Book 8", false, "");
        books[8] = new Book(9, "ISBN009", "Book 9", false, "");
        books[9] = new Book(10, "ISBN010", "Book 10", false, "");
        books[10] = new Book(11, "ISBN011", "Book 11", false, "");
        books[11] = new Book(12, "ISBN012", "Book 12", false, "");
        books[12] = new Book(13, "ISBN013", "Book 13", false, "");
        books[13] = new Book(14, "ISBN014", "Book 14", true, "jimmy");
        books[14] = new Book(15, "ISBN015", "Book 15", false, "");
        books[15] = new Book(16, "ISBN016", "Book 16", false, "");
        books[16] = new Book(17, "ISBN017", "Book 17", false, "");
        books[17] = new Book(18, "ISBN018", "Book 18", false, "");
        books[18] = new Book(19, "ISBN019", "Book 19", true, "bob");
        books[19] = new Book(20, "ISBN020", "Book 20", false, "");

        boolean displayOptions = true;

        while(displayOptions) {

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
                    break;
                case 'c':
                    System.out.println("C has been pressed - Check In a Book");
                    break;
                case 'd':
                    System.out.println("D has been pressed - Check Out a Book");
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


    public static void  displayAvailableBooks(Book[] books) {
        for(Book book : books){
            if(book.isCheckedOut == false){
                System.out.println(
                "Book{" +
                        "id=" + book.id +
                        ", isbn='" + book.isbn + '\'' +
                        ", title='" + book.title + '\'' +
                        '}');
            }
        }
    }
}
