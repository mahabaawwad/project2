package com.example.myapplication;

public class Music {
    private String composer;
    private String pieceYear;
    private String piecePages;
    private String name;

    public Music(String composerName, String pagesNum, String year, String pieceName) {
        composer=composerName;
        pieceYear=year;
        piecePages=pagesNum;
        name=pieceName;

    }

    public String getPiecePages() {
        return piecePages;
    }

    public String getComposer() {
        return composer;
    }

    public String getName() {
        return name;
    }

    public String getPieceYear() {return pieceYear;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setPiecePages(String piecePages) {
        this.piecePages = piecePages;
    }

    public void setName(String songName) {
        this.name = songName;
    }

    public void setPieceYear(String pieceYear) {pieceYear = pieceYear;
    }

    @Override
    public String toString() {
        return "Music{" +
                "composer='" + composer + '\'' +
                ", year=" + pieceYear +
                ", pages=" + piecePages +
                ", songName='" + name + '\'' +
                '}';
    }

}
