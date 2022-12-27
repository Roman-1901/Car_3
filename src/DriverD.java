import transport.Bus;
import transport.Car;

public class DriverD extends Driver<Bus>{

    private Bus transport;

    public DriverD(String name, String driveLicense, int experience) {
        super(name, driveLicense, experience);
    }

    public void drive(Bus transport) {
        this.transport = transport;
        if (getDriveLicense() == "D") {
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
