import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    public String name;
    public String userID;
    public String phonenumber;
    public User() {}
    public User(String name, String userID, String phonenumber) {
        this.name = name;
        this.userID = userID;
        this.phonenumber = phonenumber;
    }
    Scanner input = new Scanner(System.in);
    public void setName() {
        System.out.print("Name: ");
        this.name = input.nextLine();
    }
    public void setUserID() {
        System.out.print("ID: ");
        String id = input.next();
        Pattern pattern = Pattern.compile("^[0-9]{5,11}$");
        Matcher matcher = pattern.matcher(id);
        while (!matcher.find()) {
            System.out.println("Wrong entry! Try again: ");
            id = input.next();
            matcher = pattern.matcher(id);
        }
        this.userID = id;
    }
    public void setPhonenumber() {
        System.out.print("Phone number: ");
        String phonenumb = input.next();
        Pattern pattern = Pattern.compile("^09[0-9]{9}$");
        Matcher matcher = pattern.matcher(phonenumb);
        while (!matcher.find()) {
            System.out.println("Wrong entry! Try again: ");
            phonenumb = input.next();
            matcher = pattern.matcher(phonenumb);
        }
        this.phonenumber = phonenumb;
    }
    public boolean signUp() {
        System.out.print("\n*******Signing up*******\n");
        setName();
        setUserID();
        setPhonenumber();
        return true;
    }
    public String logIn() {
        System.out.print("\n*******Logging in*******\nEnter your ID: ");
        String id = input.next();
        Pattern pattern = Pattern.compile("^[0-9]{5,11}$");
        Matcher matcher = pattern.matcher(id);
        while (!matcher.find()) {
            System.out.println("Wrong entry! Try again: ");
            id = input.next();
            matcher = pattern.matcher(id);
        }
        return id;
    }
    public String toString() {
        return String.format("\n*******User information*******\nName: %s\nID: %s\nPhone number: %s", name, userID, phonenumber);
    }
}
