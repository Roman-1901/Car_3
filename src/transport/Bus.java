package transport;

import drivers.DriverD;

public class Bus extends Transport implements Competing {

    public enum BusType {
        SMALLEST(null, 10), SMALL(null, 25), MEDIUM(40, 50), BIG(60, 80), BIGGEST(100, 120);
        private Integer lowerLimit;
        private Integer upperLimit;

        BusType(Integer lowerLimit, Integer upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public String toString() {
            if (lowerLimit == null) {
                return "Вместимость: до " + upperLimit + " мест";
            } else if (upperLimit == null) {
                return "Вместимость: от " + lowerLimit + " мест";
            } else {
                return "Вместимость: " + lowerLimit + " - " + upperLimit + " мест";
            }
        }
    }

    private BusType type;

    public Bus(String brand, String model, double engineVolume, BusType type, DriverD driver) {
        super(brand, model, engineVolume, driver);
        this.type = type;
        setService(true);
    }

    public BusType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = BusType.valueOf(type);
    }

    public void printType() {
        if (getType() == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(getType());
        }
    }


    public void addMechanics(Mechanic mechanic1) {
        if (mechanic1.getAccessCar().getNum() == 3 || mechanic1.getAccessCar().getNum() == 4) {
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
        if ((mechanic1.getAccessCar().getNum() == 3 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() != 3 && mechanic2.getAccessCar().getNum() != 4)) {
            setMechanic(mechanic1);
            try {
                throw new RuntimeException("Нельзя добавить второго механика " + mechanic2.getName() + " "+ mechanic2.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else if ((mechanic1.getAccessCar().getNum() == 3 || mechanic1.getAccessCar().getNum() == 4) && (mechanic2.getAccessCar().getNum() == 3 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic1, mechanic2);
        } else if ((mechanic1.getAccessCar().getNum() != 3 && mechanic1.getAccessCar().getNum() != 4) && (mechanic2.getAccessCar().getNum() == 3 || mechanic2.getAccessCar().getNum() == 4)) {
            setMechanic(mechanic2);
            try {
                throw new RuntimeException("Нельзя добавить первого механика " + mechanic1.getName() + " "+ mechanic1.getSurname() + " к транспорту "+ getBrand() + " "+ getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
