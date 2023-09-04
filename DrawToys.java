package toymarket;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DrawToys {
    public static int draw(ToyStock toys){
        if(toys.size()>0) {
            int[] drop = new int[toys.size()];
            int[] chance = new int[toys.size()];
            for (int i = 0; i < toys.size(); i++) {
                if(toys.containsID(i)) {
                    drop[i] = toys.get(i).getId();
                    chance[i] = toys.get(i).getDrop();
                } else {
                    List<Integer> idList = new ArrayList<>(toys.keySet());
                    Random irand = new Random(idList.size());
                    int id = irand.nextInt();
                    drop[i] = toys.get(idList.get(id)).getId();
                    chance[i] = toys.get(idList.get(id)).getDrop();
                }
            }
            int count = IntStream.of(chance).sum();
            Random random = new Random();
            for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {
                int index = random.nextInt(count);
                for (int i = 0; i < chance.length; i++) {
                    index -= chance[i];
                    if (index < 0) {
                        return drop[i];
                    }
                }
            }
            return -1;
        } return -1;
    }
}