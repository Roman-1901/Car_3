package drivers;

import Exceptions.NotDriveLicense;
import transport.Car;

public class DriverB extends Driver<Car>{
private Car transport;
        public DriverB(String name, String driveLicense, int experience) throws NotDriveLicense {
            super(name, driveLicense, experience);
            if (!driveLicense.equals("B")) {
                    throw new NotDriveLicense("Водитель класса DriveB должен иметь категорию B");
            }
        }

    public void drive(Car transport) {
        this.transport = transport;
        if (getDriveLicense().equals("B")) {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Водитель " + getName() + " не может управлять данным авто");
        }
    }


    }



