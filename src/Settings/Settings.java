package Settings;

import Read.TXTReader;
import Read.XmlParser;
import Source.HumanBeing;
import Source.HumanBeingLHS;
import Writer.HumanCreator;
import Writer.XmlWriter;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Settings {


    public static void settings(String command, String commandParameter) throws IOException {

            //проверка введенной комманды
            switch (command){
                case ("help"):
                    if (commandParameter.equals("")) {
                        //System.out.println("help : вывести справку по доступным командам");
                        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата\n" +
                                "инициализации, количество элементов и т.д.)");
                        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом\n" +
                                "представлении");
                        System.out.println("add {element} : добавить новый элемент в коллекцию");
                        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
                        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
                        System.out.println("clear : очистить коллекцию");
                        System.out.println("save : сохранить коллекцию в файл");
                        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте\n" +
                                "содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном\n" +
                                "режиме");
                        System.out.println("exit : завершить программу (без сохранения в файл)");
                        System.out.println("add_if_max {element} : добавить новый элемент в коллекцию, если его значение\n" +
                                "превышает значение наибольшего элемента этой коллекции");
                        System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
                        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
                        System.out.println("group_counting_by_car : сгруппировать элементы коллекции по значению поля car,\n" +
                                "вывести количество элементов в каждой группе");
                        System.out.println("filter_greater_than_impact_speed impactSpeed : вывести элементы, значение поля\n" +
                                "impactSpeed которых больше заданного");
                        System.out.println("print_descending : вывести элементы коллекции в порядке убывания");
                    }else {
                        System.out.println("Команда введена неправильно");
                    }
                    break;
                case ("info"):
                    if (commandParameter.equals("")) {
                        System.out.println(HumanBeingLHS.Human_BeingDataBase.size());
                    }else {
                        System.out.println("Команда введена неправильно");
                    }
                    break;
                case ("print_descending "):
                    if (commandParameter.equals("")) {
                    }else {
                        System.out.println("Команда введена неправильно");
                    }
                    break;
                case ("add"):
                    //новый HumanBeing
                    int f = HumanCreator.humanCreator();

                    break;
                case ("update"):
                    //id и элемент
                    break;
                case ("remove_by_id"):
                    //id

                    break;
                case ("clear"):
                    if (commandParameter.equals("")) {
                        //очистить
                        HumanBeingLHS.Human_BeingDataBase.clear();
                        System.out.println("Коллекция очищена");
                    }else {
                        System.out.println("Команда введена неправильно");
                    }

                    break;
                case ("save"):
                    if (commandParameter.equals("")) {

                        if(HumanBeingLHS.Human_BeingDataBase.isEmpty()){
                            System.out.println("Коллекция пуста");
                            break;
                        }
                        int q = XmlWriter.xmlWriter();
                        System.out.println("Сохранено");

                    }else {
                        System.out.println("Команда введена неправильно");
                    }
                    break;
                case ("execute_script"):

                    System.out.println(commandParameter);
                    //TXTReader.txtReader(commandParameter);
                    break;
                case ("add_if_max"):
                    break;
                case ("remove_greater"):
                    break;
                case ("remove_lower"):
                    break;
                case ("group_counting_by_car"):
                    break;
                case ("filter_greater_than_impact_speed"):
                    break;
                case ("exit"):
                    if (commandParameter.equals("")) {
                        System.out.println("До свидания!");
                        System.exit(0);
                    }else {
                        System.out.println("Команда введена неправильно");
                        break;
                    }
                case ("show"):
                    if (commandParameter.equals("")) {
                        if(HumanBeingLHS.Human_BeingDataBase.isEmpty()){
                            System.out.println("Коллекция пуста");
                            break;
                        }
                        //создаем итератор для списка
                        Iterator<HumanBeing> itr = HumanBeingLHS.Human_BeingDataBase.iterator();
                        while (itr.hasNext()){
                            System.out.println(itr.next());
                        }
                        //System.out.println(HumanBeingLHS.Human_BeingDataBase);

                        //печатаем содержимое всех элементов списка
                        for(HumanBeing h : HumanBeingLHS.Human_BeingDataBase){
                            System.out.println("№" + h.getId());
                            System.out.println(h.getName());
                            System.out.println(h.getCoordinates().getX());
                            System.out.println(h.getCoordinates().getY());
                            System.out.println(h.getCreationDate());
                            System.out.println(h.isRealHero());
                            System.out.println(h.isHasToothpick());
                            System.out.println(h.getImpactSpeed());
                            System.out.println(h.getWeaponType());
                            System.out.println(h.getMood());
                            System.out.println(h.getCar().getName());
                            System.out.println(h.getCar().isCool() + "\n\n");
                        }
                    }else {
                        System.out.println("Команда введена неправильно");
                    }

                    break;
            }
        //}while скобка
    }

}
