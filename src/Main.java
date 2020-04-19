
import Read.TXTReader;
import Read.XmlParser;
import Source.HumanBeing;
import Source.HumanBeingLHS;
import Settings.Settings;
import Source.Car;
import Source.WeaponType;

import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    //переменная для выдачи id по колличеству HumanBeing



    String szAppName;

    public Main()
    {
        szAppName = new String("Добро пожаловать.");
    }
    public static void main(String[] args) throws IOException {
        Main sc = new Main();
        System.out.println(sc.szAppName);

        String command = "";
        String commandParameter = "";
        byte bKbd[] = new byte[256];
        StringTokenizer st;

        //узнаем начальные данные
        while (XmlParser.f==0) {
            System.out.println("Введите переменную окружения: ");

            int iCnt = System.in.read(bKbd);
            command = new String(bKbd, 0, iCnt);

            st = new StringTokenizer(command, "\r\n");
            command = String.valueOf(st.nextElement());
            //входим в парсер
            int res = XmlParser.readXMLFILE(command);
        }

        //мониторим команды
        while (true) {
            System.out.println("help : вывести справку по доступным командам ");

            System.out.print("Введите команду: ");
            int iCnt = System.in.read(bKbd);
            command = new String(bKbd, 0, iCnt);

            st = new StringTokenizer(command, " \n");
            command = String.valueOf(st.nextElement());
            System.out.println(command);
            if(st.hasMoreElements()){
                commandParameter = String.valueOf(st.nextElement());
            }


            if (!st.hasMoreElements()) {
                System.out.println("Введено: " + command + " " + commandParameter);
                Settings.settings(command, commandParameter);
                commandParameter = "";
            }else{
                System.out.println("Введена неправильная команда");
            }

        }
    }
}
