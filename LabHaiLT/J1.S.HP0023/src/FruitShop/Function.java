package FruitShop;

import java.util.Hashtable;
import Components.*;
import Validation.Validation;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class Function {

    Hashtable<String, FruitList> orders = new Hashtable<String, FruitList>();
    FruitList flist = new FruitList();
    Validation v = new Validation();

    public void displayFruit(FruitList flist) {
        Fruit f = new Fruit();
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Quantity ++ | ++ Price ++ |");
        for (Fruit fruit : flist) {
            System.out.format("%-12d | %-16s | %-12s | %-14d | %-12.3f|\n", fruit.getFruitid(), fruit.getFruitname(), fruit.getOrigin(), fruit.getQuantity(), fruit.getPrice());
        }
    }

    public void displayFruit(Fruit fruit) {
        System.out.format("%-12d | %-16s | %-12s | %-14d | %-12.3f|\n", fruit.getFruitid(), fruit.getFruitname(), fruit.getOrigin(), fruit.getQuantity(), fruit.getPrice());
    }

    public void displayOrderFruit(Fruit fruit) {
        System.out.format("| %-16s | %-12s | %-14d | %-12.3f| %-12.2f$\n", fruit.getFruitname(), fruit.getOrigin(), fruit.getQuantity(), fruit.getPrice(), fruit.getQuantity() * fruit.getPrice());
    }

    public void createFruit() {
        do {
            Fruit f = new Fruit();
            while (true) {
                f.setFruitid(v.getInt("Input fruit id: ", 1, Integer.MAX_VALUE));
                if (flist.isEmpty()) {
                    break;
                }
                if (flist.find(f.getFruitid()) == null) {
                    break;
                }
                System.out.println("Fruit id is duplicate!");
                return;
            }
            f.setFruitname(v.getString("Input fruit name: "));
            f.setPrice(v.getDouble("Input fruit price: ", 0, Double.MAX_VALUE));
            f.setQuantity(v.getInt("Input fruit quantity: ", 0, Integer.MAX_VALUE));
            f.setOrigin(v.getString("Input fruit origin: "));
            flist.add(f);
        } while (v.getYN("Do you want to continue?(Y/N): "));
    }

    public void updateFruit() {
        int id = v.getInt("Input fruit id: ", 1, Integer.MAX_VALUE);
        Fruit f = flist.find(id);
        if (f != null) {
            f.setQuantity(v.getInt("Input fruit quantity: ", 0, Integer.MAX_VALUE));
            return;
        }
        if (v.getYN("Id not found, do you want to create new fruit?(Y/N): ")) {
            Fruit f2 = new Fruit();
            f2.setFruitid(id);
            f2.setFruitname(v.getString("Input fruit name: "));
            f2.setPrice(v.getDouble("Input fruit price: ", 1, Double.MAX_VALUE));
            f2.setQuantity(v.getInt("Input fruit quantity: ", 1, Integer.MAX_VALUE));
            f2.setOrigin(v.getString("Input fruit origin: "));
            flist.add(f2);
        }
    }

    public void shopping() {
        if (flist.isEmpty()) {
            System.out.println("Storage empty, nothing to buy");
            return;
        }
        FruitList orderList = new FruitList();
//        FruitList flist = new FruitList();

//        for (Fruit fruit : flist) {
//            if (fruit.getQuantity() != 0) {
//                flist2.add(fruit);
//            }
//        }
        //loop and remove fruit quantity=0
        do {
//            for (int i = 0; i < flist.size(); i++) {
//                if (flist.get(i).getQuantity() == 0) {
//                    flist.remove(i);
//                    i--;
//                }
//            }

            if (flist.isEmpty()) {
                System.out.println("Storage empty, nothing to buy");
                break;
            }

            displayFruit(flist);

            //get the index of the fruit in the list
            int index = v.getInt("Select fruit to buy: ", 1, flist.size()) - 1;
//            while (flist.get(index).getQuantity() == 0) {
//                index++;
//            }

            //point to the fruit
            Fruit orderFruit = flist.get(index);
            System.out.printf("You selected: %s", orderFruit.getFruitname());

            //input fruit quantity
            int orderQuantity = v.getInt("\nInput quantity: ", 0, orderFruit.getQuantity());
            orderFruit.setQuantity(orderFruit.getQuantity() - orderQuantity);
            if (orderFruit.getQuantity() == 0) {
                flist.remove(orderFruit);
            }

            //create a clone of the fruit and add to the orderList
            Fruit temp = new Fruit(orderFruit.getFruitid(), orderFruit.getFruitname(), orderFruit.getOrigin(), orderQuantity, orderFruit.getPrice());

            //check in the orderList if the orderFruit already in the list, add the quantity
            boolean check = false;
            for (Fruit fruit : orderList) {
                if (fruit.getFruitid() == orderFruit.getFruitid()) {
                    fruit.setQuantity(fruit.getQuantity() + orderQuantity);
                    check = true;
                    break;
                }
            }

            //if not, add the temp in the list
            if (check == false) {
                orderList.add(temp);
            }
        } while (v.getYN("Do you want to continue shopping?(Y/N)"));
        if (orderList.isEmpty()) {
            return;
        }
        System.out.println("| ++ Fruit Name ++ | ++ Origin ++ | ++ Quantity ++ | ++ Price ++ | ++ Amount ++ |");

        //sort the orderlist by quantity in descending order
        Collections.sort(orderList);
        double total = 0;
        for (Fruit fruit : orderList) {
            displayOrderFruit(fruit);
            total += fruit.getQuantity() * fruit.getPrice();
        }
        System.out.printf("Total: %.3f$\n", total);
        String cusname = v.getString("Input your name: ");
        while (orders.containsKey(cusname)) {
            cusname += " ";
        }
        orders.put(cusname, orderList);
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders, nothing to view");
            return;
        }
        //Iterate through orders
        for (Map.Entry<String, FruitList> entry : orders.entrySet()) {
            double total = 0;
            String key = entry.getKey();
            FruitList value = entry.getValue();
            System.out.printf("\nCustomer: %s\n", entry.getKey().trim());
            System.out.println("| ++ Fruit Name ++ | ++ Origin ++ | ++ Quantity ++ | ++ Price ++ | ++ Amount ++ |");
            for (Fruit fruit : value) {
                displayOrderFruit(fruit);
                total += fruit.getQuantity() * fruit.getPrice();
            }
            System.out.printf("Total: %.3f\n", total);
        }
    }

    public void add() {
        Fruit f = new Fruit();
        f.setFruitid(1);
        f.setFruitname("Lemon");
        f.setOrigin("Vietnam");
        f.setPrice(2.2);
        f.setQuantity(8);
        flist.add(f);

        Fruit f2 = new Fruit();
        f2.setFruitid(2);
        f2.setFruitname("Apple");
        f2.setOrigin("America");
        f2.setPrice(4.1);
        f2.setQuantity(0);
        flist.add(f2);

        Fruit f3 = new Fruit();
        f3.setFruitid(3);
        f3.setFruitname("Grape");
        f3.setOrigin("Austalia");
        f3.setPrice(4.1);
        f3.setQuantity(11);
        flist.add(f3);
    }
}
