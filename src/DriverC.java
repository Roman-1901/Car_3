import transport.Car;
import transport.Truck;

public class DriverC extends Driver<Truck>{

    private Truck transport;

    public DriverC(String name, String driveLicense, int experience, Truck transport) {
        super(name, driveLicense, experience);
        if (driveLicense == "C") {
            this.transport = transport;
        } else {
            this.transport = null;
        }
    }

    public Truck getTransport() {
        return transport;
    }


    public void setTransport(Truck transport) {
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
