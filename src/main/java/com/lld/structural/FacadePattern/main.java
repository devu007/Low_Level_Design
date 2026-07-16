package com.lld.structural.FacadePattern;

public class main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        StreamingPlayer player = new StreamingPlayer();
        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(projector, amplifier, player);
        homeTheatre.watchMovie("The Dark Knight");
        homeTheatre.endMovie();
    }
}
