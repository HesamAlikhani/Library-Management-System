import java.util.Scanner;

public class Admin extends User {
    private String password;
    public Admin() {}
    public Admin(String name, String userID, String phoneNUmber, String password) {
        super(name, userID, phoneNUmber);
        this.password = password;
    }
    Scanner input = new Scanner(System.in);
    public void setPassword() {
        System.out.print("Enter a password: ");
        this.password = input.next();
    }
    @Override
    public boolean signUp() {
        super.signUp();
        setPassword();
        System.out.print("You signed up successfully!\n");
        return true;
    }
    @Override
    public String logIn() {
        System.out.print("Enter your password: ");
        String entrypass = input.next();
        String bool = new String();
        for (Admin admin : Library.adminList) {
            if (admin.userID.equals(super.logIn()) && admin.password.equals(entrypass)) {
                System.out.println("Logged in successfully!\n");
                bool = "true";
            } else {
                bool = "false";
            }
        }
        return bool;
    }
    @Override
    public String toString() {
        return super.toString() + "Password: " + password;
    }
}
