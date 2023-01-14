import Exceptions.NotDriveLicense;

import drivers.Driver;
import drivers.DriverB;
import drivers.DriverC;
import drivers.DriverD;
import transport.*;

import javax.tools.Diagnostic;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import static transport.Transport.*;


public class MainCars {
    public static void main(String[] args) throws NotDriveLicense {

// - Добавлены водители. Сделана проверка на категорию прав. То есть в DriveB нельзя указать другую категорию, кроме В, по остальным так же. Иначе выскакивает exception

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

// - Добавлены механики. Для каждого механика добавлен Enum, может ли он обслуживать только определенный тип авто, либо все авто.
//   При добавлении механиков к автомобилям будет учитываться навык механика. То есть, если к автомобилю из класса Car добавить механика, который обслуживает только грузовики ONLY_TRUCK,
//   данный механик не добавится к автотранспорту.


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

        List<Mechanic> mechanics = new ArrayList<>();

        mechanics.add(mechanicCar1);
        mechanics.add(mechanicCar2);
        mechanics.add(mechanicCar3);
        mechanics.add(mechanicCar4);
        mechanics.add(mechanicTruck1);
        mechanics.add(mechanicTruck2);
        mechanics.add(mechanicTruck3);
        mechanics.add(mechanicTruck4);
        mechanics.add(mechanicBus1);
        mechanics.add(mechanicBus2);
        mechanics.add(mechanicBus3);
        mechanics.add(mechanicBus4);
        mechanics.add(mechanicAll1);
        mechanics.add(mechanicAll2);
        mechanics.add(mechanicAll3);
        mechanics.add(mechanicAll4);



                      // Добавлены автомобили и закреплены водители. Также сделано ограничение, например, нельзя добавить водителя категории С к автомобилю категории B т т.д.

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

        List<Transport> transports = new ArrayList<>();
        transports.add(car1);
        transports.add(car2);
        transports.add(car3);
        transports.add(car4);
        transports.add(truck1);
        transports.add(truck2);
        transports.add(truck3);
        transports.add(truck4);
        transports.add(bus1);
        transports.add(bus2);
        transports.add(bus3);
        transports.add(bus4);



//Тут добавляются механики к автомобилям. Добавить можно любое количество механиков.
// В консоли виден результат, механики, которые не соответствуют типу автомобиля, не добавляются, вместо этого выдается комментарий, что нельзя добавить данного механика к автомобилю.

        //Cars
        transports.get(0).addMechanics(mechanics.get(0), mechanics.get(13)); // Успешно добавятся оба
        transports.get(1).addMechanics(mechanics.get(4), mechanics.get(2)); // Первый не добавится, т.к. механик имеет доступ к Truck
        transports.get(2).addMechanics(mechanics.get(2), mechanics.get(1)); // Успешно добавятся оба
        transports.get(3).addMechanics(mechanics.get(9), mechanics.get(2), mechanics.get(13)); //Первый не добавится(имеет доступ к Bus), второй и третий добавятся

        //Trucks
        transports.get(4).addMechanics(mechanics.get(14), mechanics.get(1)); // Первый добавится, второй имеет доступ только к Car
        transports.get(5).addMechanics(mechanics.get(5), mechanics.get(6), mechanics.get(12)); // Успешно добавятся трое
        transports.get(6).addMechanics(mechanics.get(6)); // Добавится
        transports.get(7).addMechanics(mechanics.get(7), mechanics.get(8)); //Первый добавится, второй имеет доступ только к Bus

        //Buses
        transports.get(8).addMechanics(mechanics.get(8), mechanics.get(9), mechanics.get(10)); // Успешно добавятся трое
        transports.get(9).addMechanics(mechanics.get(1), mechanics.get(14)); //Первый не добавится(имеет доступ к Car), второй добавится
        transports.get(10).addMechanics(mechanics.get(8)); // Добавится
        transports.get(11).addMechanics(mechanics.get(10), mechanics.get(12)); // Успешно добавятся оба



        //и того, пять механиков не добавилось, по ним выдаст соответствующий эксепшн




        //Вызов метода "Починить машину". Если водитель допущен к авто, то есть был ранее добавлен к автомобилю, то может отремонтировать, если же нет, то выдаст соответсвующий exception.
        System.out.println();
        mechanics.get(0).fixTransport(transports.get(2));
        mechanics.get(8).fixTransport(transports.get(8));
        mechanics.get(12).fixTransport(transports.get(3));
        mechanics.get(12).fixTransport(transports.get(11));
        mechanics.get(3).fixTransport(transports.get(1));
        mechanics.get(14).fixTransport(transports.get(9));
        mechanics.get(6).fixTransport(transports.get(5));
        mechanics.get(0).fixTransport(bus1);

        //Аналогичный метод "Произвести техобслуживание"
        System.out.println();
        mechanics.get(15).serviceTransport(transports.get(1));
        mechanics.get(4).serviceTransport(transports.get(1));
        mechanics.get(10).serviceTransport(transports.get(10));
        mechanics.get(10).serviceTransport(transports.get(11));
        mechanics.get(8).serviceTransport(transports.get(10));
        mechanics.get(3).serviceTransport(transports.get(1));
        mechanics.get(7).serviceTransport(transports.get(7));




        // Выводится информация по любому транспорту по индексу. Также указаны водители и механики, закрепленные за авто.
        // Там, где водители или механики не добавились, высвечивается null.
       showInfoTransport(transports, 5);
       showInfoTransport(transports, 8);
       showInfoTransport(transports, 0);
       showInfoTransport(transports, 2);

       // Выводится полный список всех машин с водителями и механиками
 //    showInfoTransports(transports);


        //Проверка диагностики. У первой машины отсутсвует водитель, выдаст исключение, у второй проверит, третий - автобус, в проверке не нуждается
        System.out.println();
        try {
            transports.get(0).Diagnostic();
        } catch (NotDriveLicense e) {
            System.out.println(e.getMessage());
        }

        try {
            transports.get(1).Diagnostic();
        } catch (NotDriveLicense e) {
            System.out.println(e.getMessage());
        }

        try {
            transports.get(11).Diagnostic();
        } catch (NotDriveLicense e) {
            System.out.println(e.getMessage());
        }

    }




}
