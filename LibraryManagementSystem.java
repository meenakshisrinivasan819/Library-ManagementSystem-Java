import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    @Override
    public String toString() {
        return "\n--------------------------------" +
               "\nBook ID      : " + bookId +
               "\nTitle        : " + title +
               "\nAuthor       : " + author +
               "\nStatus       : " + (issued ? "Issued" : "Available") +
               "\n--------------------------------";
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Library Statistics");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    statistics();
                    break;
                case 8:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static boolean bookExists(int id) {
        for (Book b : books) {
            if (b.getBookId() == id)
                return true;
        }
        return false;
    }

    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        if (bookExists(id)) {
            System.out.println("Book ID Already Exists!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    static void searchBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println(b);
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void issueBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getBookId() == id) {

                if (b.isIssued()) {
                    System.out.println("Book Already Issued!");
                } else {
                    b.issueBook();
                    System.out.println("Book Issued Successfully!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void returnBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getBookId() == id) {

                if (!b.isIssued()) {
                    System.out.println("Book Already Available!");
                } else {
                    b.returnBook();
                    System.out.println("Book Returned Successfully!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void deleteBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.getBookId() == id) {
                books.remove(b);
                System.out.println("Book Deleted Successfully!");
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void statistics() {

        int issued = 0;
        int available = 0;

        for (Book b : books) {
            if (b.isIssued())
                issued++;
            else
                available++;
        }

        System.out.println("\n===== LIBRARY STATISTICS =====");
        System.out.println("Total Books     : " + books.size());
        System.out.println("Issued Books    : " + issued);
        System.out.println("Available Books : " + available);
    }
}