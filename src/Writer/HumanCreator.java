package Writer;

import Source.*;

import java.util.Date;
import java.util.Scanner;

public class HumanCreator {
    public static int humanCreator(){
        String s;
        String name;
        Coordinates coordinates;
        Date creationDate;
        boolean realHero;
        boolean hasToothpick;
        double impactSpeed;
        WeaponType weaponType = null;
        Mood mood = null;
        Car car;
        Long x;
        double y;
        String CarName;
        boolean CarCool;

        String flow = "";

        Scanner in = new Scanner(System.in);

        System.out.print("Введите Name: ");
        while (true){
            s = in.next();
            if(isString(s)){
                name = s;
                break;
            }else {
                System.out.print("Введите Name без чисел: ");
            }
        }

        System.out.print("Is realHero?(true/false): ");
        while (true){
            String ct = in.next().toLowerCase();
            if(ct.equals("true") || ct.equals("false")){
                realHero = Boolean.parseBoolean(ct);
                break;
            }else {
                System.out.println("Введены неправильные данные");
                System.out.print("Is realHero?(true/false): ");
            }
        }

        System.out.print("Has toothPick?(true/false): ");
        while (true){
            String ct = in.next().toLowerCase();
            if(ct.equals("true") || ct.equals("false")){
                hasToothpick = Boolean.parseBoolean(ct);
                break;
            }else {
                System.out.println("Введены неправильные данные");
                System.out.print("Has toothPick?(true/false): ");

            }
        }
        System.out.print("Введите impactSpeed: ");
        while (true){
            s = in.next();
            if(isDigit(s)){
                impactSpeed = Double.parseDouble(s);
                break;
            }else {
                System.out.print("Введите impactSpeed в формате числа: ");
            }
        }


        System.out.print("Введите Coordinate X: ");
        while (true){
            s = in.next();
            if(isDigit(s)){
                x = Long.valueOf(s);
                break;
            }else {
                System.out.print("Введите Coordinate X в формате числа: ");
            }
        }
        System.out.print("Введите Coordinate Y: ");
        while (true){
            s = in.next();
            if(isDigit(s)){
                y = Double.parseDouble(s);
                break;
            }else {
                System.out.print("Введите Coordinate Y: ");
            }
        }


        coordinates = new Coordinates(x,y);

        System.out.print("Введите Car Name: ");
        while (true){
            s = in.next();
            if(isString(s)){
                CarName = s;
                break;
            }else {
                System.out.print("Введите Car Name без чисел: ");
            }
        }
        System.out.print("Is Car Cool?(true/false): ");
        while (true){
            String ct = in.next().toLowerCase();
            if(ct.equals("true") || ct.equals("false")){
                CarCool = Boolean.parseBoolean(ct);

                break;
            }else {
                System.out.println("Введены неправильные данные");
                System.out.print("Is Car Cool?(true/false): ");

            }
        }

        car = new Car(CarName, CarCool);
        System.out.print("Введите WeaponType(AXE, BAT, PISTOL): ");
        while (true){
            String ct = in.next().toUpperCase();
            if(ct.equals("AXE") || ct.equals("BAT") || ct.equals("PISTOL")){
                weaponType = WeaponType.valueOf(ct);


                break;
            }else {
                System.out.println("Введен неправильный WeaponType");
                System.out.print("Введите WeaponType(AXE, BAT, PISTOL): ");


            }
        }
        System.out.print("Введите Mood(APATHY, FRENZY, CALM, GLOOM): ");
        while (true){
            String ct = in.next().toUpperCase();
            if(ct.equals("APATHY") || ct.equals("FRENZY")
                    || ct.equals("CALM") || ct.equals("GLOOM")){
                mood = Mood.valueOf(ct);


                break;

            }else {
                System.out.println("Введен неправильный Mood");
                System.out.print("Введите Mood(APATHY, FRENZY, CALM, GLOOM): ");
            }
        }


        creationDate = new Date();

        HumanBeingLHS.Human_BeingDataBase.add(new HumanBeing(name,
                coordinates,
                creationDate,
                realHero,
                hasToothpick,
                impactSpeed,
                weaponType,
                mood,
                car));
        return 0;
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isString(String s){
        if (s.matches("^[^0-9]*$")){
            return true;
        }else {
            return false;
        }
    }
}
