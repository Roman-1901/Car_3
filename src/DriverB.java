import transport.Car;

public class DriverB<B extends Car> extends Driver{

        private B transport;

        public DriverB(String name, String driveLicense, int experience, B transport) {
            super(name, driveLicense, experience);
            if (driveLicense == "B") {
                this.transport = transport;
            } else {
                this.transport = null;
            }
        }

        public B getTransport() {
            return transport;
        }

        public void setTransport(B transport) {
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



