package transport;

import drivers.DriverB;

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



    public void addMechanics(Mechanic... mechanics) {
        addMechanicsTransport(1, 4, mechanics);
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

    @Override
    public String toString() {
        return "\nДанные легкового автомобиля: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + ", тип кузова " + type;
    }


}