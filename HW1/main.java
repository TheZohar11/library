package HW1;

public class main {
    public static void main(String[] args) {
        Library library = new Library();

        library.removeBooks(2);
        System.out.println("");
        library.returnBook(4);

        // Adding some books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");
        library.addBook("The Bell Jar", "Sylvia Plath");
        library.addBook("Brave New World", "Aldous Huxley");
        library.addBook("Animal Farm", "George Orwell");
        library.addBook("The Lord of the Rings", "J.R.R. Tolkien");
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("The Shining", "Stephen King");
        library.addBook("Doctor Sleep", "Stephen King");
        library.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        library.addBook("Harry Potter and the Chamber of Secrets", "J.K. Rowling");
        library.addBook("Harry Potter and the Chamber of Secrets", "J.K. Rowling");
        System.out.println("\n" + "Added some books.");

        // Testing total available books
        System.out.println("\n" +"Total available books: " + library.totalAvailableBooks() + "\n");

        // Borrowing some books
        library.borrowBook(1); // Borrowing The Great Gatsby
        library.borrowBook(3); // Borrowing 1984
        System.out.println("Borrowed 2 books.");

        // Testing total available books
        System.out.println("\n" + "Total available books: " + library.totalAvailableBooks() + "\n");

        // Testing total books in library
        System.out.println("Total books in library: " + library.totalBooksInLibrary() + "\n");

        // Testing removing a book from library
        System.out.println(library + "\n"); // Printing the library books before removing "Brave new world"
        System.out.println("Remove book: 2"); library.removeBooks(2);
        System.out.println("\n" + library + "\n"); // Printing the library books after removing "Brave new world"

        System.out.println("Total books in library: " + library.totalBooksInLibrary() + "\n");

        // Testing total available books
        System.out.println("Total available books: " + library.totalAvailableBooks() + "\n");

        // Testing total loan books
        System.out.println("Total loan books: " + library.totalLoanBooks() + "\n");

        // Testing returning a book
        System.out.println("Returning book with unique ID 3: " + library.returnBook(3));
        System.out.println("Returning book with unique ID 1: " + library.returnBook(1));
        // Testing returning a none borrowed book
        System.out.println("Returning book with unique ID 2: " + library.returnBook(2));

        System.out.println("\n" + library + "\n");

        // Testing total available books
        System.out.println("Total available books: " + library.totalAvailableBooks() + "\n");

        // Testing total loan books
        System.out.println("Total loaned books: " + library.totalLoanBooks() + "\n");

        // Testing borrow all books by author
        System.out.println("Borrowing all books by J.K. Rowling: (Suppose to add 3 books to total loaned books)" + "\n");
        library.borrowAllBooks("J.K. Rowling");

        System.out.println("Total loaned books: " + library.totalLoanBooks() + "\n");

        // Testing author with most books
        System.out.println("Author with most books: " + library.authorWithMostBooks() + "\n");



        System.out.println(library + "\n");

        System.out.println("Sorting the library....010100101010010011101" + "\n");



        library.sortedByUniqueID();

        System.out.println(library + "\n");

    }
}
