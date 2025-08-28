import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends LibraryItem {
    public static void main(String[] args) {
        // Create an ArrayList to store library items
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        // Create sample instances of Book, CD, and DVD and add them to the libraryItems ArrayList
        Book book1 = new Book("Hunger Games", 2003, "F. Scott Fitzgerald", "9780333791035");
        libraryItems.add(book1);
        CD cd1 = new CD("Man on the Moon", 2015, "Kid-Cudi", 18);
        libraryItems.add(cd1);
        DVD dvd1 = new DVD("Spider-Man", 2006, "David Fincher", 153);
        libraryItems.add(dvd1);

        // Display a welcome message and menu options to the user
        System.out.println("Welcome to our library database!");
        int choice;
        do {
            System.out.println("Select an option from our menu below:");
            System.out.println("1: Display Entire Library Catalog");
            System.out.println("2: Display Books only");
            System.out.println("3: Display CDs only");
            System.out.println("4: Display DVDs only");
            System.out.println("5: Search by Title");
            System.out.println("6: Add a new item");
            System.out.println("7: Export Library Catalog to CSV");
            System.out.println("8: Import new items from a CSV");
            System.out.println("9: EXIT");

            System.out.print("Enter your choice: ");
            choice = keyboard.nextInt();
            System.out.println("");
            
            if (choice == 1) {
                // Display all library items
                for (LibraryItem libraryItem : libraryItems) {
                    System.out.println(libraryItem);
                    System.out.println();
                }
            } else if (choice == 2) {
                // Display only books
                for (int i = 0; i < libraryItems.size(); i++) {
                    if (libraryItems.get(i).getClass().equals(Book.class)) {
                        System.out.println(libraryItems.get(i));
                        System.out.println();
                    }
                }
            } else if (choice == 3) {
                // Display only CDs
                for (int i = 0; i < libraryItems.size(); i++) {
                    if (libraryItems.get(i).getClass().equals(CD.class)) {
                        System.out.println(libraryItems.get(i));
                        System.out.println();
                    }
                }
            } else if (choice == 4) {
                // Display only DVDs
                for (int i = 0; i < libraryItems.size(); i++) {
                    if (libraryItems.get(i).getClass().equals(DVD.class)) {
                        System.out.println(libraryItems.get(i));
                        System.out.println();
                    }
                }
            } else if (choice == 5) {
                // Search for an item by title
                keyboard.nextLine(); // Consume the newline left-over
                System.out.print("Enter title to search for: ");
                String searchTitle = keyboard.nextLine().toLowerCase();

                for (int i = 0; i < libraryItems.size(); i++) {
                    LibraryItem item = libraryItems.get(i);

                    if (item.getTitle().toLowerCase().contains(searchTitle)) {
                        System.out.println(item);
                    }
                }

                System.out.println("No items found with the title: " + searchTitle);
            } else if (choice == 6) {
                // Add a new item to the library
                System.out.println("Select the type of item to add:");
                System.out.println("1. Book");
                System.out.println("2. CD");
                System.out.println("3. DVD");
                System.out.print("Enter your choice: ");
                int itemChoice = keyboard.nextInt();
                keyboard.nextLine();

                if (itemChoice == 1) {
                    // Add a new book
                    System.out.print("Enter the title of the book: ");
                    String bookTitle = keyboard.nextLine();
                    System.out.print("Enter the publication year: ");
                    int publicationYear = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Enter the author: ");
                    String author = keyboard.nextLine();
                    System.out.print("Enter the ISBN: ");
                    String isbn = keyboard.nextLine();

                    Book newBook = new Book(bookTitle, publicationYear, author, isbn);
                    libraryItems.add(newBook);
                    System.out.print("CD added successfully!");


                    System.out.print("Book added successfully!");
                } else if (itemChoice == 2) {
                    // Add a new CD
                    System.out.print("Enter the title of the CD: ");
                    String cdTitle = keyboard.nextLine();
                    System.out.print("Enter the release year: ");
                    int releaseYear = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Enter the artist: ");
                    String artist = keyboard.nextLine();
                    System.out.print("Enter the number of tracks: ");
                    int numTracks = keyboard.nextInt();

                    CD newCD = new CD(cdTitle, releaseYear, artist, numTracks);
                    libraryItems.add(newCD);
                    System.out.print("CD added successfully!");
                } else if (itemChoice == 3) {
                    // Add a new DVD
                    System.out.print("Enter the title of the DVD: ");
                    String dvdTitle = keyboard.nextLine();
                    System.out.print("Enter the release year: ");
                    int dvdReleaseYear = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Enter the director: ");
                    String director = keyboard.nextLine();
                    System.out.print("Enter the duration (in minutes): ");
                    int duration = keyboard.nextInt();

                    DVD newDVD = new DVD(dvdTitle, dvdReleaseYear, director, duration);
                    libraryItems.add(newDVD);
                    System.out.print("DVD added successfully!");
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            } else if (choice == 7) {
                // Export library catalog to CSV
                try (PrintWriter outputStream = new PrintWriter(new FileOutputStream("output.csv"))) {
                    for (int i = 0; i < libraryItems.size(); i++) {
                        outputStream.println(libraryItems.get(i).formatForCSV());
                    }
                    System.out.println("Library catalog exported to CSV successfully!");
                } catch (FileNotFoundException e) {
                    System.err.println("File could not be opened");
                }
            } else if (choice == 8) {
                // Import new items from a CSV
                Scanner inputStream = null;
                try {
                    inputStream = new Scanner(new FileInputStream("data.csv"));
                    inputStream.useDelimiter("(\n)|,");

                } catch (FileNotFoundException e) {
                    System.err.println("File could not be opened");
                    System.exit(0);
                }

                while (inputStream.hasNextLine()) {
                    String type = inputStream.next();

                    if (type.equalsIgnoreCase("Book")) {
                        String title = inputStream.next();
                        int year = inputStream.nextInt();
                        String author = inputStream.next();
                        String isbn = inputStream.next();

                        Book bookOne = new Book(title, year, author, isbn);
                        libraryItems.add(bookOne);
                        System.out.println(bookOne);
                    }
                    if (type.equalsIgnoreCase("CD")) {
                        String title = inputStream.next();
                        int year = inputStream.nextInt();
                        String artist = inputStream.next();
                        int numOfTracks = inputStream.nextInt();

                        CD cdOne = new CD(title, year, artist, numOfTracks);
                        libraryItems.add(cdOne);
                        System.out.println(cdOne);
                    }
                    if (type.equalsIgnoreCase("DVD")) {
                        String title = inputStream.next();
                        int year = inputStream.nextInt();
                        String director = inputStream.next();
                        int duration = inputStream.nextInt();

                        DVD dvdOne = new DVD(title, year, director, duration);
                        libraryItems.add(dvdOne);
                        System.out.println(dvdOne);
                    }
                }

            } else if (choice != 0) {
                // Invalid choice
                System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 9); // Loop until the user chooses to exit
        // Display end message
        System.out.println("Ending program....");
    }
}