public class DVD extends LibraryItem {
    String director;
    int duration;

    public DVD(){
        this.director = "";
        this.duration = 0;
    }
    public DVD(String title, int year, String director, int duration){
        super(title, year);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDirector: " + director + "\nDuration: " + duration;
    }
    public String formatForCSV(){
        return super.toString() + "\nDirector: " + director + "\nDuration: " + duration;
    }
}
