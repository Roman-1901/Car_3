import Exceptions.NotDriveLicense;
import transport.Bus;

public class DriverD extends Driver<Bus>{

    private Bus transport;

    public DriverD(String name, String driveLicense, int experience) throws NotDriveLicense {

        super(name, driveLicense, experience);
    }

    public void drive(Bus transport) {
        this.transport = transport;
        if (getDriveLicense().equals("D")) {
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
