package transport;

import Exceptions.NotDriveLicense;
import drivers.Driver;
import drivers.DriverB;

import java.util.ArrayList;
import java.util.List;

public class Car extends Transport implements Competing {

    public enum CarType {
        SEDAN("Седан"), HATCHBACK("Хэтчбэк"), COMPARTMENT("Купе"), UNIVERSAL("Универсал"), ROADSTEP("Внедорожник"), CROSSOVER("Кроссовер"), PICKUP("Пикап"), VAN("Фургон"), MINIVAN("Минивен");
        private String carType;

        CarType(String carType) {
            this.carType = carType;
        }

        public String getCarType() {
            return carType;
        }

        @Override
        public String toString() {
            return carType;
        }

    }

    private CarType type;



    public Car(String brand, String model, double engineVolume, CarType type, DriverB driver) {
        super(brand, model, engineVolume, driver);
        this.type = type;
    }
    public CarType getType() {
        return type;
    }

    public void addMechanics(Mechanic mechanic1) {
        if (mechanic1.getAccessCar().getNum() == 1 || mechanic1.getAccessCar().getNum() == 4) {
            setMechanic(mechanic1);
        } else {
            try {
                throw new RuntimeException("Нельзя добавить данного механика " + mechanic1.getName() + " "+ mechanic1.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addMechanics(Mechanic mechanic1, Mechanic mechanic2) {
        if ((mechanic1.getAccessCar().getNum() == 1 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() != 1 && mechanic2.getAccessCar().getNum() != 4)) {
            setMechanic(mechanic1);
            try {
                throw new RuntimeException("Нельзя добавить второго механика " + mechanic2.getName() + " "+ mechanic2.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else if ((mechanic1.getAccessCar().getNum() == 1 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() == 1 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic1, mechanic2);
        } else if ((mechanic1.getAccessCar().getNum() != 1 && mechanic1.getAccessCar().getNum() != 4) && (mechanic2.getAccessCar().getNum() == 1 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic2);
            try {
                throw new RuntimeException("Нельзя добавить первого механика " + mechanic1.getName() + " "+ mechanic1.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public void printType() {
        if (getType() == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(getType());
        }
    }


    @Override
    public void Diagnostic() {
        setService(true);
        System.out.println("Транспортное средство " + getBrand() + " " + getModel() + " прошло диагностику");
    }




}