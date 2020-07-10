package br.com.gransistemas.taurus.model.marker;

public class MarkerIcon {
    private String name;
    private double rotation;

    public MarkerIcon(String icon, double rotation) {
        this.name = icon;
        this.rotation = rotation;
    }

    public String getName() {
        return name;
    }

    public double getRotation() {
        return rotation;
    }
}
