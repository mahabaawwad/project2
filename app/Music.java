public class Music {
    private String composer;
    private int year;
    private int pages;
    private String songName;

    public int getPages() {
        return pages;
    }

    public String getComposer() {
        return composer;
    }

    public String getSongName() {
        return songName;
    }

    public int getYear() {
        return year;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Music{" +
                "composer='" + composer + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", songName='" + songName + '\'' +
                '}';
    }
}
