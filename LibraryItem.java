public class LibraryItem {
    String title;
    int year;

    public LibraryItem(){
        this.title = "";
        this.year = 0;
    }
    public LibraryItem(String title, int year){
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        return "Title: " + title + "\nYear: " + year;
    }
    public String formatForCSV(){
        return "Title: " + title + "\nYear: " + year;
    }
}
