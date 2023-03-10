import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    // list of books
    ArrayList<Book> books = new ArrayList<Book>();
    // map of books
    HashMap<String, Integer> stock = new HashMap <>();
    // list of users
    ArrayList<User> users = new ArrayList<User>();
    // list of librarians
    ArrayList<Librarian> librarians= new ArrayList<Librarian>();

    //book related functions

    public void addBook(Book book, int n) {
        books.add(book);
        // check if the book already exists.
        if (stock.get(book.getISBN()) == null){
            stock.put(book.getISBN(), n);
        }
        else {
            stock.put(book.getISBN(), stock.get(book.getISBN()) + n);
        }
        System.out.println(book.getName() + " is added to the library.");
    }

    public int getBookIndex(String name){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void removeBook(String name){
        // check if the book exists.
        int index = getBookIndex(name);
        if (index >= 0) {
            stock.remove(books.get(index).getISBN());
            books.remove(index);
            System.out.println(name + " is removed from the list of books.");
            return;
        }
        System.out.println("The book was not found.");
    }

    public void searchBook(String name){
        if (getBookIndex(name) >= 0){
            System.out.println(books.get(getBookIndex(name)));
        }
        else {
            System.out.println("The book was not found.");
        }
    }

    public boolean doesBookExist(String name){
        if (getBookIndex(name) >= 0){
            int number = stock.get(books.get(getBookIndex(name)).getISBN());
            if (number > 0){
                System.out.println("Number of " + name + " at the moment: " + number);
                return true;
            }
            else {
                System.out.println("Unfortunately all the copies are borrowed.");
                return false;
            }
        }
        else {
            System.out.println("The book was not found.");
            return false;
        }
    }

    public void increaseBook(String name){
        stock.put(books.get(getBookIndex(name)).getISBN(), stock.get(books.get(getBookIndex(name)).getISBN()) + 1);
    }

    public void decreaseBook(String name){
        stock.put(books.get(getBookIndex(name)).getISBN(), stock.get(books.get(getBookIndex(name)).getISBN()) - 1);
    }

    //user related functions

    public int getUserIndex(String username){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User is added.");
    }

    public void removeUser(String username){
        int index = getUserIndex(username);
        if (index >= 0) {
            users.remove(index);
            System.out.println("User is removed.");
        }
        else {
            System.out.println("User was not found.");
        }
    }

    public User searchUser(String username){
        int index = getUserIndex(username);
        if (index >= 0){
            return users.get(index);
        }
        else{
            System.out.println("User was not found.");
            return null;
        }
    }

    public void updateUser(String username, String newPassword){
        int index = getUserIndex(username);
        if (index >= 0){
            users.get(index).setPassword(newPassword);
        }
    }

    public boolean doesUserExist(String username){
        int index = getUserIndex(username);
        if (index >= 0){
            return true;
        }
        return false;
    }

    public boolean checkUserPassword(String username, String password){
        int index = getUserIndex(username);
        if (users.get(index).getPassword().equals(password)){
            return true;
        }
        return false;
    }

    //librarian related functions

    public int getLibrarianIndex(String username){
        for (int i = 0; i < librarians.size(); i++) {
            if (librarians.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    public void removeLibrarian(String username){
        int index = getLibrarianIndex(username);
        if(index >= 0) {
            librarians.remove(index);
            System.out.println(username + " is removed.");
        }
        else{
            System.out.println("Username was not found.");
        }
    }

    public Librarian searchLibrarian(String username){
        int index = getLibrarianIndex(username);
        if (index >= 0){
            return librarians.get(index);
        }
        else{
            System.out.println("Username was not found.");
            return null;
        }
    }

    public void updateLibrarian(String username, String newPassword){
        int index = getLibrarianIndex(username);
        if (index >= 0){
            librarians.get(index).setPassword(newPassword);
        }
    }

    public boolean doesLibrarianExist(String username){
        int index = getLibrarianIndex(username);
        if(index >= 0){
            return true;
        }
        return false;
    }

    public boolean checkLibrarianPassword(String username, String password){
        int index = getLibrarianIndex(username);
        if (librarians.get(index).getPassword().equals(password)){
            return true;
        }
        return false;
    }
}