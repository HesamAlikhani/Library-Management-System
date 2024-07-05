import java.sql.Time;

public class Book {
    Time time = new Time(System.currentTimeMillis());
    public final int bookID = (int) time.getTime();
    public final String title, author;
    public String description = "No description";
    public boolean availability;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.availability = true;
    }
    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.availability = true;
    }
    public String toString() {
        return String.format("\n*******Book information*******\nTitle: %s\nAuthor: %s\nID: %d\nDescription: %s\nAvailability: %s", title, author, bookID, description, availability);
    }
}