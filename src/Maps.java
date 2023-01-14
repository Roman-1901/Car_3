import Exceptions.NotDriveLicense;

import drivers.Driver;
import drivers.DriverB;
import drivers.DriverC;
import drivers.DriverD;
import transport.*;

import javax.tools.Diagnostic;
import java.util.*;

import static transport.Transport.*;
public class Maps {
    public static void main(String[] args) throws NotDriveLicense {

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new DriverB("Самохин Иван Петрович", "B", 10));
        drivers.add(new DriverB("Гвоздикин Петр Сергеевич", "B", 8));
        drivers.add(new DriverB("Лановой Сергей Николаевич", "B", 5));
        drivers.add(new DriverB("Барзыкин Владимир Андреевич", "B", 12));

        drivers.add(new DriverC("Панкратов Сергей Николаевич", "C", 18));
        drivers.add(new DriverC("Игнатьев Семен Владимирович", "C", 6));
        drivers.add(new DriverC("Калмыков Владимир Евгеньевич", "C", 16));
        drivers.add(new DriverC("Нигматуллин Ильшат Рамазанович", "C", 12));

        drivers.add(new DriverD("Шляппо Василий Ираклиевич", "D", 11));
        drivers.add(new DriverD("Куценко Андрей Романович", "D", 17));
        drivers.add(new DriverD("Жулебин Игорь Дмитриевич", "D", 15));
        drivers.add(new DriverD("Зарипов Ренат Ильгизович", "D", 9));

        Mechanic mechanicCar1 = new Mechanic("Василий", "Иванов", "Компания1", Mechanic.AccessCar.ONLY_CAR);
        Mechanic mechanicCar2 = new Mechanic("Иван", "Семенов", "Компания2", Mechanic.AccessCar.ONLY_CAR);
        Mechanic mechanicCar3 = new Mechanic("Василий", "Лукин", "Компания2", Mechanic.AccessCar.ONLY_CAR);
        Mechanic mechanicCar4 = new Mechanic("Юрий", "Лопаков", "Компания1", Mechanic.AccessCar.ONLY_CAR);

        Mechanic mechanicTruck1 = new Mechanic("Андрей", "Гунявин", "Компания2", Mechanic.AccessCar.ONLY_TRUCK);
        Mechanic mechanicTruck2 = new Mechanic("Петр", "Николаев", "Компания3", Mechanic.AccessCar.ONLY_TRUCK);
        Mechanic mechanicTruck3 = new Mechanic("Роман", "Самохин", "Компания1", Mechanic.AccessCar.ONLY_TRUCK);
        Mechanic mechanicTruck4 = new Mechanic("Антон", "Нефедов", "Компания1", Mechanic.AccessCar.ONLY_TRUCK);

        Mechanic mechanicBus1 = new Mechanic("Николай", "Кондратьев", "Компания3", Mechanic.AccessCar.ONLY_BUS);
        Mechanic mechanicBus2 = new Mechanic("Константин", "Вешняков", "Компания3", Mechanic.AccessCar.ONLY_BUS);
        Mechanic mechanicBus3 = new Mechanic("Дмитрий", "Борисов", "Компания3", Mechanic.AccessCar.ONLY_BUS);
        Mechanic mechanicBus4 = new Mechanic("Валерий", "Иванов", "Компания2", Mechanic.AccessCar.ONLY_BUS);

        Mechanic mechanicAll1 = new Mechanic("Дмитрий", "Тимошенко", "Компания1", Mechanic.AccessCar.ALL_TRANSPORT);
        Mechanic mechanicAll2 = new Mechanic("Дмитрий", "Арбузов", "Компания1", Mechanic.AccessCar.ALL_TRANSPORT);
        Mechanic mechanicAll3 = new Mechanic("Дмитрий", "Максименко", "Компания2", Mechanic.AccessCar.ALL_TRANSPORT);
        Mechanic mechanicAll4 = new Mechanic("Константин", "Плюхин", "Компания3", Mechanic.AccessCar.ALL_TRANSPORT);


        Car car1 = new Car("BMW", "Z8", 3.0, Car.CarType.HATCHBACK, null);
        Car car2 = new Car("Kia", "Sportage 4", 2.4, Car.CarType.SEDAN, (DriverB) drivers.get(1));
        Car car3 = new Car("Audi", "A8", 3.0, Car.CarType.MINIVAN, null);
        Car car4 = new Car("Hyundai", "Avante", 1.6, Car.CarType.VAN, (DriverB) drivers.get(3));

        Truck truck1 = new Truck("Sollers", "Apro", 2.0, Truck.TruckType.N1, (DriverC) drivers.get(4));
        Truck truck2 = new Truck("Jac", "Sunray", 2.5, Truck.TruckType.N2, (DriverC) drivers.get(5));
        Truck truck3 = new Truck("Man", "TGS", 2.2, Truck.TruckType.N3, (DriverC) drivers.get(6));
        Truck truck4 = new Truck("Foton", "Auman", 2.3, Truck.TruckType.N2, null);

        Bus bus1 = new Bus("Citroen", "Jumper", 2.5, Bus.BusType.SMALL, (DriverD) drivers.get(8));
        Bus bus2 = new Bus("Mercedes-Benz", "Sprinter", 2.8, Bus.BusType.BIG, (DriverD) drivers.get(9));
        Bus bus3 = new Bus("Лиаз", "4292", 2.6, Bus.BusType.BIGGEST, (DriverD) drivers.get(10));
        Bus bus4 = new Bus("Volvo", "7900", 2.2, Bus.BusType.MEDIUM, (DriverD) drivers.get(11));


        Map<Transport, Mechanic> hashMap = new HashMap<>();
        hashMap.put(car1, mechanicCar1);
        hashMap.put(car2, mechanicCar2);
        hashMap.put(truck2, mechanicTruck2);
        hashMap.put(truck3, mechanicTruck3);
        hashMap.put(bus1, mechanicBus1);
        hashMap.put(bus3, mechanicBus3);

        //дублируем те же записи и видим, что они не повторяются в консоли
        hashMap.put(car1, mechanicCar1);
        hashMap.put(car2, mechanicCar2);
        hashMap.put(truck2, mechanicTruck2);
        hashMap.put(truck3, mechanicTruck3);
        hashMap.put(bus1, mechanicBus1);
        hashMap.put(bus3, mechanicBus3);


        for (Map.Entry<Transport, Mechanic> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }





    }


}
