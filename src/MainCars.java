import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

public class MainCars {
    public static void main(String[] args) {
        Car bmw = new Car("BMW", "Z8", 3.0);
        Car kia = new Car("Kia", "Sportage 4", 2.4);
        Car audi = new Car("Audi", "A8", 3.0);
        Car hyundai = new Car("Hyundai", "Avante", 1.6);

        Truck sollers = new Truck("Sollers", "Apro", 2.0);
        Truck jac = new Truck("Jac", "Sunray", 2.5);
        Truck man = new Truck("Man", "TGS", 2.2);
        Truck foton = new Truck("Foton", "Auman", 2.3);

        Bus citroen = new Bus("Citroen", "Jumper", 2.5);
        Bus mercedes = new Bus("Mercedes-Benz", "Sprinter", 2.8);
        Bus liaz = new Bus("Лиаз", "4292", 2.6);
        Bus volvo = new Bus("Volvo", "7900", 2.2);

        drive(audi, true,5.3, 250);    //методы из интерфейса переопределил только в родительском классе
        drive(liaz, false,10.8, 180);  //переопределять для каждого класса не стал, так как не вижу смысла, информация выводится одинаковая для любого транспорта, независимо от его вида

        Driver<Car, Truck, Bus> ivan = new Driver<>("Иван Иванов", "B", 10);
        ivan.driveTransport(kia);
        ivan.driveTransport(citroen); // в данном случае у водителя категория B, а данное авто относится к автобусам, водить его не может.

    }

    public static void drive(Transport transport, boolean pitStop,double minutes, int speed) {
        transport.startMoving();
        transport.pitStop(pitStop);
        transport.bestLapTime(minutes);
        transport.maxSpeed(speed);
        transport.endMoving();
        System.out.println();
    }

}
