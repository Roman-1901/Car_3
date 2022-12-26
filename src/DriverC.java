import transport.Car;
import transport.Truck;

public class DriverC<C extends Truck> extends Driver{

    private C transport;

    public DriverC(String name, String driveLicense, int experience, C transport) {
        super(name, driveLicense, experience);
        if (driveLicense == "C") {
            this.transport = transport;
        } else {
            this.transport = null;
        }
    }

    public C getTransport() {
        return transport;
    }


    public void setTransport(C transport) {
        this.transport = transport;
    }

    public void drive() {
        if (this.transport != null) {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Нельзя управлять данным транспортом");
        }
    }
    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + '\'' +
                ", driveLicense='" + getDriveLicense() + '\'' +
                ", experience=" + getExperience() + "}";
    }
}
