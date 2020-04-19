package Read;

import Exceptions.MyNullException;
import Source.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.Scanner;


public class XmlParser {

    public static int f = 0;



    public static int readXMLFILE(String arg) {
        String line;

        try {
            if (System.getenv(String.valueOf(arg)) == null) {
                throw new MyNullException("Error null string");
            }
        }catch (MyNullException e){
            System.out.println("Переменная среды " + arg + " не объявлена");
            e.printStackTrace();
            return 0;
        }
        f++;
        File file = new File(System.getenv("PATHXML"));



        System.out.println("Попал в процедуру чтения");

        String name = new String();
        Coordinates coordinates = null;
        Date creationDate = new Date();
        boolean realHero = false;
        boolean hasToothpick = false;
        double impactSpeed = 0;
        WeaponType weaponType = null;
        Mood mood = null;
        Car car = null;
        Long x = null;
        double y = 0;
        String CarName = new String();
        boolean CarCool;

        try {
            String fileText = new String("");
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Scanner scanner = new Scanner(file);
            //считываем xml в строку
            while (scanner.hasNext()) {
                scanner.findWithinHorizon("\n", 0);
                scanner.useDelimiter("\n");
                if (scanner.hasNext()){

                    fileText += scanner.next() + "\n";
                }
            }
            //System.out.println(fileText); //печать строки
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(fileText));

            Document document = documentBuilder.parse(is);
            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            // Просматриваем все подэлементы корневого
            NodeList Humans = root.getChildNodes();
            for (int i = 0; i < Humans.getLength(); i++) {
                //обнуляем переменные
                name = null;
                coordinates = null;
                creationDate = new Date();
                realHero = false;
                hasToothpick = false;
                impactSpeed = 0;
                weaponType = null;
                mood = null;
                car = null;
                x = null;
                y = 0;
                CarName = null;
                CarCool = false;
                Node Human = Humans.item(i);
                // Если Node не текст, то это HumanBeing - заходим внутрь
                if (Human.getNodeType() != Node.TEXT_NODE) {
                    NodeList HumanProps = Human.getChildNodes();
                    for(int j = 0; j < HumanProps.getLength(); j++) {

                        Node HumanProp = HumanProps.item(j);
                        // Если Node не текст, то это один из параметров HumanBeing - печатаем
                        if (HumanProp.getNodeType() != Node.TEXT_NODE) {
                            //печать строк
                            // System.out.println(HumanProp.getNodeName() + ":" + HumanProp.getChildNodes().item(0).getTextContent());
                            //проверяем название параметра
                            switch (HumanProp.getNodeName()) {
                                case ("Name"):
                                    name = HumanProp.getChildNodes().item(0).getTextContent();
                                    break;
                                case ("realHero"):
                                    realHero = Boolean.valueOf(HumanProp.getChildNodes().item(0).getTextContent());
                                    break;
                                case ("hasToothpick"):
                                    hasToothpick = Boolean.valueOf(HumanProp.getChildNodes().item(0).getTextContent());
                                    break;
                                case ("impactSpeed"):
                                    impactSpeed = Double.valueOf(HumanProp.getChildNodes().item(0).getTextContent());
                                    break;
                                case ("WeaponType"):
                                    weaponType = WeaponType.valueOf(HumanProp.getChildNodes().item(0).getTextContent());
                                    break;
                                case ("Mood"):
                                    mood = Mood.valueOf(HumanProp.getChildNodes().item(0).getTextContent());
                                    break;
                                case ("Coordinates"):
                                    //System.out.println(HumanProp.getNodeName());
                                    //проверяем вложенные параметры
                                    NodeList CoordinatesXY = HumanProp.getChildNodes();
                                    for (int k =0; k < CoordinatesXY.getLength();k++) {
                                        Node CoordinateXY = CoordinatesXY.item(k);
                                        //System.out.println(CoordinateXY.getNodeName());

                                        switch (CoordinateXY.getNodeName()){
                                            case("X"):
                                                x = Long.valueOf(CoordinateXY.getChildNodes().item(0).getTextContent());
                                                break;
                                            case ("Y"):
                                                y = Double.valueOf(CoordinateXY.getChildNodes().item(0).getTextContent());
                                                break;
                                        }
                                    }
                                    coordinates = new Coordinates(x,y);
                                    //System.out.println(String.valueOf(coordinates.getX()) + " " + String.valueOf(coordinates.getY()));
                                    //System.out.println("Напечатали координаты");
                                    break;
                                case("Car"):
                                    NodeList Cars = HumanProp.getChildNodes();
                                    //проверяем вложенные параметры
                                    for (int k=0; k < Cars.getLength();k++){
                                        Node CarI = Cars.item(k);
                                        switch (CarI.getNodeName()){
                                            case ("Name"):
                                                CarName = CarI.getChildNodes().item(0).getTextContent();
                                                break;
                                            case ("Cool"):
                                                CarCool = Boolean.valueOf(CarI.getChildNodes().item(0).getTextContent());
                                                break;
                                        }
                                    }
                                    car = new Car(CarName, CarCool);
                                    break;
                            }
                        }
                    }
                    //System.out.println("===========>>>>");
                    //System.out.println("Запускаю конструктор класса");
                    //после того как мы узнали все параметры, мы вызываем конструктор класса, сразу добовляя его в список
                    HumanBeingLHS.Human_BeingDataBase.add(new HumanBeing(name,
                            coordinates,
                            creationDate,
                            realHero,
                            hasToothpick,
                            impactSpeed,
                            weaponType,
                            mood,
                            car));

                }


            }
           // System.out.println("Чтение закончено");

            return 0;
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }


}


