import java.util.Date;
public class NormalUser extends User {
    Date date = new Date();
    public NormalUser() {
        super();
    }
    public NormalUser(String name, String userID, String phonenumber) {
        super(name, userID, phonenumber);
    }
    @Override
    public boolean signUp() {
        super.signUp();
        System.out.print("You signed up successfully!\n");
        return true;
    }
    @Override
    public String logIn() {
        String bool = new String();
        for (NormalUser normalUser : Library.normUserList) {
            if (normalUser.userID.equals(super.logIn())) {
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
        return super.toString() + "\nRegistration date: " + date;
    }
}
