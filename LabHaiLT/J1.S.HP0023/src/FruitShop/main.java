package FruitShop;

import Components.FruitList;
import Validation.Validation;
import FruitShop.Function;

public class main {

    public static void main(String[] args) {
        int choice = 0;
        Function f = new Function();
        while (choice != 5) {
            System.out.println("FRUIT SHOP SYSTEM\n    1. Create fruit\n    2. Update fruit\n    3. View orders\n    4. Shopping\n    5. Exit\n    6. Add demo");
            choice = Validation.getInt("Input choice: ", 1, 6);
            switch (choice) {
                case 1:
                    f.createFruit();
                    f.displayFruit(f.flist);
                    break;
                case 2:
                    f.updateFruit();
                    f.displayFruit(f.flist);
                    break;
                case 3:
                    f.viewOrders();
                    break;
                case 4:
                    f.shopping();
                    break;
                case 5:
                    break;
                case 6:
                    f.add();
                    break;
            }
        }
    }
}
