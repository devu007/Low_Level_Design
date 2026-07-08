package com.lld.structural.ProxyDesign;

//is_a relationship with Image interface
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(filename);
    }

    private void loadFromDisk(String filename) {
        System.out.println("Loading " + filename + " from disk");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
