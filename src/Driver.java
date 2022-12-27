import transport.*;

import java.time.LocalDate;

public abstract class Driver<T extends Transport> {

    private String name;
    private String driveLicense;

    int experience;
    private final int yearDriveLicense;

    private T transport;


    public Driver(String name, String driveLicense, int experience) {
        if (name == null || name.isBlank()) {
            name = "Иванов Иван Иванович";
        }
        this.name = name;

        if (driveLicense == null || driveLicense.isBlank()) {
            driveLicense = "Категорию прав не имеет";
        }
        this.driveLicense = driveLicense;

        if (experience <= 0) {
            experience = 1;
        }
        this.experience = experience;
        this.yearDriveLicense = LocalDate.now().getYear() - experience;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }

    public int getExperience() {
        experience = LocalDate.now().getYear() - yearDriveLicense;
        return experience;
    }

    public int getYearDriveLicense() {
        return yearDriveLicense;
    }

    public void startMoving() {
        System.out.println("Водитель " + name +" начинает движение");
    }

    public void stopMoving() {
        System.out.println("Водитель " + name +" останавливается");
    }

    public void refuelCar() {
        System.out.println("Водитель " + name +" заправляется");
    }

    public abstract  void drive(T transport);


    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", driveLicense='" + driveLicense + '\'' +
                ", experience=" + experience + "}";
    }
}

