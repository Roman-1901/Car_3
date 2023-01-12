package transport;

import drivers.Driver;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport implements  Competing{
    private final String brand;
    private final String model;

    private double engineVolume;

    private boolean service;

    private Driver driver;

    protected List <Mechanic> mechanics = new ArrayList<>();

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


    public String getDriver() {
        return "Водитель " + driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public void getMechanics() {
        System.out.println("Механики:");
        for (int i = 0; i < mechanics.size(); i++) {
            System.out.println(mechanics.get(i));
        }
    }



    public abstract void addMechanics(Mechanic ... mechanic);

    public void addMechanicsTransport(int num1, int num2, Mechanic ... mech) {
        for (Mechanic mechanic : mech) {
            if (mechanic.getAccessCar().getNum() == num1 || mechanic.getAccessCar().getNum() == num2) {
                mechanics.add(mechanic);
            } else {
                try {
                    throw new RuntimeException("Нельзя добавить механика " + mechanic.getName() + " "+ mechanic.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void showInfoTransport(List<Transport> transports, int index) {
        System.out.println(transports.get(index));
        System.out.println(transports.get(index).getDriver());
        transports.get(index).getMechanics();
    }

    public static void showInfoTransports(List<Transport> transports) {
        for (int i = 0; i < transports.size(); i++) {
            System.out.println(transports.get(i));
            System.out.println(transports.get(i).getDriver());
            transports.get(i).getMechanics();
        }
    }



    //------------------------------------------------------------------------------------------------------

    public void startMoving() {
        System.out.println(getBrand() +" " + getModel() + " начинает движение");
    }

    public void endMoving() {
        System.out.println(getBrand() +" " + getModel() + " заканчивает движение");
    }

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



    public String toString() {
        if (getDriver() != null) {
            return "Данные транспортного средства: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + "\n";
        } else {
            return "Данные транспортного средства: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + "\n";
        }
    }
}

