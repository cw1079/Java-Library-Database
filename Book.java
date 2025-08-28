public class Book extends LibraryItem{

    String author;
    String isbn;

    public Book(){
        this.author = "";
        this.isbn = "";
    }
    public Book(String title, int year, String author, String isbn){
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAuthor: " + author + "\nIsbn: " + isbn;
    }
    public String formatForCSV(){
        return super.toString() + "\nAuthor: " + author + "\nIsbn: " + isbn;
    }
}
