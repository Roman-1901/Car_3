package drivers;

import Exceptions.NotDriveLicense;
import transport.Bus;

public class DriverD extends Driver<Bus>{

    private Bus transport;

    public DriverD(String name, String driveLicense, int experience) throws NotDriveLicense {
        super(name, driveLicense, experience);
        if (!driveLicense.equals("D")) {
            throw new NotDriveLicense("Водитель класса DriveD должен иметь категорию D");
        }
    }

    public void drive(Bus transport) {
        this.transport = transport;
        if (getDriveLicense().equals("D")) {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Водитель " + getName() + " не может управлять данным авто");
        }
    }


}
