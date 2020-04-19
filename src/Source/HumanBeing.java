package Source;

import Exceptions.MyEmptyException;
import Exceptions.MyNullException;
import Settings.Settings;
import com.sun.tools.javac.Main;

import java.util.Date;

public class HumanBeing {
    //параметры класса HumanBeing
    //переменная для выдачи id по колличеству HumanBeing
    static Long NumberOfHumans = 0L;
    private Long id = 0L;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private WeaponType weaponType;
    private Mood mood;
    private Car car;

    //конструктор класс HumanBeing
    public HumanBeing(String name, Coordinates coordinates,
                      Date creationDate, boolean realHero, boolean hasToothpick,
                      double impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        //проверяем условие
        try {
            if (name == null) {
                throw new MyNullException("Error null string");
            }
            if (name.equals("") || coordinates == null || creationDate == null
                    || weaponType == null || mood == null || car == null) {
                throw new MyEmptyException("Error empty string");
            }
            this.name = name;
            this.coordinates = coordinates;
            this.creationDate = creationDate;
            this.realHero = realHero;
            this.hasToothpick = hasToothpick;
            this.impactSpeed = impactSpeed;
            this.weaponType = weaponType;
            this.mood = mood;
            this.car = car;

            this.id = ++NumberOfHumans;
        } catch (MyNullException | MyEmptyException e) {
            e.printStackTrace();
        }
    }

    //функции класса для получения значения параметров
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isRealHero() {
        return  realHero;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public double getImpactSpeed() {
        return impactSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }
}
