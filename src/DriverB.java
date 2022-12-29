import transport.Car;
import transport.Truck;

public class DriverB extends Driver<Car>{
private Car transport;
        public DriverB(String name, String driveLicense, int experience) throws NotDriveLicense {
            super(name, driveLicense, experience);
        }

    public void drive(Car transport) {
        this.transport = transport;
        if (getDriveLicense().equals("B")) {
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



