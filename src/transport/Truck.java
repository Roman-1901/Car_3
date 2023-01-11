package transport;

import drivers.DriverC;

public class Truck extends Transport implements Competing {

    public enum TruckType {
        N1(null, 3.5F), N2(3.5F, 12.0F), N3(12.0F, null);

        private Float lowerLimit;
        private Float upperLimit;

        TruckType(Float lowerLimit, Float upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public String toString() {
            if (lowerLimit == null) {
                return "Грузоподъёмность: до " + upperLimit + "т.";
            } else if (upperLimit == null) {
                return "Грузоподъёмность: от " + lowerLimit + "т.";
            } else {
                return "Грузоподъёмность: от " + lowerLimit + "т." + " до " + upperLimit + "т.";
            }
        }
    }

    private TruckType type;

    public Truck(String brand, String model, double engineVolume, TruckType type, DriverC driver) {
        super(brand, model, engineVolume, driver);
        this.type = type;
    }

    public TruckType getType() {
        return type;
    }
    public void setType(String type) {
        this.type = TruckType.valueOf(type);
    }

    public void printType() {
        if (getType() == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(getType());
        }
    }

    public void addMechanics(Mechanic mechanic1) {
        if (mechanic1.getAccessCar().getNum() == 2 || mechanic1.getAccessCar().getNum() == 4) {
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
        if ((mechanic1.getAccessCar().getNum() == 2 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() != 2 && mechanic2.getAccessCar().getNum() != 4)) {
            setMechanic(mechanic1);
            try {
                throw new RuntimeException("Нельзя добавить второго механика " + mechanic2.getName() + " "+ mechanic2.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else if ((mechanic1.getAccessCar().getNum() == 2 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() == 2 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic1, mechanic2);
        } else if ((mechanic1.getAccessCar().getNum() != 2 && mechanic1.getAccessCar().getNum() != 4) && (mechanic2.getAccessCar().getNum() == 2 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic2);
            try {
                throw new RuntimeException("Нельзя добавить первого механика " + mechanic1.getName() + " "+ mechanic1.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void Diagnostic() {
        setService(true);
        System.out.println("Транспортное средство " + getBrand() + " " + getModel() + " прошло диагностику");
    }


}
