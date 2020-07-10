package br.com.gransistemas.taurus.model.marker;

import br.com.gransistemas.taurus.model.Position;

public class MarkerPosition {
    private double lat;
    private double lng;

    public MarkerPosition(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public MarkerPosition(Position position){
        if(position != null){
            this.lat = position.getLatitude();
            this.lng = position.getLongitude();
        }
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
