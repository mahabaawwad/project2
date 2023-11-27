package com.example.myapplication;

public class MusicNote {
    private String composer;
    private String pieceYear;
    private String piecePages;
    private String name;

    public MusicNote(String composerName, String pieceName, String pagesNum, String year) {
        composer=composerName;
        name=pieceName;
        piecePages=pagesNum;
        pieceYear=year;

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

    public void setPieceYear(String pieceYear) {this.pieceYear = pieceYear;
    }

    @Override
    public String toString() {
        return "Music{" +
                "composer='" + composer + '\'' +
                ", songName='" + name +
                ", pages=" + piecePages +
                ", year='" + pieceYear + '\'' +
                '}';
    }

}
