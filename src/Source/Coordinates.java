package Source;

import Exceptions.MyGreaterException;
import Exceptions.MyNullException;

public class Coordinates {
    //параметры класса Coordinates
    private Long x;
    private double y;

    public Coordinates(Long x, double y) {
        //проверяем условие
        try {
            if (x == null) {
                throw new MyNullException("Error null Long");
            }
            long MAX_X = 622L;
            double MAX_Y = 480;
            if (x >= MAX_X || y >= MAX_Y) {
                throw new MyGreaterException("Error greater number");
            }
            this.x = x;
            this.y = y;
        } catch (MyNullException | MyGreaterException e) {
            e.printStackTrace();
        }
    }
    //функции класса для получения значения параметров

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
