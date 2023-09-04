package toymarket;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ToyStock {
    private final HashMap<Integer, Toy> toyHashMap;
    public ToyStock() {
        this.toyHashMap = new HashMap<>();
    }
    public void addToStock(Toy toy){
        if(toyHashMap.size() == 0){
            toy.setId(0);
            toyHashMap.put(toy.getId(),toy);
        }else {
            toy.setId(getMaxID() + 1);
            toyHashMap.put(getMaxID() + 1, toy);
        }
    }
    private int getMaxID(){
        int maxID = 0;
        List<Integer> keys = new ArrayList<>(toyHashMap.keySet());
        if(keys.size()>0){
            for (Integer key: keys) {
                if(maxID < key) maxID = key;
            }
        }
        return maxID;
    }
    public void deleteFromStock(int id){
        if(toyHashMap.containsKey(id)){
            Toy toy = toyHashMap.get(id);
            toy.setCountStock(toy.getCountStock()-1);
            if(toy.getCountStock() == 0) toyHashMap.remove(id);
        } else {
            System.out.println("На складе нет игрушки с данным ID");
        }
    }
    public int size(){
        return toyHashMap.size();
    }
    public Toy get(int key){
        return toyHashMap.get(key);
    }
    public boolean containsID(int id){
        return toyHashMap.containsKey(id);
    }
    public List<Integer> keySet(){
        return (List<Integer>) toyHashMap.keySet();
    }
}
