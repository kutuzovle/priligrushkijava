package toymarket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ToyQueueExtradition{
    private final HashMap<Integer, Toy> toyHashMap;

    public ToyQueueExtradition() {
        this.toyHashMap = new HashMap<>();
    }
    public void addToExtradition(ToyStock toyStock){
        int id = DrawToys.draw(toyStock);
        if(toyStock.containsID(id)) {
            System.out.println("ID игрушки для получения. Запомните его! " + id);
            if (toyHashMap.containsKey(id)) {
                Toy toy = toyStock.get(id);
                toy.setCountExtradition(toy.getCountExtradition() + 1);
                toyStock.deleteFromStock(id);
            } else {
                Toy toy = toyStock.get(id);
                toy.setCountExtradition(1);
                toyHashMap.put(toy.getId(), toy);
                toyStock.deleteFromStock(id);
            }
        } else{
            System.out.println("Склад пуст, нечего разыгрывать");
        }
    }
    public void deleteFromExtradition(int id){
        if(toyHashMap.containsKey(id)){
            Toy toy = toyHashMap.get(id);
            toy.setCountExtradition(toy.getCountExtradition()-1);
            try(FileWriter fileWriter = new FileWriter("src/main" +
                    "/resources/Extradition.txt",
                    true)) {
                fileWriter.write(toy +"\n");
            } catch (IOException e) {
                System.err.println("Что-то пошло не так, повторите попытку");
            }
            if(toy.getCountExtradition() == 0){
                toyHashMap.remove(id);
            }
        } else{
            System.out.println("В списке на выдачу нет такой игрушки");
        }
    }

}
