import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public String name;
    public static int openTime, closeTime, capacity;
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<NormalUser> normUserList = new ArrayList<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    public Library(String name, int capacity, int openTime, int closeTime) {
        this.name = name;
        this.capacity = capacity;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
    public static String bookRepo() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.availability) {
                availableBooks.add(book);
            }
        }
        return availableBooks.toString();
    }
    public static void addBook(Book book) {
        if ((!bookList.contains(book)) && (capacity > 0)) {
            bookList.add(book);
            capacity--;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book added before!");
        }
    }
    public static void addNormUser(NormalUser normalUser) {
        if (!normUserList.contains(normalUser)) {
            normUserList.add(normalUser);
        } else {
            System.out.println("This user is already a member!");
        }
    }
    public static void addAdmin(Admin admin) {
        if (!adminList.contains(admin)) {
            adminList.add(admin);
        } else {
            System.out.println("This user is already a member!");
        }
    }
    public static void normCommandMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*******Command Menu*******\n.lib add book <name> <author> <subtitle>\n.lib remove book <bookID>\n.lib rent <bookName>\n.lib rent <bookName> <memberName> <memberID>\n.lib get available books\n.lib return <bookName>\n.lib get hrs\nWrite your command: ");
        String command = input.nextLine();
        CLI.normCommander(command);
    }
    public static void adminCommandMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n*******Command Menu*******\n.lib add book <name> <author> <subtitle>\n.lib remove book <bookID>\n.lib rent <bookName>\n.lib rent <bookName> <memberName> <memberID>\n.lib get available books\n.lib return <bookName>\n.lib add member <studentID> <password>\n.lib remove member <memberID>\n.lib get hrs\nWrite your command: ");
        String command = input.nextLine();
        CLI.adminCommander(command);
    }
    public void showMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n*******Library Management System*******");
        boolean bool;
        do {
            System.out.print("\nChoose your role:\n(1) Normal User\n(2) Admin\n(3) Exit\nEnter code: ");
            int role = input.nextInt();
            if (role == 3) break;
            switch (role) {
                case 1:
                    NormalUser normalUser = new NormalUser();
                    System.out.print("\n*******Account*******\n(1) Log in\n(2) Sign up\n(3) Back\nEnter code: ");
                    int nuAccount = input.nextInt();
                    switch (nuAccount) {
                        case 1:
                            if (Boolean.parseBoolean(normalUser.logIn())) {
                                normCommandMenu();
                            } else {
                                System.out.print("Not registered user\nDo you want to sign up? [true/false]: ");
                                if (input.nextBoolean()) {normalUser.signUp();} else {showMenu();}
                            }
                            break;
                        case 2:
                            if (normalUser.signUp()) {
                                System.out.println(normalUser);
                                addNormUser(normalUser);
                                System.out.print("\n\nNow log in to access");
                                showMenu();
                            } else {
                                System.out.println("Signing up went wrong!");
                                showMenu();
                            }
                            break;
                        case 3:
                            showMenu();
                            break;
                        default: System.out.println("Wrong entry!");
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    System.out.print("\n*******Account*******\n(1) Log in\n(2) Sign up\n(3) Back\nEnter code: ");
                    int adminAccount = input.nextInt();
                    switch (adminAccount) {
                        case 1:
                            if (Boolean.parseBoolean(admin.logIn())) {
                                adminCommandMenu();
                            } else {
                                System.out.format("Not registered\nDo you want to sign up? [true/false]: ");
                                if (input.nextBoolean()) {admin.signUp();} else {showMenu();}
                            }
                            break;
                        case 2:
                            if (admin.signUp()) {
                                System.out.println(admin);
                                addAdmin(admin);
                                System.out.print("\n\nNow log in to access");
                                showMenu();
                            } else {
                                System.out.println("Signing up went wrong!");
                                showMenu();
                            }
                            break;
                        case 3:
                            showMenu();
                            break;
                        default: System.out.println("Wrong entry!");
                    }
                    break;
                default: System.out.println("Wrong entry!");
            }
            System.out.println("\nDo you want to continue? [true/false]");
            bool = input.nextBoolean();
        } while (bool);
    }
}