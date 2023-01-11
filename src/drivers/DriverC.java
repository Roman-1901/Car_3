package drivers;

import Exceptions.NotDriveLicense;
import transport.Truck;

public class DriverC extends Driver<Truck>{

private Truck transport;

    public DriverC(String name, String driveLicense, int experience) throws NotDriveLicense {
        super(name, driveLicense, experience);
        if (!driveLicense.equals("C")) {
            throw new NotDriveLicense("Водитель класса DriveB должен иметь категорию C");
        }
    }

    public void drive(Truck transport) {
        this.transport = transport;
        if (getDriveLicense().equals("C")) {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Водитель " + getName() + " не может управлять данным авто");
        }
    }


}
