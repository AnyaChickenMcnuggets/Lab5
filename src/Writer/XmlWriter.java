package Writer;

import Read.XmlParser;
import Source.HumanBeing;
import Source.HumanBeingLHS;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.StringTokenizer;

public class XmlWriter {
    public static int xmlWriter() throws IOException {
        String flow = "";

        Scanner in = new Scanner(System.in);


        System.out.print("Введите имя файла, куда вы хотите сохранить данные: ");
        String pathName = in.nextLine();
        PrintWriter writer = new PrintWriter(pathName);

        //записываем коллекцию в xml
        writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + "<Data>\n");
        for (HumanBeing h : HumanBeingLHS.Human_BeingDataBase){
            flow = h.getName();
            writer.print("\t<Human_Being>\n" + "\t\t<Name>" + flow + "</Name>\n");

            flow = String.valueOf(h.isRealHero());
            writer.print( "\t\t<realHero>" + flow + "</realHero>\n");

            flow = String.valueOf(h.isHasToothpick());
            writer.print("\t\t<hasToothpick>" + flow + "</hasToothpick>\n");

            flow = String.valueOf(h.getImpactSpeed());
            writer.print("\t\t<impactSpeed>" + flow + "</impactSpeed>\n");

            flow = String.valueOf(h.getCoordinates().getX());
            writer.print( "\t\t<Coordinates>\n" + "\t\t\t<X>" + flow + "</X>\n");

            flow = String.valueOf(h.getCoordinates().getX());
            writer.print("\t\t\t<Y>" + flow + "</Y>\n" + "\t\t</Coordinates>\n");

            flow = String.valueOf(h.getCar().getName());
            writer.print("\t\t<Car>\n" + "\t\t\t<Name>" + flow + "</Name>\n");

            flow = String.valueOf(h.getCar().isCool());
            writer.print("\t\t\t<Cool>" + flow + "</Cool>\n" + "\t\t</Car>\n");

            flow = String.valueOf(h.getWeaponType());
            writer.print("\t\t<WeaponType>"+ flow + "</WeaponType>\n");

            flow = String.valueOf(h.getMood());
            writer.print("\t\t<Mood>" + flow + "</Mood>\n" + "\t</Human_Being>\n");
        }
        writer.print( "</Data>");
        //закрываем поток
        writer.close();


        return 0;
    }
}
