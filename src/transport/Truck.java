package transport;

public class Truck extends Transport implements Competing{
    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }



    public String toString() {
        return "Данные грузового автомобиля: бренд: " + getBrand() + ", модель: " + getModel() + ", объем двигателя: " + getEngineVolume();
    }
}
