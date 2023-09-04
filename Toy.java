package toymarket;

public class Toy {
    private int id;
    private String name;
    private int countStock;
    private int drop;
    private int countExtradition;

    public Toy(String name, int count, int drop){
        this.name = name;
        this.countStock = count;
        this.drop = drop;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCountStock(int countStock){
        this.countStock = countStock;
    }
    public int getCountStock(){
        return countStock;
    }

    public int getId() {
        return id;
    }

    public int getDrop() {
        return drop;
    }

    public void setCountExtradition(int countExtradition) {
        this.countExtradition = countExtradition;
    }

    public int getCountExtradition() {
        return countExtradition;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
