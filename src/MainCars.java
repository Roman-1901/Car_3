import Exceptions.NotDriveLicense;
import transport.Bus;
import transport.Car;
import transport.Truck;

import static transport.Transport.*;

public class MainCars {
    public static void main(String[] args) throws NotDriveLicense {
        Car bmw = new Car("BMW", "Z8", 3.0, Car.CarType.HATCHBACK);
        Car kia = new Car("Kia", "Sportage 4", 2.4, Car.CarType.SEDAN);
        Car audi = new Car("Audi", "A8", 3.0, Car.CarType.MINIVAN);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, Car.CarType.VAN);

        Truck sollers = new Truck("Sollers", "Apro", 2.0, Truck.TruckType.N1);
        Truck jac = new Truck("Jac", "Sunray", 2.5, Truck.TruckType.N2);
        Truck man = new Truck("Man", "TGS", 2.2, Truck.TruckType.N3);
        Truck foton = new Truck("Foton", "Auman", 2.3, Truck.TruckType.N2);

        Bus citroen = new Bus("Citroen", "Jumper", 2.5, Bus.BusType.SMALL);
        Bus mercedes = new Bus("Mercedes-Benz", "Sprinter", 2.8, Bus.BusType.BIG);
        Bus liaz = new Bus("Лиаз", "4292", 2.6, Bus.BusType.BIGGEST);
        Bus volvo = new Bus("Volvo", "7900", 2.2, null);



//       drive(audi, true, 5.3, 250);    //методы из интерфейса переопределил только в родительском классе
//        drive(liaz, false, 10.8, 180);  //переопределять для каждого класса не стал, так как не вижу смысла, информация выводится одинаковая для любого транспорта, независимо от его вида
//
//
//        DriverB petr = new DriverB("петр петров", "B", 5);
//        petr.drive(audi);
//
//        DriverC ivan = new DriverC("Иван Иванов", "dfd", 8);
//        ivan.drive(jac);

//        System.out.println(audi);
//        System.out.println(sollers);
//        System.out.println(jac);
//        System.out.println(liaz);
//        System.out.println(citroen);
//        volvo.printType();
//        kia.printType();




        doDiagnostic(bmw, sollers, volvo, kia, liaz, audi); //в данном методе производится диагностика автомобилей, добавленных в парметры
        System.out.println();
        checkDiagnostic(mercedes, audi, sollers, kia, foton, volvo); //в данном методе проверяется, прошло ли авто диагностику. Те авто, что прошли диагностику, и автобусы - проверка по ним пройдет без проблем, которые ранее не проходили, по ним выйдет ошибка
        System.out.println();

        DriverB vasya = new DriverB("Вася Пупкин", "qw", 10);
        DriverC roma = new DriverC("Роман Громов", "C", 10);
        DriverB dima = new DriverB("Дмитрий Тимошенко", "", 10);
        DriverB john = new DriverB("Ввгений Романов", "B", 10);

    }
}
