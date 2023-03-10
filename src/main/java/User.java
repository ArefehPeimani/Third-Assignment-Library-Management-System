import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<String> borrowedBooks = new ArrayList<>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public ArrayList<String> getBorrowedBooks() { return borrowedBooks; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public boolean isBookBorrowed(String name){
        for (int i = 0; i < borrowedBooks.size(); i++){
            if (borrowedBooks.get(i).equals(name)){
                return true;
            }
        }
        return false;
    }

    public void rentBook(String name, Library library){
        if (library.doesBookExist(name)){
            if (!isBookBorrowed(name)) {
                borrowedBooks.add(name);
                library.decreaseBook(name);
                System.out.println(name + " is borrowed.");
                System.out.println("Enjoy reading!");
            }
            else{
                System.out.println("you have already borrowed this book");
            }
        }

        else{
            System.out.println(name + " is not available in our library");
        }
    }

    public void returnBook(String name, Library library){
        if (isBookBorrowed(name)){
            borrowedBooks.remove(name);
            library.increaseBook(name);
            System.out.println(name + " is returned.");
        }
        else{
            System.out.println("You haven't borrowed this book.");
        }
    }
}
