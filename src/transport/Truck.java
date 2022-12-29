package transport;

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

    public Truck(String brand, String model, double engineVolume, TruckType type) {
        super(brand, model, engineVolume);
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

    public void Diagnostic() {
        setService(true);
        System.out.println("Транспортное средство " + getBrand() + " " + getModel() + " прошло диагностику");
    }

    @Override
    public String toString() {
        return "Данные грузового автомобиля: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + ", " + type;
    }
}
