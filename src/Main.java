
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/nikitasakun/Desktop/Java project/TA_LAB3_IP92_SAKUN_NIKITA/src/FileTA");
        ObjectInputStream oin = new ObjectInputStream(fis);
        Btree btree1 = (Btree)oin.readObject();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.print("Введите что вы ходите сделать с деревом:\n1)stop - закончить программу;\n2)add - добавить вершину в дерево;\n3)del - удалить вершину с дерева;\n4)search - найти вершину;\nВаш выбор:  ");
            String str = scanner.next();
            switch (str) {
                case "stop":
                    break label;
                case "add":
                    System.out.print("Хотите (заполнить) дерево рандомными элементами или (вручную) добавить вершину: ");
                    String str1 = scanner.next();
                    if (str1.equals("вручную")) {
                        System.out.print("Введите значение которое хотите вставить в дерево: ");
                        btree1.insert(scanner.nextInt());
                    } else if (str1.equals("заполнить")) {
                        System.out.print("Введите сколько значений хотите добавить: ");
                        int number = scanner.nextInt();
                        for (int i = 0; i < number; i++) {
                            btree1.insert((int) (Math.random() * (20000 + 1)) - 10000);
                        }
                    } else {
                        System.out.println("Такого варианта нет!Попробуйте сново!");
                    }


                    break;
                case "del":
                    System.out.print("Введите значение которое хотите удалить из дерева: ");
                    btree1.delete(scanner.nextInt());
                    break;
                case "search":
                    System.out.print("Введите значение которое хотите найти в дереве: ");
                    if (btree1.search(scanner.nextInt())) {
                        System.out.println("Вершина найдена!");
                    } else {
                        System.out.println("Вершина отсутствует!");
                    }
                    break;
                default:
                    System.out.println("Такого варианта нет!");
                    break;
            }
        }
        //Сериализация в файл с помощью класса ObjectOutputStream
        FileOutputStream fos = new FileOutputStream("/Users/nikitasakun/Desktop/Java project/TA_LAB3_IP92_SAKUN_NIKITA/src/FileTA");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(btree1);
        oos.flush();
        oos.close();


    }

}
