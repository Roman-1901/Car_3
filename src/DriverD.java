import transport.Bus;

public class DriverD<D extends Bus> extends Driver{

    private D transport;


    public DriverD(String name, String driveLicense, int experience, D transport) {
        super(name, driveLicense, experience);
        if (driveLicense == "D") {
            this.transport = transport;
        } else {
            this.transport = null;
        }
    }

    public D getTransport() {
        return transport;
    }


    public void setTransport(D transport) {
        this.transport = transport;
    }

    public void drive() {
        if (this.transport != null) {
            System.out.println("Водитель " + getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
        } else {
            System.out.println("Нельзя управлять данным транспортом");
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
