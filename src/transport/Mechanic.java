package transport;

import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

import java.util.SortedMap;

public class Mechanic {
    private String name;
    private String surname;
    private String nameCompany;

    public enum AccessCar {
        ONLY_CAR(1), ONLY_TRUCK(2), ONLY_BUS(3), ALL_TRANSPORT(4);
        private int num;

        AccessCar(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
    private AccessCar accessCar;

    public Mechanic(String name, String surname, String nameCompany, AccessCar accessCar) {
        this.name = name;
        this.surname = surname;
        this.nameCompany = nameCompany;
        this.accessCar = accessCar;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setAccessCar(String accessCar) {
        this.accessCar = AccessCar.valueOf(accessCar);
    }

    public AccessCar getAccessCar() {
        return accessCar;
    }




    public void fixTransport (Transport transport) {
        fixCheckTransport (transport, " успешно отремонтировал транспорт ", " не может ремонтировать транспорт ");
    }

    public void serviceTransport (Transport transport) {
        fixCheckTransport (transport, " успешно провел техобслуживание транспорта ", " не может проводить техобслуживание транспорта ");
    }


    public void fixCheckTransport (Transport transport, String fixCheck, String notFixCheck) {
        boolean check = false;
        for (int i = 0; i < transport.mechanics.size(); i++) {
            if (name.equals(transport.mechanics.get(i).getName()) && surname.equals(transport.mechanics.get(i).getSurname())) {
                check = true;
                System.out.println("Механик " + name + " " + surname + fixCheck + transport.getBrand() + " " + transport.getModel());
                break;
            }
        }
        if (!check) {
            try {
                throw new RuntimeException("Механик "+ name + " " + surname + notFixCheck + transport.getBrand() + " " + transport.getModel());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }



        @Override
        public String toString () {
            return name + " " + surname + ", компания: " + nameCompany;
        }
    }

