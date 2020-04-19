package Source;

import Exceptions.MyNullException;

public class Car {
    //параметры класса Car
    private String name;
    private boolean cool;

    public Car(String name, boolean cool) {
        //проверяем условие
        try {
            if (name == null) {
                throw new MyNullException("Error null string");
            }
            this.name = name;
            this.cool = cool;
        } catch (MyNullException e) {
            e.printStackTrace();
        }
    }
    //функции класса для получения значения параметров

    public String getName() {
        return name;
    }

    public boolean isCool() {
        return cool;
    }
}
