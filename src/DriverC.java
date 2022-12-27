import transport.Car;
import transport.Transport;
import transport.Truck;

public class DriverC extends Driver<Truck>{

private Truck transport;

    public DriverC(String name, String driveLicense, int experience) {
        super(name, driveLicense, experience);

    }

    public void drive(Truck transport) {
        this.transport = transport;
        if (getDriveLicense() == "C") {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Водитель " + getName() + " не может управлять данным авто");
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
