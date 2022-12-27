import transport.Car;

public class DriverB extends Driver<Car>{

        private Car transport;

        public DriverB(String name, String driveLicense, int experience, Car transport) {
            super(name, driveLicense, experience);
            if (driveLicense == "B") {
                this.transport = transport;
            } else {
                this.transport = null;
            }
        }

        public Car getTransport() {
            return transport;
        }

        public void setTransport(Car transport) {
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



