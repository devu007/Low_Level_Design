package com.lld.structural.ProxyDesign;

//is_a relationship with Image interface
public class ProxyImage implements Image {
    private RealImage realImage; // has_a relationship
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } // lazy initialization
        realImage.display();
    }
}
