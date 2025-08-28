public class CD extends LibraryItem{

    String artist;
    int numOfTracks;

    public CD(){
        this.artist = "";
        this.numOfTracks = 0;
    }
    public CD(String title, int year, String artist, int numOfTracks){
        super(title, year);
        this.artist = artist;
        this.numOfTracks = numOfTracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArtist: " + artist + "\nNumber Of Tracks: " + numOfTracks;
    }
    public String formatForCSV(){
        return super.toString() + "\nArtist: " + artist + "\nNumber Of Tracks: " + numOfTracks;
    }


}
