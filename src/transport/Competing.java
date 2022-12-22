package transport;

public interface Competing {
    void pitStop(boolean pitStop);
    void bestLapTime(double minutes);
    void maxSpeed(int speed);
}

