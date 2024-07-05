import java.sql.Time;
import java.util.Date;
public class Rent {
    private Book book;
    private NormalUser normalUser;
    Time time = new Time(System.currentTimeMillis());
    private final int rentalID = (int) time.getTime();
    private String bookName, userName, userID;
    Date rentalDate = new Date();
    public Rent(String bookName) {
        this.bookName = bookName;
    }
    public Rent(String bookName, String userName, String userID) {
        this.bookName = bookName;
        this.userName = userName;
        this.userID = userID;
    }
    public boolean bookVerify() {
        boolean  bool = false;
        for (Book book : Library.bookList) {
            if (book.title.equals(bookName) && book.availability) {
                book.availability = false;
                this.book = book;
                System.out.println("Book rented successfully!");
                bool = true;
            } else {
                System.out.format("Book <%s> does not exists!\n", bookName);
                bool = false;
            }
        }
        return bool;
    }
    public boolean userVerify() {
        boolean bool = false;
        for (NormalUser normalUser : Library.normUserList) {
            if (normalUser.name.equals(this.userName) && normalUser.userID.equals(this.userID)) {
                this.normalUser = normalUser;
                bool = true;
            } else {
                System.out.format("User <%s> with ID<%s> dose not exists!", userName, userID);
                bool = false;
            }
        }
        return bool;
    }
    @Override
    public String toString() {
        return String.format("\n*******Rent information*******\n"+ "Rental ID: " + rentalID + "\nRental date: "+ rentalDate + book + normalUser);
    }
}
