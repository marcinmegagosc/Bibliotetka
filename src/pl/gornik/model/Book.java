package pl.gornik.model;

public class Book {
    private String title;
    private String author;
    private String type;
    private int availability;

    public Book(String title, String author, String type, int availability) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public int getAvailability() {
        return availability;
    }

    public void decreaseAvailability() {
        if (availability > 0) {
            availability--;
        }
    }

    public void increaseAvailability() {
        availability++;
    }

    @Override
    public String toString() {
        return "Tytuł: '" + title + "', Autor: " + author + ", Typ: " + type + ", Dostępność: " + availability;
    }
}