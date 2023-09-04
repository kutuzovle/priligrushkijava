package toymarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStock toyStock = new ToyStock();
        ToyQueueExtradition toyQueueExtradition = new ToyQueueExtradition();

        boolean run = true;
        Scanner scan = new Scanner(System.in);
        while (run){
            System.out.println("Введите команду: ");
            System.out.println("1. Put название_игрушки количество_игрушек " +
                    "шанс_выпадения (Добавим игрушки на склад)");
            System.out.println("2. Draw (разыграем игрушку)");
            System.out.println("3. Get id_игрушки (для получения выигранной " +
                    "игрушки)");
            System.out.println("4. Exit (для выхода)");
            String[] command = scan.nextLine().split(" ");
            switch (command[0].toLowerCase()){
                case "put":
                    try {
                        toyStock.addToStock(new Toy(command[1],
                                Integer.parseInt(command[2]),
                                Integer.parseInt(command[3])));
                    } catch (Exception e){
                        System.out.println("Команда введена неправильно! " +
                                "Повторите ввод!");
                    }
                    break;
                case "draw":
                    toyQueueExtradition.addToExtradition(toyStock);
                    break;
                case "get":
                    try {
                        toyQueueExtradition.deleteFromExtradition(Integer.parseInt(command[1]));
                    } catch (Exception e){
                        System.out.println("Команда введена неправильно! " +
                                "Повторите ввод!");
                    }
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("Введите правильную команду");
            }
        }
    }
}
