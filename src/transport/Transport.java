package transport;

public abstract class Transport implements  Competing{
    private final String brand;
    private final String model;

    private double engineVolume;

    private boolean service;

    public Transport(String brand, String model, double engineVolume) {
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
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}

