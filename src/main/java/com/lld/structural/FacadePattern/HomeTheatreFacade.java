package com.lld.structural.FacadePattern;

public class HomeTheatreFacade {
    private Projector projector;
    private Amplifier amplifier;
    private StreamingPlayer player;

    public HomeTheatreFacade(Projector projector, Amplifier amplifier, StreamingPlayer player) {
        this.projector = projector;
        this.amplifier = amplifier;
        this.player = player;
    }

    public void watchMovie(String movie) {
        projector.on();
        amplifier.on();
        player.on();
    }

    public void endMovie() {
        projector.off();
        amplifier.off();
        player.off();
    }
}
