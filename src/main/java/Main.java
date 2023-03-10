import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        System.out.println("-----------------------------WELCOME TO THE LIBRARY-----------------------------");
        Scanner in = new Scanner(System.in);
        Library library = new Library();
        library.librarians.add(new Librarian("admin", "admin"));
        System.out.println("Choose the kind of account you want to log in as (1.User / 2.Librarian / 0. exit)");
        int account = Integer.parseInt(in.nextLine());
        while (account != 0) {
            System.out.println("Enter username : ");
            String username = in.nextLine();
            System.out.println("Enter password : ");
            String password = in.nextLine();

            // User
            if (account == 1) {
                if (library.doesUserExist(username)) {
                    if (library.checkUserPassword(username, password)) {
                        User user = library.searchUser(username);
                        System.out.println(user);
                        userMenu();
                        int command = Integer.parseInt(in.nextLine());
                        while (command != 0) {
                            if (command == 1) {
                                System.out.println("Enter the name of the book: ");
                                String name = in.nextLine();
                                library.searchBook(name);
                            }
                            if (command == 2) {
                                System.out.println("Enter the name of the book: ");
                                String name = in.nextLine();
                                user.rentBook(name, library);
                            }
                            if (command == 3) {
                                System.out.println("Enter the name of the book: ");
                                String name = in.nextLine();
                                user.returnBook(name, library);
                            }
                            if (command == 4) {
                                System.out.println("Enter your new password :");
                                String newPassword = in.nextLine();
                                library.updateUser(username, newPassword);
                            }
                            userMenu();
                            command = Integer.parseInt(in.nextLine());
                        }
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                } else {
                    System.out.println("User does not exist.");
                }
            }

            // Librarian
            else {
                if (library.doesLibrarianExist(username)) {
                    if (library.checkLibrarianPassword(username, password)) {
                        Librarian librarian = library.searchLibrarian(username);
                        System.out.println(librarian);
                        librarianMenu();
                        int command = Integer.parseInt(in.nextLine());
                        while (command != 0) {
                            if (command == 1) {
                                System.out.println("Enter the username :");
                                String userUsername = in.nextLine();
                                System.out.println(library.searchUser(userUsername));
                            }
                            if (command == 2) {
                                System.out.println("Enter a username :");
                                String userUsername = in.nextLine();
                                System.out.println("Enter a password :");
                                String userPassword = in.nextLine();
                                library.addUser(new User(userUsername, userPassword));
                            }
                            if (command == 3) {
                                System.out.println("Enter the username :");
                                String userUsername = in.nextLine();
                                library.removeUser(userUsername);
                            }
                            if (command == 4) {
                                System.out.println("Enter the username :");
                                String librarianUsername = in.nextLine();
                                System.out.println(library.searchLibrarian(librarianUsername));
                            }
                            if (command == 5) {
                                System.out.println("Enter a username :");
                                String librarianUsername = in.nextLine();
                                System.out.println("Enter a password :");
                                String librarianPassword = in.nextLine();
                                library.addLibrarian(new Librarian(librarianUsername, librarianPassword));
                            }
                            if (command == 6) {
                                System.out.println("Enter the username :");
                                String librarianUsername = in.nextLine();
                                library.removeLibrarian(librarianUsername);
                            }
                            if (command == 7) {
                                System.out.println("Enter your new password :");
                                String newPassword = in.nextLine();
                                library.updateLibrarian(username, newPassword);
                            }
                            if (command == 8) {
                                System.out.println("Enter the name of the book: ");
                                String name = in.nextLine();
                                library.searchBook(name);
                            }
                            if (command == 9) {
                                System.out.println("Enter the information about the book.");
                                System.out.println("Name : ");
                                String name = in.nextLine();
                                System.out.println("Author : ");
                                String author = in.nextLine();
                                System.out.println("Publish Year : ");
                                int year = Integer.parseInt(in.nextLine());
                                System.out.println("ISBN : ");
                                String ISBN = in.nextLine();
                                System.out.println("Number of copies : ");
                                int num = Integer.parseInt(in.nextLine());
                                Book newBook = new Book(name, author, year, ISBN);
                                library.addBook(newBook, num);
                            }
                            if (command == 10) {
                                System.out.println("Enter the name of the book: ");
                                library.removeBook(in.nextLine());
                            }
                            librarianMenu();
                            command = Integer.parseInt(in.nextLine());
                        }
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                } else {
                    System.out.println("User does not exist.");
                }
            }
            System.out.println("Choose the kind of account you want to log in as (1.User / 2.Librarian / 0. exit)");
            account = Integer.parseInt(in.nextLine());
        }
    }

    public static void userMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. search for a book");
        System.out.println("2. rent a book");
        System.out.println("3. return a book");
        System.out.println("4. change your password");
        System.out.println("0. exit");
    }

    public static void librarianMenu() {
        System.out.println("What do you want to do?");
        System.out.println("------------------Users------------------");
        System.out.println("1. search users");
        System.out.println("2. add user");
        System.out.println("3. remove user");
        System.out.println("---------------Librarians----------------");
        System.out.println("4. search librarians");
        System.out.println("5. add librarian");
        System.out.println("6. remove librarian");
        System.out.println("7. change your password");
        System.out.println("------------------Books------------------");
        System.out.println("8. search books");
        System.out.println("9. add book");
        System.out.println("10. remove book");
        System.out.println("-----------------------------------------");
        System.out.println("0. exit");
    }
}
