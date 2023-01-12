package transport;

import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

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
        try {
            if (name.equals(transport.getMechanic1().getName()) && surname.equals(transport.getMechanic1().getSurname()) || (name.equals(transport.getMechanic2().getName()) && surname.equals(transport.getMechanic2().getSurname())))  {
                System.out.println("Механик "+ name + " " + surname + " успешно отремонтировал транспорт " + transport.getBrand() + " " + transport.getModel());
            }  else {
                try {
                    throw new RuntimeException("Механик "+ name + " " + surname + " не может проводить техобслуживание транспорта " + transport.getBrand() + " " + transport.getModel());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Механик "+ name + " " + surname + " не может ремонтировать транспорт " + transport.getBrand() + " " + transport.getModel());
        }
    }


    public void serviceTransport (Transport transport) {
        try {
            if ((name.equals(transport.getMechanic1().getName()) && surname.equals(transport.getMechanic1().getSurname())) || (name.equals(transport.getMechanic2().getName()) && surname.equals(transport.getMechanic2().getSurname()))) {
                System.out.println("Механик " + name + " " + surname + " успешно провел техобслуживание транспорта " + transport.getBrand() + " " + transport.getModel());
            }
            else {
                try {
                    throw new RuntimeException("Механик "+ name + " " + surname + " не может проводить техобслуживание транспорта " + transport.getBrand() + " " + transport.getModel());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Механик "+ name + " " + surname + " не может проводить техобслуживание транспорта " + transport.getBrand() + " " + transport.getModel());
        }
    }




    @Override
    public String toString() {
        return name + " " +surname + ", компания: " + nameCompany;
    }
}
