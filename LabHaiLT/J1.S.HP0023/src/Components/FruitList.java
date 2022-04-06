package Components;

import java.util.ArrayList;

public class FruitList extends ArrayList<Fruit> {

    public FruitList() {
    }
    
    public Fruit find(int id) {
        for (Fruit i : this) {
            if (i.getFruitid() == id) {
                return i;
            }
        }
        return null;
    }        
}
