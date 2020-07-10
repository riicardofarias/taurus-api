package br.com.gransistemas.taurus.model.marker;

import br.com.gransistemas.taurus.model.Device;

public class Marker {
    private MarkerPosition position;
    private MarkerIcon icon;
    private Device device;

    public Marker(Device device) {
        this.device = device;
        this.position = new MarkerPosition(device.getPosition());

        this.icon = new MarkerIcon(
            device.getIcon(), device.getPosition().getCourse()
        );
    }

    public MarkerPosition getPosition() { return position; }
    public MarkerIcon getIcon() { return icon; }
    public Device getDevice() { return device; }
}
