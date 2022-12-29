package transport;

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

    public Bus(String brand, String model, double engineVolume, BusType type) {
        super(brand, model, engineVolume);
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


    @Override
    public String toString() {
        return "Данные автобуса: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume() + " " + type;
    }
}
