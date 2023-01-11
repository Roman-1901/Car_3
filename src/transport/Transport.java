package transport;

import drivers.Driver;
import drivers.DriverB;

public abstract class Transport implements  Competing{
    private final String brand;
    private final String model;

    private double engineVolume;

    private boolean service;

    private Driver driver;

    private Mechanic mechanic1;
    private Mechanic mechanic2;

    public Transport(String brand, String model, double engineVolume, Driver driver) {
        String def = "default";
        if (brand == null || brand.isBlank()) {
            brand = def;
        }
        if (model == null || model.isBlank()) {
            model = def;
        }
        if (engineVolume <= 0) {
            engineVolume = 1.5;
        }
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
        this.service = false;
        this.driver = driver;

        }



    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public boolean getService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public void startMoving() {
        System.out.println(getBrand() +" " + getModel() + " начинает движение");
    }

    public void endMoving() {
        System.out.println(getBrand() +" " + getModel() + " заканчивает движение");
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public void setMechanic(Mechanic mechanic1) {
        this.mechanic1 = mechanic1;
    }

    public void setMechanic(Mechanic mechanic1, Mechanic mechanic2) {
        this.mechanic1 = mechanic1;
        this.mechanic2 = mechanic2;
    }

    public Mechanic getMechanic1() {
        return mechanic1;
    }

    public Mechanic getMechanic2() {
        return mechanic2;
    }

    public abstract void addMechanics(Mechanic mechanic1);
    public abstract void addMechanics(Mechanic mechanic1, Mechanic mechanic2);

    @Override
    public void pitStop(boolean pitStop) {
        if (pitStop) {
            System.out.println(getBrand() + " " + getModel() +" осуществил пит-стоп.");
        } else {
            System.out.println(getBrand() + " " + getModel() +" не осуществлял пит-стоп.");
        }
    }

    @Override
    public void bestLapTime(double minutes) {
        System.out.println("Лучшее время круга " + minutes + " минут.");
    }

    @Override
    public void maxSpeed(int speed) {
        System.out.println("Максимальная скорость " + speed + " км/ч.");
    }

    public static void drive(Transport transport, boolean pitStop,double minutes, int speed) {
        transport.startMoving();
        transport.pitStop(pitStop);
        transport.bestLapTime(minutes);
        transport.maxSpeed(speed);
        transport.endMoving();
        System.out.println();
    }


    public abstract void printType();



    public void Diagnostic() {
        setService(true);
        throw new UnsupportedOperationException(getBrand() + " " + getModel() + " - данный вид транспорта в диагностике не требуется");
    }

    public static void doDiagnostic(Transport... transports) {
        for (Transport transport : transports) {
            try {
                transport.Diagnostic();
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkDiagnostic (Transport... transports) {
        for (Transport transport : transports) {
            if (!transport.getService()) {
                throw new RuntimeException("Транспортное средство " + transport.getBrand() + " " + transport.getModel() + " не прошло диагностику");
            } else {
                System.out.println(transport.getBrand() + " " + transport.getModel() + " - ОК");
            }
        }
    }




    @Override
    public String toString() {
        if (getDriver() != null) {
            return "Данные транспортного средства: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + "\n"
                    + getDriver() + "\n" + "Механик 1: "+ getMechanic1() + "\n"+ "Механик 2: " + getMechanic2() + "\n";
        } else {
            return "Данные транспортного средства: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + "\n"
                    + "Водитель отсутствует" + "\n" + "Механик 1: "+ getMechanic1() + "\n"+ "Механик 2: " + getMechanic2() + "\n";
        }
    }
}

