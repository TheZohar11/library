package HW1;
// zohar simhon id- 211301460
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A class for managing a library. The underlying data structure for this class
 * minimizes memory use.
 * @author Tal
 */
public class Library {
    public static int idx=0;
    private DataStructure<Book> books;
    private DataStructure<Book> borrowedBooks;
    /**
     * Creates a brand-new library with no books.
     */
    public Library() {
        this.books = new DataStructure<>();
        this.borrowedBooks = new DataStructure<>();
    }

    /**
     * Adds a new book to the library with a copy quantity of one.
     *
     * @param name     the name of the book
     * @param author   the author of the book
     */
    public void addBook(String name, String author) {

        Book newBook = new Book(name, author);
        books.addToEnd(newBook);
    }

    /**
     * Removes a book from the library based on its unique ID.
     *
     * @param uniqueID the unique ID of the book to be removed
     */
    public void removeBooks(int uniqueID) {
        for (int i = 0; i < books.size(); i++){
            Library.Book book = books.get(i);
            if(book.uniqueID == uniqueID){
                books.delete(book);
                return;
            }
        }
    }

    /**
     * Borrows the book with the specified unique ID.
     *
     * @param uniqueID the unique ID of the book to be borrowed
     * @return An unmodifiable list of books.
     */
    public Book borrowBook(int uniqueID) {
        for (int i = 0; i < books.size(); i++){
            Library.Book book = books.get(i);
            if(book.uniqueID == uniqueID){
                borrowedBooks.addToEnd(book);
                return book;
            }
        }
        return null;

    }

    /**
     * borrow all books with the specified author name from the library.
     *
     * @param author_name The name of the author we would like to borrow all his books
     * @return An unmodifiable list of books
     */
    public DataStructure<Book> borrowAllBooks(String author_name) {
        DataStructure<Book> authorBooks = new DataStructure<>();
        for (int i = 0; i < books.size(); i++) {
            Library.Book book = books.get(i);
            if (book != null && book.author.equals(author_name)) {
                borrowedBooks.addToEnd(book);
                authorBooks.addToEnd(book);
            }
        }
        return authorBooks;
    }

    /**
     * Sorting the books in the library according to the unique ID
     * This method has linear complexity.
     * @return A sorted unmodifiable list of all the books in the library.
     */
    public void sortedByUniqueID() {
        mergeSort(books, 0, books.size() - 1);
    }
    private void mergeSort(DataStructure<Book> books, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(books, left, mid);
            mergeSort(books, mid + 1, right);

            merge(books, left, mid, right);
        }
    }
    private void merge(DataStructure<Book> books, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        DataStructure<Book> leftArr = new DataStructure<>();
        DataStructure<Book> rightArr = new DataStructure<>();

        for (int i = 0; i < n1; ++i) {
            leftArr.addToEnd(books.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightArr.addToEnd(books.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr.get(i).uniqueID <= rightArr.get(j).uniqueID) {
                books.set(k, leftArr.get(i));
                i++;
            } else {
                books.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            books.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            books.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }
    
    /**
     * Returns the total number of books in the library.
     *
     * @return the total number of books in the library
     */
    public int totalBooksInLibrary() {
        return books.size();
    }

    /**
     * Returns the total number of books available for loan in the library
     * @return the total number of books available in the library
     */
    public int totalAvailableBooks() {
        return books.size()-borrowedBooks.size();
    }

    /**
     * Returns the total number of books currently on loan in the library
     * @return the total number of books currently on loan in the library
     */
    public int totalLoanBooks() {
        return borrowedBooks.size();
    }

    /**
     * return the name of the author who wrote the most books in the library.
     */
    public String authorWithMostBooks() {
        int bookNumber = books.size()+borrowedBooks.size();
        int[] countingBooks = new int[bookNumber];
        String[] authorNames = new String[bookNumber];

        for (int i = 0; i < books.size(); i++){
            Library.Book book = books.get(i);
            for(int j = 0; j< authorNames.length; j++){
                if(authorNames[j] == null) {
                    authorNames[j] = book.author;
                    countingBooks[j]++;
                }
               else if(book.author.equals(authorNames[j]))
                    countingBooks[j]++;
            }
        }
        int max = 0;
        String author = null;
        for (int i = 0; i < countingBooks.length; i++){
            if(countingBooks[i]> max){
                max = countingBooks[i];
                author = authorNames[i];
            }
        }
        return author;
    }

    /**
     * The function receives an ID of a borrowed book and returns it to the library 
     * (makes it available again). 
     * @param uniqueID the unique ID of the book to be return
     * @return If the book was indeed borrowed and returned, the function will return true, otherwise it will return false
     */
    public boolean returnBook(int uniqueID) {
        for (int i = 0; i < borrowedBooks.size(); i++){
            Library.Book book = borrowedBooks.get(i);
            if(book != null && book.uniqueID == uniqueID){
                borrowedBooks.delete(book);
                return true;
            }
        }
        return false;
    }
    /**
     * The function receives an ID of a book and returns if its borrowed .
     * @param uniqueID the unique ID of the book 
     * @return If the book was borrowed the function will return true, otherwise it will return false
     */
    public boolean isBorrowed(int uniqueID) {
        for (int i = 0; i< borrowedBooks.size();i++){
            Library.Book book = borrowedBooks.get(i);
            if(book != null && book.uniqueID == uniqueID) return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String result = "Library books:\n";

        for (int i = 0; i < books.size(); i++) {
            result += books.get(i) + "\n";
        }

        result += "\nBorrowed books:\n";
        for (int i = 0; i < borrowedBooks.size(); i++) {
            result += borrowedBooks.get(i) + "\n";
        }

        return result;
    }



    /**
     * Book class representing a book with name, unique ID, author, and quantity.
     */
    public static class Book {
        private int uniqueID;
        private String name;
        private String author;

        /**
         * Constructor for a book
         * @param name The name of the book.
         * @param author The author of the book.
         */
        public Book(String name, String author) {
            Library.idx=Library.idx+1;
            this.uniqueID=Library.idx;
            this.author = author;
            this.name = name;
        }

        @Override
        public String toString() {

            return "Book{" +
                    "uniqueID=" + uniqueID +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }

    }
}
