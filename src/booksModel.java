public class booksModel {
    private int id;
    private String bookName;
    private int pageNumbers;
    private String topic;
    private String releaseDate;
    private boolean isAvailable;
    private String author;

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public String getTopic() {
        return topic;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public booksModel(int id, String bookName, int pageNumbers, String topic, String releaseDate, boolean isAvailable, String author) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
        this.author = author;
    }
}
